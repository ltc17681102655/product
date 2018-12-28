package com.liyou.product.common.model;

import java.io.Serializable;
import java.util.List;

/***
 *
 *   @author linxiaohui
 *   @date 2018/5/15
 ***/
public enum DimensionEnum implements Dimension,Serializable {

    NEW_HOUSE("新房"),
    SECOND_HAND_HOUSE("二手房")
    ;

    private String desc;
    DimensionEnum(String desc){
        this.desc = desc;
    }

    @Override
    public List<Index> supportIndexes() {
        return null;
    }

    /**
     * 获取描述
     *
     * @return
     */
    @Override
    public String getDescription() {
        return desc;
    }
}
