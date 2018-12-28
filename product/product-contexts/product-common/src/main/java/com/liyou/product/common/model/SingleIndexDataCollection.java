package com.liyou.product.common.model;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/***
 *
 *   @author linxiaohui
 *   @date 2018/5/26
 ***/
public class SingleIndexDataCollection implements Serializable {

    private List<IndexValue> indexValues = Lists.newArrayList();

    public SingleIndexDataCollection() {
    }

    public SingleIndexDataCollection(List<IndexValue> indexValues) {
        this.indexValues = indexValues;
    }

    public List<IndexValue> getIndexValues() {
        return indexValues;
    }

    public void setIndexValues(List<IndexValue> indexValues) {
        this.indexValues = indexValues;
    }

    public Optional<IndexValue> first(){
        return indexValues.stream().findFirst();
    }


    public IndexValue first(boolean mock){
        Optional<IndexValue> optional = indexValues.stream().findFirst();
        if( optional.isPresent() ){
            return optional.get();
        }
        return new IndexValue();
    }

    public IndexValue find(Range range, AnalyticsObject object, boolean mock){

        Optional<IndexValue> optional = indexValues.stream()
                .filter( e -> Objects.equals(range,e.getRange()) )
                .filter( e -> Objects.equals(e.getAnalyticsObject(),object) )
                .findFirst();
        if( optional.isPresent() ){
            return optional.get();
        }

        return mock ? new IndexValue() : null;
    }

    public IndexValue findSame(IndexValue indexValue, boolean mock){

        return find(indexValue.getRange(),indexValue.getAnalyticsObject(),mock);
    }

    public List<IndexValue> sorted(Comparator<IndexValue> comparator){

        return indexValues.stream().sorted(comparator).collect(Collectors.toList());
    }
}
