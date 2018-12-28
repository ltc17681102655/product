package com.liyou.product.common.model;

import java.io.Serializable;

/***
 *
 *   @author linxiaohui
 *   @date 2018/5/22
 ***/
public class IndexStatisticsValue<i extends Index,s extends Statistics> implements Serializable {


    private StatisticsObject<i,s> statisticsObject;

    /**
     * 值
     */
    private Double value;

    /***
     * 分析对象
     * @return
     */
    private AnalyticsObject analyticsObject;

    /**
     * 分析对象名称
     */
    private String analyticsObjectName;



    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public AnalyticsObject getAnalyticsObject() {
        return analyticsObject;
    }

    public void setAnalyticsObject(AnalyticsObject analyticsObject) {
        this.analyticsObject = analyticsObject;
    }

    public String getAnalyticsObjectName() {
        return analyticsObjectName;
    }

    public void setAnalyticsObjectName(String analyticsObjectName) {
        this.analyticsObjectName = analyticsObjectName;
    }

    public StatisticsObject<i,s> getStatisticsObject() {
        return statisticsObject;
    }

    public void setStatisticsObject(StatisticsObject<i,s> statisticsObject) {
        this.statisticsObject = statisticsObject;
    }
}
