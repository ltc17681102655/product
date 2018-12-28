package com.liyou.product.model;

import com.google.common.collect.Lists;
import com.liyou.product.common.model.*;
import org.apache.commons.collections.CollectionUtils;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/***
 *
 *   @author linxiaohui
 *   @date 2018/5/17
 ***/
public class IndexDataCollection implements Serializable {
    private List<IndexValue> indexValues = Lists.newArrayList();

    public IndexDataCollection() {

    }

    public IndexDataCollection(List<IndexValue> indexValues) {
        if (CollectionUtils.isNotEmpty(indexValues)) {
            this.indexValues = indexValues;
        }
    }

    public List<IndexValue> getIndexValues() {
        return indexValues;
    }

    public void setIndexValues(List<IndexValue> indexValues) {
        this.indexValues = indexValues;
    }

    public List<IndexValue> find(Index index) {
        return indexValues.stream().filter(e -> e.getIndex() == index).collect(Collectors.toList());
    }

    public Optional<IndexValue> find(Range range, Index index, AnalyticsObject object) {
        return indexValues.stream()
                .filter(e -> Objects.equals(e.getRange(), range))
                .filter(e -> Objects.equals(e.getIndex(), index))
                .filter(e -> Objects.equals(e.getAnalyticsObject(), object))
                .findFirst();
    }

    public Optional<IndexValue> findLatest(Index index, AnalyticsObject object) {
        return this.indexValues.stream()
                .filter(e -> Objects.equals(e.getIndex(), index))
                .filter(e -> Objects.equals(e.getAnalyticsObject(), object))
                .sorted(Comparator.comparing(IndexValue::getRange))
                .findFirst();
    }

    public SingleIndexDataCollection filter(Index index) {
        List<IndexValue> list = indexValues.stream().filter(e -> e.getIndex() == index).collect(Collectors.toList());
        return new SingleIndexDataCollection(list);
    }

    public Optional<IndexValue> first() {
        return indexValues.stream().findFirst();
    }

    public IndexValue first(boolean mock) {
        Optional<IndexValue> optional = indexValues.stream().findFirst();
        if (optional.isPresent()) {
            return optional.get();
        }
        return new IndexValue();
    }


//    /**
//     * group by range
//     * @return
//     */
//    public Map<Range,List<IndexValue>> groupR(){
//        return indexValues.stream().collect(Collectors.groupingBy(e-> e.getRange()));
//    }
//
//    /**
//     * group by analyticsObject
//     * @return
//     */
//    public Map<AnalyticsObject,List<IndexValue>> groupA(){
//        return indexValues.stream().collect(Collectors.groupingBy(e-> e.getAnalyticsObject()));
//    }
//
//    /**
//     * group by index
//     * @return
//     */
//    public Map<Index,List<IndexValue>> groupI(){
//        return indexValues.stream().collect(Collectors.groupingBy(e-> e.getIndex()));
//    }
//
//
//    /**
//     * group by range analyticsObject
//     * @return
//     */
//    public Map<Range,Map<AnalyticsObject,List<IndexValue>>> groupRA(){
//
//        Map<Range,List<IndexValue>> rangeListMap = groupR();
//
//        Map<Range,Map<AnalyticsObject,List<IndexValue>>> result = Maps.newHashMapWithExpectedSize(rangeListMap.size());
//
//        rangeListMap.forEach( (k,v) -> {
//            Map<AnalyticsObject,List<IndexValue>> value = v.stream()
//                    .collect(Collectors.groupingBy(e-> e.getAnalyticsObject()));
//            result.put(k,value);
//        } );
//
//        return result;
//    }
//
//    /**
//     * group by range analyticsObject index
//     * @return
//     */
//    public Map<Range,Map<AnalyticsObject,Map<Index,IndexValue>>> groupByRAI(){
//
//        Map<Range,List<IndexValue>> rangeListMap =  groupR();
//
//        Map<Range,Map<AnalyticsObject,Map<Index,IndexValue>>> result = Maps.newHashMapWithExpectedSize(rangeListMap.size());
//
//        rangeListMap.forEach( (k,v) -> {
//            Map<AnalyticsObject,List<IndexValue>> value = v.stream()
//                    .collect(Collectors.groupingBy(e-> e.getAnalyticsObject()));
//            //result.put(k,value);
//        } );
//
//        return result;
//    }
}
