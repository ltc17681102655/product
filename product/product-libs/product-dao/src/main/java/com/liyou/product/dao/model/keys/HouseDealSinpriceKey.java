package com.liyou.service.estate.entity.keys;

import java.io.Serializable;

/**
 * @Auther: ltc
 * @Date: 2018/12/11 21:22
 * @Description: 小区成交单价key
 */
public class HouseDealSinpriceKey implements Serializable {
    private Integer cityId;
    private Integer houseId;
    private Integer lPrice;
    private Integer hPrice;

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

    @Override
    public String toString() {
        return "HouseDealSinpriceKey{" +
                "cityId=" + cityId +
                ", houseId=" + houseId +
                ", lPrice=" + lPrice +
                ", hPrice=" + hPrice +
                '}';
    }
}
