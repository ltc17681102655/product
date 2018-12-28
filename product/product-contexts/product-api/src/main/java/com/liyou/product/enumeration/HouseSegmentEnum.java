package com.liyou.product.enumeration;

public enum HouseSegmentEnum {

    TOTAL_PRICE_SEGMENT("总价段"),
    PRICE_SEGMENT("单价段"),
    AREA_SEGMENT("面积段")
    ;
    private String name;

    HouseSegmentEnum(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
