package com.liyou.product.common.model;

import java.io.Serializable;

/***
 *   分析对象( 计算维度指标时的分组数据 {小区,板块,城市等} )
 *   @author linxiaohui
 *   @date 2018/5/15
 ***/
public interface AnalyticsObject  extends Serializable {

    String id();
}
