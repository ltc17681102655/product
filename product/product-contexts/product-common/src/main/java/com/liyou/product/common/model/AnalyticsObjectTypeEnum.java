package com.liyou.product.common.model;

import com.liyou.framework.base.model.Describable;


/***
 *
 *   @author linxiaohui
 *   @date 2018/5/16
 ***/
public enum AnalyticsObjectTypeEnum implements Describable {
    CITY("城市"),
    DISTRICT("区域"),
    PLATE("板块"),
    HOUSE("小区");
    
    
    private String desc;
    
    AnalyticsObjectTypeEnum(String desc) {
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
