package com.liyou.product.common.enums;

import java.io.Serializable;

/**
 * @Auther: ltc
 * @Date: 2018/12/12 9:18
 * @Description: 成交类型
 */
public enum DealTypeEnum implements Serializable {
    ROOM_TYPE(1, "户型"),
    SING_PRICE(2, "单价段"),
    FLOOR(3, "楼层"),
    BUILDING(4, "楼栋");


    private Integer index;
    private String title;

    DealTypeEnum(Integer index, String title) {
        this.index = index;
        this.title = title;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "DealTypeEnum{" +
                "index=" + index +
                ", title='" + title + '\'' +
                '}';
    }
}
