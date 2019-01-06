package com.liyou.product.dao.model.keys;

import java.io.Serializable;

/**
 * @Auther: ltc
 * @Date: 2018/12/11 21:22
 * @Description: 小区成交楼层key
 */
public class HouseDealFloorKey implements Serializable {
    private Integer cityId;
    private Integer houseId;
    private String floorTag;

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

    @Override
    public String toString() {
        return "HouseDealFloorKey{" +
                "cityId=" + cityId +
                ", houseId=" + houseId +
                ", floorTag='" + floorTag + '\'' +
                '}';
    }
}
