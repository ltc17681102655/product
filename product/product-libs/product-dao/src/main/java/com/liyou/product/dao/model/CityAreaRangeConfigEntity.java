package com.liyou.product.dao.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "city_area_range_config2")
public class CityAreaRangeConfigEntity implements Serializable {

    @Id
    @Column(name = "periodid")
    private Integer periodid;

    @Basic
    @Column(name = "period_name")
    private String periodName;

    @Basic
    @Column(name = "bottom_area")
    private Integer bottomArea;

    @Basic
    @Column(name = "top_area")
    private Integer topArea;


    public Integer getPeriodid() {
        return periodid;
    }

    public void setPeriodid(Integer periodid) {
        this.periodid = periodid;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public Integer getBottomArea() {
        return bottomArea;
    }

    public void setBottomArea(Integer bottomArea) {
        this.bottomArea = bottomArea;
    }

    public Integer getTopArea() {
        return topArea;
    }

    public void setTopArea(Integer topArea) {
        this.topArea = topArea;
    }
}
