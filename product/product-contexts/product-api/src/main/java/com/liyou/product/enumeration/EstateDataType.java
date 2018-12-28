package com.liyou.product.enumeration;

public enum EstateDataType {
    HOUSING_TRANSACTION("成交"),
    HOUSING_LISTING("挂牌")
    ;
    private String name;

    EstateDataType(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
