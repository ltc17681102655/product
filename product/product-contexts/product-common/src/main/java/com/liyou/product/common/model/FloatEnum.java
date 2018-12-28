package com.liyou.product.common.model;

import com.liyou.framework.base.model.Describable;

public enum FloatEnum implements Describable {
    UP("上升"), DOWN("下降"), FLAT("浮动");
    private String desc;

    FloatEnum(String desc) {
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