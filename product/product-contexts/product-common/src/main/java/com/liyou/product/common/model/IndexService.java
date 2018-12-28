package com.liyou.product.common.model;

import com.liyou.framework.page.PageRequestCustom;

import java.util.List;

/***
 *
 *   @author linxiaohui
 *   @date 2018/5/15
 ***/
public interface IndexService<i extends Index, s extends Statistics> {

    /**
     * 查询报告数据
     *
     * @param indexes
     * @param analyticsObject
     * @param range
     * @param custom
     * @param analyticsSorts
     * @return
     */
    List<IndexValue> find(List<i> indexes, List<AnalyticsObject> analyticsObject, List<Range> range, PageRequestCustom custom, AnalyticsSort...
            analyticsSorts);

    /**
     * 查询报告数据（聚合）
     *
     * @param object
     * @param analyticsObject
     * @param range
     * @param limit
     * @param asc
     * @return
     */
    List<IndexStatisticsValue> find(StatisticsObject<i, s> object, List<AnalyticsObject> analyticsObject, List<Range> range, Integer limit, boolean
            asc);

    /**
     * 是否支持报告
     *
     * @param index
     * @return
     */
    boolean supportIndex(Index index);
}
