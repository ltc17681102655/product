package com.liyou.product.model.mingle;

import java.io.Serializable;

/**
 * @Auther: ltc
 * @Date: 2018/12/11 16:30
 * @Description: 小区成交数据
 */
public class BasicDealInfo implements Serializable {
    /**
     * 成交户型
     */
    private String roomtype;
    /**
     * 成交面积
     */
    private Integer dealArea;
    /**
     * 单价段最低值
     */
    private Integer lPrice;
    /**
     * 单价段最高值
     */
    private Integer hPrice;
    /**
     * 成交楼层:高中低楼层
     */
    private String floorTag;
    /**
     * 成交楼栋
     */
    private String building;
    /**
     * 成交量
     */
    private Integer dealCnt;
    /**
     * 成交量占比
     */
    private Integer proportion;
    /**
     * 成交单价均价,单位元
     */
    private Integer avgprice;
    /**
     * 成交总价最小值,单位万元
     */
    private Integer minprice;
    /**
     * 成交总价中位数,单位万元
     */
    private Integer medprice;
    /**
     * 成交总价最大值,单位万元
     */
    private Integer maxprice;

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public Integer getDealArea() {
        return dealArea;
    }

    public void setDealArea(Integer dealArea) {
        this.dealArea = dealArea;
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

    public String getFloorTag() {
        return floorTag;
    }

    public void setFloorTag(String floorTag) {
        this.floorTag = floorTag;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
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

    public Integer getMedprice() {
        return medprice;
    }

    public void setMedprice(Integer medprice) {
        this.medprice = medprice;
    }

    public Integer getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(Integer maxprice) {
        this.maxprice = maxprice;
    }

    @Override
    public String toString() {
        return "NewHouseDealInfo{" +
                "roomtype='" + roomtype + '\'' +
                ", dealArea='" + dealArea + '\'' +
                ", lPrice=" + lPrice +
                ", hPrice=" + hPrice +
                ", floorTag='" + floorTag + '\'' +
                ", building='" + building + '\'' +
                ", dealCnt=" + dealCnt +
                ", proportion=" + proportion +
                ", avgprice=" + avgprice +
                ", minprice=" + minprice +
                ", medprice=" + medprice +
                ", maxprice=" + maxprice +
                '}';
    }
}
