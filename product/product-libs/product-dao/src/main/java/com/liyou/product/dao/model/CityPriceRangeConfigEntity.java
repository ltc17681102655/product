package com.liyou.product.dao.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "city_diff_price_range_config")
public class CityPriceRangeConfigEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "periodid")
    private Integer periodid;

    @Basic
    @Column(name = "bottom_price")
    private Integer bottomPrice;

    @Basic
    @Column(name = "top_price")
    private Integer topPrice;

    @Basic
    @Column(name = "period_name")
    private String periodName;

    @Basic
    @Column(name = "city_id")
    private Integer cityId;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getPeriodid() {
        return periodid;
    }

    public void setPeriodid(Integer periodid) {
        this.periodid = periodid;
    }

    public Integer getBottomPrice() {
        return bottomPrice;
    }

    public void setBottomPrice(Integer bottomPrice) {
        this.bottomPrice = bottomPrice;
    }


    public Integer getTopPrice() {
        return topPrice;
    }

    public void setTopPrice(Integer topPrice) {
        this.topPrice = topPrice;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

}
