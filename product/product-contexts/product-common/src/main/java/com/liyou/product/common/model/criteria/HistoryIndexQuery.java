package com.liyou.product.common.model.criteria;

import com.google.common.collect.Lists;
import com.liyou.product.common.model.AnalyticsSort;
import com.liyou.product.common.model.AnalyticsObject;
import com.liyou.product.common.model.IndexEnum;
import com.liyou.product.common.model.Range;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/***
 *
 *   @author linxiaohui
 *   @date 2018/5/17
 ***/
public class HistoryIndexQuery implements Serializable{

    private Integer limit = 100;

    /**
     * 要查询的指标
     */
    @NotNull
    private List<IndexEnum> indexes = Lists.newArrayList();

    /**
     * 要查询的范围
     */
    @NotNull
    @NotEmpty
    private List<Range> ranges = Lists.newArrayList();

    /**
     * 要查询的分析对象
     */
    @NotNull
    @NotEmpty
    private List<AnalyticsObject> analyticsObjects = Lists.newArrayList();


    /**
     * 排序
     */
    private List<AnalyticsSort> analyticsSorts = Lists.newArrayList();

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<IndexEnum> getIndexes() {
        return indexes;
    }

    public HistoryIndexQuery addIndex(IndexEnum ... indexes){

        for(IndexEnum i : indexes){
            this.indexes.add(i);
        }
        return this;
    }

    public HistoryIndexQuery addRange(Range ... ranges){
        for(Range i : ranges){
            this.ranges.add(i);
        }
        return this;
    }

    public HistoryIndexQuery addAnalyticsObject(AnalyticsObject ... analyticsObjects){
        for(AnalyticsObject i : analyticsObjects){
            this.analyticsObjects.add(i);
        }
        return this;
    }

    public void setIndexes(List<IndexEnum> indexes) {
        this.indexes = indexes;
    }

    public List<Range> getRanges() {
        return ranges;
    }

    public void setRanges(List<Range> ranges) {
        this.ranges = ranges;
    }

    public List<AnalyticsObject> getAnalyticsObjects() {
        return analyticsObjects;
    }

    public void setAnalyticsObjects(List<AnalyticsObject> analyticsObjects) {
        this.analyticsObjects = analyticsObjects;
    }

    public List<AnalyticsSort> getAnalyticsSorts() {
        return analyticsSorts;
    }

    public void setAnalyticsSorts(List<AnalyticsSort> analyticsSorts) {
        this.analyticsSorts = analyticsSorts;
    }
}
