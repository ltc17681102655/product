package com.liyou.service.estate.entity;

import com.liyou.service.estate.entity.keys.HouseDealSinpriceKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: ltc
 * @Date: 2018/12/11 21:19
 * @Description: 成交单价实体
 */
@Entity
@Table(name = "house_deal_sinprice_analysis")
@IdClass(HouseDealSinpriceKey.class)
public class HouseDealSinpriceAnalysisEntity implements Serializable {
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
     * 单价段最低值
     */
    @Id
    @Column(name = "l_price")
    private Integer lPrice;
    /**
     * 单价段最高值
     */
    @Id
    @Column(name = "h_price")
    private Integer hPrice;
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

    public Integer getlPrice() {
        return lPrice;
    }

    public void setlPrice(Integer lPrice) {
        this.lPrice = lPrice;
    }

    public Integer gethPrice() {
        return hPrice;
    }

    public void sethPrice(Integer hPrice) {
        this.hPrice = hPrice;
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
        return "HouseDealSinpriceAnalysisEntity{" +
                "cityId=" + cityId +
                ", houseId=" + houseId +
                ", lPrice=" + lPrice +
                ", hPrice=" + hPrice +
                ", dealCnt=" + dealCnt +
                ", proportion=" + proportion +
                ", avgprice=" + avgprice +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
