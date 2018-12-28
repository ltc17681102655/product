package com.liyou.product.common.model;

import java.io.Serializable;
import java.util.List;

/***
 *
 *   @author linxiaohui
 *   @date 2018/5/22
 ***/
public interface StatisticsObject<i extends Index,s extends Statistics> extends Serializable {

    public enum StatisticsObjectType{
        INDEX_VALUE,
        INDEX_YOY,
        INDEX_MOM
    }




    public StatisticsObjectType getStatisticsObjectType();

    public List<i> getIndexs();

    public s getStatistics();
}
