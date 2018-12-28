package com.liyou.product.dao.model;

import com.liyou.product.common.model.AnalyticsObjectTypeEnum;
import com.liyou.product.common.model.DimensionEnum;
import com.liyou.product.common.model.IndexEnum;

import javax.persistence.*;
import java.io.Serializable;

/***
 *
 *   @author linxiaohui
 *   @date 2018/5/15
 ***/
@Entity
@Table(name = "history_index")
public class HistoryIndexEntity implements Serializable {

//    id  维度  指标  数值 同比 环比 被分析对象(板块,区域,城市 id )  报告范围索引( int )
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_index_id")
    private Long id;

    /**
     * 维度
     */
    @Enumerated(value = EnumType.STRING)
    @Column(name = "history_index_dimension")
    private DimensionEnum dimension;


    /**
     * 指标
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "history_index")
    private IndexEnum index;


    /**
     * 指标值
     */
    @Column(name = "history_index_value")
    private Double value;

    /**
     * 指标值(同比)
     */
    @Column(name = "history_index_yoy_value")
    private Double yearOnYear;


    /**
     * 指标值(环比)
     */
    @Column(name = "history_index_mom_value")
    private Double monthOnMonth;


    /**
     * 城市 city:${cityId}
     * 区域 city:${cityId},district:${districtId}
     * 板块 city:${cityId},plate:${plateId}
     * 小区 city:${cityId},house:${houseId}
     * 分析对象
     */
    @Column(name = "history_index_analytics_object")
    private String analyticsObject;


    @Column(name = "history_index_analytics_name")
    private String analyticsObjectName;


    @Enumerated(EnumType.STRING)
    @Column(name = "history_index_analytics_type")
    private AnalyticsObjectTypeEnum analyticsObjectType;
    /**
     * 月  yyyyMM
     * 周  yyyy0ww
     * 日  yyyyMMdd
     * 范围值
     */
    @Column(name = "history_index_range_value")
    private Long rangeValue;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DimensionEnum getDimension() {
        return dimension;
    }

    public void setDimension(DimensionEnum dimension) {
        this.dimension = dimension;
    }

    public IndexEnum getIndex() {
        return index;
    }

    public void setIndex(IndexEnum index) {
        this.index = index;
    }

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
    }

    public Double getMonthOnMonth() {
        return monthOnMonth;
    }

    public void setMonthOnMonth(Double monthOnMonth) {
        this.monthOnMonth = monthOnMonth;
    }

    public String getAnalyticsObject() {
        return analyticsObject;
    }

    public void setAnalyticsObject(String analyticsObject) {
        this.analyticsObject = analyticsObject;
    }

    public Long getRangeValue() {
        return rangeValue;
    }

    public void setRangeValue(Long rangeValue) {
        this.rangeValue = rangeValue;
    }

    public AnalyticsObjectTypeEnum getAnalyticsObjectType() {
        return analyticsObjectType;
    }

    public void setAnalyticsObjectType(AnalyticsObjectTypeEnum analyticsObjectType) {
        this.analyticsObjectType = analyticsObjectType;
    }

    public String getAnalyticsObjectName() {
        return analyticsObjectName;
    }

    public void setAnalyticsObjectName(String analyticsObjectName) {
        this.analyticsObjectName = analyticsObjectName;
    }
}
