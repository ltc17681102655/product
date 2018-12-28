package com.liyou.product.common.model;

import com.liyou.framework.base.model.Describable;

import java.io.Serializable;

/***
 *
 *   @author linxiaohui
 *   @date 2018/5/15
 ***/
public enum RangeTypeEnum implements Describable, Serializable {
    MONTH("月"),
    WEEK("周"),
    DAY("日");


    private String desc;

    RangeTypeEnum(String desc){
        this.desc = desc;
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
