package com.liyou.product.facade;

import com.liyou.framework.base.model.Response;
import com.liyou.framework.page.PageRequestCustom;
import com.liyou.product.ReportFacade;
import com.liyou.product.biz.ReportService;
import com.liyou.product.common.annotations.Product;
import com.liyou.product.common.model.AnalyticsObjectTypeEnum;
import com.liyou.product.common.model.AnalyticsSort;
import com.liyou.product.common.model.IndexService;
import com.liyou.product.common.model.IndexValue;
import com.liyou.product.common.model.criteria.HistoryIndexQuery;
import com.liyou.product.enumeration.EstateDataType;
import com.liyou.product.enumeration.HouseDimension;
import com.liyou.product.enumeration.HouseSegmentEnum;
import com.liyou.product.model.HousePriceAreaSegmentData;
import com.liyou.product.model.IndexDataCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * @Auther: ltc
 * @Date: 2018/11/6 12:28
 * @Description:
 */
public class ReportFacadeImpl implements ReportFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportFacadeImpl.class);

    @Autowired
    @Qualifier("historyIndexServiceImpl")
    private IndexService historyIndexService;

    @Autowired
    private ReportService reportService;

    @Override
    @Product("findHistoryIndex")
    public Response<IndexDataCollection> findHistoryIndex(HistoryIndexQuery query) {
        try {
            AnalyticsSort[] sorts = query.getAnalyticsSorts().toArray(new AnalyticsSort[]{});
            List<IndexValue> data = historyIndexService
                    .find(query.getIndexes(), query.getAnalyticsObjects(), query.getRanges(), new PageRequestCustom(0, query.getLimit()), sorts);

            return Response.success(new IndexDataCollection(data));
        } catch (Exception e) {
            LOGGER.info("获取历史指标", e);
            return Response.failure(e);
        }
    }

    @Override
    @Product("getHousePriceAreaSegmentDataList")
    public Response<List<HousePriceAreaSegmentData>> getHousePriceAreaSegmentDataList(Integer cityId, AnalyticsObjectTypeEnum analyticsObjectType,
                                                                                      Integer targetId, HouseSegmentEnum houseSegmentEnum,
                                                                                      HouseDimension dimension, EstateDataType estateDataType, int
                                                                                              year, int month) {
        try {
            return Response.success(reportService.getHousePriceAreaSegmentDataList(cityId, analyticsObjectType,
                    targetId, houseSegmentEnum, dimension, estateDataType, year,
                    month));
        } catch (Exception e) {
            LOGGER.warn("查询总价段，面积段，单价段数据", e);
            return Response.failure(e);
        }
    }
}