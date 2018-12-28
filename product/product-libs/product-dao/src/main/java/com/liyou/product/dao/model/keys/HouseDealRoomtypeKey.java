package com.liyou.service.estate.entity.keys;

import java.io.Serializable;

/**
 * @Auther: ltc
 * @Date: 2018/12/11 21:22
 * @Description: 小区成交户型key
 */
public class HouseDealRoomtypeKey implements Serializable {
    private Integer cityId;

    private Integer houseId;

    private Integer dealArea;

    private String roomtype;

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

    public Integer getDealArea() {
        return dealArea;
    }

    public void setDealArea(Integer dealArea) {
        this.dealArea = dealArea;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    @Override
    public String toString() {
        return "HouseDealRoomtypeKey{" +
                "cityId=" + cityId +
                ", houseId=" + houseId +
                ", dealArea=" + dealArea +
                ", roomtype='" + roomtype + '\'' +
                '}';
    }
}
