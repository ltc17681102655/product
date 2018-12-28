package com.liyou.product.common.model;

import com.liyou.framework.base.model.Describable;

/***
 *   指标( 具体的衡量数据具体的值  比如价格维度{ 最高价格,最低价格,平均价格就是指标   } )
 *   @author linxiaohui
 *   @date 2018/5/15
 ***/
public interface Index<T> extends Describable{

    Dimension dimension();

    String name();
}
