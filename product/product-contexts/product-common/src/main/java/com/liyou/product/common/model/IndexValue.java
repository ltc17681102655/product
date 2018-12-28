package com.liyou.product.common.model;

import java.io.Serializable;

/***
 *   指标值
 *   @author linxiaohui
 *   @date 2018/5/15
 ***/
public class IndexValue<I extends Index> implements Serializable {


    /**
     * 指标
     */
    private I index;
    /**
     * 指标数值
     */
    private Double value;

    /**
     * 同比值
     */
    private Double yearOnYear = 0D;

    /**
     * 同比值 等于null
     */
    private Boolean yearOnYearIsNull = true;

    /**
     * 环比值
     */
    private Double monthOnMonth = 0D;

    /**
     * 环比值等于null
     */
    private Boolean monthOnMonthIsNull = true;


    /***
     * 分析对象
     * @return
     */
    private AnalyticsObject analyticsObject;

    /***
     * 分析时间范围
     * @return
     */
    private Range range;

    /**
     * 指标名称
     */
    private String analyticsObjectName;


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getYearOnYear() {
        return yearOnYear;
    }

    public void setYearOnYear(Double yearOnYear) {
        this.yearOnYear = yearOnYear;
        if(yearOnYear != null){
            this.yearOnYearIsNull=false;
        }

    }

    public Double getMonthOnMonth() {
        return monthOnMonth;
    }

    public void setMonthOnMonth(Double monthOnMonth) {
        this.monthOnMonth = monthOnMonth;
        if(monthOnMonth != null){
            this.monthOnMonthIsNull=false;
        }
    }

    public I getIndex() {
        return index;
    }

    public void setIndex(I index) {
        this.index = index;
    }

    public AnalyticsObject getAnalyticsObject() {
        return analyticsObject;
    }

    public void setAnalyticsObject(AnalyticsObject analyticsObject) {
        this.analyticsObject = analyticsObject;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public String getAnalyticsObjectName() {
        return analyticsObjectName;
    }

    public void setAnalyticsObjectName(String analyticsObjectName) {
        this.analyticsObjectName = analyticsObjectName;
    }

    public Boolean getYearOnYearIsNull() {
        return yearOnYearIsNull;
    }

    public Boolean getMonthOnMonthIsNull() {
        return monthOnMonthIsNull;
    }

    public FloatEnum yearOnYearFloat() {

        if (yearOnYear == null || yearOnYear == 0) {
            return FloatEnum.FLAT;
        }
        if (yearOnYear > 0) {
            return FloatEnum.UP;
        }
        return FloatEnum.DOWN;
    }

    public FloatEnum monthOnMonthFloat() {

        if (monthOnMonth == null || monthOnMonth == 0) {
            return FloatEnum.FLAT;
        }
        if (monthOnMonth > 0) {
            return FloatEnum.UP;
        }
        return FloatEnum.DOWN;
    }
}
