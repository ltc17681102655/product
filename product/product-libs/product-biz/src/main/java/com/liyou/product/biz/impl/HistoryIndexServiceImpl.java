package com.liyou.product.biz.impl;

import com.google.common.collect.Lists;
import com.liyou.framework.base.criteria.Expressions;
import com.liyou.framework.base.criteria.predicate.CompoundPredicate;
import com.liyou.framework.common.utils.TimeGapUtils;
import com.liyou.framework.jpa.support.JpaPageHelp;
import com.liyou.framework.page.PageRequestCustom;
import com.liyou.product.common.annotations.Product;
import com.liyou.product.common.model.*;
import com.liyou.product.biz.utils.Converts;
import com.liyou.product.dao.HistoryIndexRepo;
import com.liyou.product.dao.model.HistoryIndexEntity;
import com.liyou.product.dao.model.QHistoryIndexEntity;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 *
 *   @author linxiaohui
 *   @date 2018/5/17
 ***/
@Repository
@Transactional(readOnly = true)
public class HistoryIndexServiceImpl implements IndexService<IndexEnum, SimpleStatisticsTypeEnum> {

    @Autowired
    private HistoryIndexRepo historyIndexRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Product("报告商城指标数据")
    public List<IndexValue> find(List<IndexEnum> indexes, List<AnalyticsObject> analyticsObject, List<Range> range, PageRequestCustom custom,
                                 AnalyticsSort... analyticsSorts) {
        // 查询的时间范围
        List<Long> rangeList = range.stream().map(Range::rangeValue).collect(Collectors.toList());


        // 分析的对象
        List<String> analyticsNormal = analyticsObject.stream()
                .filter(e -> !(e instanceof HistoryIndexQueryHelp.FuzzyAnalytics))
                .map(e -> e.id()).collect(Collectors.toList());

        // 模糊搜索的对象
        List<String> analyticsFuzzy = analyticsObject.stream()
                .filter(e -> e instanceof HistoryIndexQueryHelp.FuzzyAnalytics)
                .map(e -> e.id())
                .collect(Collectors.toList());


        CompoundPredicate predicate = Expressions.and()
                .addIn("index", indexes)
                .addIn("rangeValue", rangeList);

        if (analyticsFuzzy.isEmpty()) {
            predicate.addIn("analyticsObject", analyticsNormal);
        } else {
            CompoundPredicate or = Expressions.or();
            if (CollectionUtils.isNotEmpty(analyticsNormal)) {
                or.addIn("analyticsObject", analyticsNormal);
            }
            analyticsFuzzy.forEach(e -> or.addBeginWith("analyticsObject", e));
            predicate.add(or);
        }

        List<Sort.Order> orders = null;
        if (null != analyticsSorts && analyticsSorts.length > 0) {
            orders = Arrays.stream(analyticsSorts).map(e -> builder(e, "")).collect(Collectors.toList());
        }

        if (Arrays.stream(analyticsSorts).anyMatch(e -> e == AnalyticsSort.MOM_ASC || e == AnalyticsSort.MOM_DESC)) {
            predicate.add(Expressions.isNotNull("monthOnMonth"));
        }
        if (Arrays.stream(analyticsSorts).anyMatch(e -> e == AnalyticsSort.YOY_ASC || e == AnalyticsSort.YOY_DESC)) {
            predicate.add(Expressions.isNotNull("yearOnYear"));
        }

        Pageable pageable = CollectionUtils.isNotEmpty(orders) ? JpaPageHelp.convert(custom, new Sort(orders)) : JpaPageHelp.convert(custom);

        Page<HistoryIndexEntity> data = this.historyIndexRepo.findAll(predicate, pageable);

        return data.getContent().stream().map(e -> Converts.convert2IndexValue(e)).collect(Collectors.toList());
    }

