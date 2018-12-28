package com.liyou.product.common.model;

import com.liyou.framework.base.model.Describable;

import java.util.List;

/***
 *   报表维度( 维度是分类{ 价格,挂牌,浏览等 }  , 一个维度可以对应多个指标 { 比如 最大成交价,最小成交价,成交均价等 }   )
 *   @author linxiaohui
 *   @date 2018/5/15
 ***/
public interface Dimension extends Describable{


    List<Index> supportIndexes();
}
