package com.liyou.product.dao.model.keys;

import java.io.Serializable;

/**
 * @Auther: ltc
 * @Date: 2018/12/11 21:22
 * @Description: 小区成交楼栋key
 */
public class HouseDealBuildingKey implements Serializable {
    private Integer cityId;
    private Integer houseId;
    private String building;

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

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "HouseDealBuildingKey{" +
                "cityId=" + cityId +
                ", houseId=" + houseId +
                ", building='" + building + '\'' +
                '}';
    }
}