    @Override
    public List<IndexStatisticsValue> find(StatisticsObject<IndexEnum, SimpleStatisticsTypeEnum> statisticsObject, List<AnalyticsObject>
            analyticsObject, List<Range> range, Integer limit, boolean asc) {
        final JPAQueryFactory queryFactory = new JPAQueryFactory(this.entityManager);
        QHistoryIndexEntity historyIndex = QHistoryIndexEntity.historyIndexEntity;


        List<BooleanExpression> predicate = Lists.newArrayList();
        //指标
        predicate.add(historyIndex.index.in(statisticsObject.getIndexs()));

        //模糊查询
        List<String> fuzzyAnalytics = analyticsObject.stream()
                .filter(e -> e instanceof HistoryIndexQueryHelp.FuzzyAnalytics)
                .map(e -> e.id()).collect(Collectors.toList());

        //标准查询
        List<String> standardAnalytics = analyticsObject.stream()
                .filter(e -> !(e instanceof HistoryIndexQueryHelp.FuzzyAnalytics))
                .map(e -> e.id()).collect(Collectors.toList());

        List<Long> rangeValue = range.stream().map(e -> e.rangeValue()).collect(Collectors.toList());
        //范围
        predicate.add(historyIndex.rangeValue.in(rangeValue));


        NumberPath<Double> path = null;
        switch (statisticsObject.getStatisticsObjectType()) {
            case INDEX_VALUE: {
                path = historyIndex.value;
            }
            break;
            case INDEX_YOY: {
                path = historyIndex.yearOnYear;
            }
            break;
            case INDEX_MOM: {
                path = historyIndex.monthOnMonth;
            }
            break;
            default: {
                path = historyIndex.value;
            }
        }


        NumberExpression<Double> numberExpression = null;
        switch (statisticsObject.getStatistics()) {
            case AVG: {
                numberExpression = path.avg();
            }
            break;
            case SUM: {
                numberExpression = path.sum();
            }
            break;
            case MAX: {
                numberExpression = path.max();
            }
            break;
            case MIN: {
                numberExpression = path.min();
            }
            break;
            default: {
            }
        }

        final NumberExpression<Double> v = numberExpression;

        List<BooleanExpression> fuzzyAnalyticsCondition = Lists.newArrayList();

        //标准对象
        if (!standardAnalytics.isEmpty()) {
            fuzzyAnalyticsCondition.add(historyIndex.analyticsObject.in(standardAnalytics));
        } else {
            fuzzyAnalytics.forEach(e -> fuzzyAnalyticsCondition.add(historyIndex.analyticsObject.like(e + "%")));
            predicate.add(com.querydsl.core.types.dsl.Expressions.anyOf(fuzzyAnalyticsCondition.toArray(new BooleanExpression[]{})));
        }


        BooleanExpression where = com.querydsl.core.types.dsl.Expressions.allOf(predicate.toArray(new BooleanExpression[]{}));
        TimeGapUtils.start("指标分析:" + where);
        List<Tuple> tupleList = queryFactory.from(historyIndex)
                .select(historyIndex.analyticsObject, historyIndex.analyticsObjectName, v)
                .where(where)
                .groupBy(historyIndex.analyticsObject, historyIndex.analyticsObjectName)
                .limit(limit)
                .orderBy(asc ? v.asc() : v.desc())
                .fetch();

        TimeGapUtils.end("指标分析:" + where);

        return tupleList.stream().map(e -> {

            IndexStatisticsValue value = new IndexStatisticsValue();
            value.setAnalyticsObject(HistoryIndexQueryHelp.analytics(e.get(historyIndex.analyticsObject)));
            value.setAnalyticsObjectName(e.get(historyIndex.analyticsObjectName));
            value.setStatisticsObject(statisticsObject);
            value.setValue(e.get(v));

            return value;
        }).collect(Collectors.toList());
    }

    @Override
    public boolean supportIndex(Index index) {
        return index instanceof IndexEnum;
    }

    private Sort.Order builder(AnalyticsSort analyticsSort, String prefix) {

        if (analyticsSort == null) {
            analyticsSort = AnalyticsSort.INDEX_VALUE_ASC;
        }

        switch (analyticsSort) {
            case YOY_ASC:
                return new Sort.Order(Sort.Direction.ASC, prefix + "yearOnYear");
            case YOY_DESC:
                return new Sort.Order(Sort.Direction.DESC, prefix + "yearOnYear");
            case MOM_ASC:
                return new Sort.Order(Sort.Direction.ASC, prefix + "monthOnMonth");
            case MOM_DESC:
                return new Sort.Order(Sort.Direction.DESC, prefix + "monthOnMonth");
            case INDEX_VALUE_ASC:
                return new Sort.Order(Sort.Direction.ASC, prefix + "value");
            case INDEX_VALUE_DESC:
                return new Sort.Order(Sort.Direction.DESC, prefix + "value");
            default:
                return null;
        }
    }
}
