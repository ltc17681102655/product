package com.liyou.product.model;

import java.io.Serializable;

/***
 *   面积段，总价段，单价段 bo数据
 *   @author lukang
 *   @date 2018/5/21
 ***/
public class HousePriceAreaSegmentData implements Serializable {

    /**
     * 范围段id
     */
    private Integer id;

    /**
     * 范围名
     */
    private String name;

    /**
     * 成交/挂牌 套数
     */
    private Integer count;

    /**
     * 成交/挂牌 均价
     */
    private Double price;

    /**
     * 占比
     */
    private Double proportion;

    /**
     * 成交/挂牌 套数 环比
     */
    private Double countRelativeRate;

    /**
     * 成交/挂牌 均价 环比
     */
    private Double priceRelativeRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public Double getCountRelativeRate() {
        return countRelativeRate;
    }

    public void setCountRelativeRate(Double countRelativeRate) {
        this.countRelativeRate = countRelativeRate;
    }

    public Double getPriceRelativeRate() {
        return priceRelativeRate;
    }

    public void setPriceRelativeRate(Double priceRelativeRate) {
        this.priceRelativeRate = priceRelativeRate;
    }

    @Override
    public String toString() {
        return "HousePriceAreaSegmentData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", proportion=" + proportion +
                ", countRelativeRate=" + countRelativeRate +
                ", priceRelativeRate=" + priceRelativeRate +
                '}';
    }
}
