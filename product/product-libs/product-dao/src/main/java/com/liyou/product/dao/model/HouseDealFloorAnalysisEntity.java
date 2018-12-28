package com.liyou.service.estate.entity;

import com.liyou.service.estate.entity.keys.HouseDealFloorKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: ltc
 * @Date: 2018/12/11 21:19
 * @Description: 成交楼层实体
 */
@Entity
@Table(name = "house_deal_floor_analysis")
@IdClass(HouseDealFloorKey.class)
public class HouseDealFloorAnalysisEntity implements Serializable {
    /**
     * 城市ID
     */
    @Id
    @Column(name = "city_id")
    private Integer cityId;
    /**
     * 小区ID
     */
    @Id
    @Column(name = "house_id")
    private Integer houseId;
    /**
     * 成交楼层:高中低楼层
     */
    @Id
    @Column(name = "floor_tag")
    private String floorTag;
    /**
     * 成交量
     */
    @Column(name = "deal_cnt")
    private Integer dealCnt;
    /**
     * 成交量占比
     */
    @Column(name = "proportion")
    private Integer proportion;
    /**
     * 成交单价均价,单位元
     */
    @Column(name = "avgprice")
    private Integer avgprice;
    /**
     * 成交总价最小值,单位万元
     */
    @Column(name = "minprice")
    private Integer minprice;
    /**
     * 成交总价最大值,单位万元
     */
    @Column(name = "maxprice")
    private Integer maxprice;
    /**
     * 成交总价中位数,单位万元
     */
    @Column(name = "medprice")
    private Integer medprice;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getFloorTag() {
        return floorTag;
    }

    public void setFloorTag(String floorTag) {
        this.floorTag = floorTag;
    }

    public Integer getDealCnt() {
        return dealCnt;
    }

    public void setDealCnt(Integer dealCnt) {
        this.dealCnt = dealCnt;
    }

    public Integer getProportion() {
        return proportion;
    }

    public void setProportion(Integer proportion) {
        this.proportion = proportion;
    }

    public Integer getAvgprice() {
        return avgprice;
    }

    public void setAvgprice(Integer avgprice) {
        this.avgprice = avgprice;
    }

    public Integer getMinprice() {
        return minprice;
    }

    public void setMinprice(Integer minprice) {
        this.minprice = minprice;
    }

    public Integer getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(Integer maxprice) {
        this.maxprice = maxprice;
    }

    public Integer getMedprice() {
        return medprice;
    }

    public void setMedprice(Integer medprice) {
        this.medprice = medprice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "HouseDealFloorAnalysisEntity{" +
                "cityId=" + cityId +
                ", houseId=" + houseId +
                ", floorTag='" + floorTag + '\'' +
                ", dealCnt=" + dealCnt +
                ", proportion=" + proportion +
                ", avgprice=" + avgprice +
                ", minprice=" + minprice +
                ", maxprice=" + maxprice +
                ", medprice=" + medprice +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
