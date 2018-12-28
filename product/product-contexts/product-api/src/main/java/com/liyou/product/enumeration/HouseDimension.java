package com.liyou.product.enumeration;

public enum HouseDimension {
    NEW_HOUSE("新房", 1),
    SECOND_HAND_HOUSE("二手房", 2)
    ;
    private String name;
    private int id;

    HouseDimension(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
}
