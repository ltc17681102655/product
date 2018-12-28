package com.liyou.product;

import com.liyou.framework.base.model.Response;
import com.liyou.product.common.model.AnalyticsObjectTypeEnum;
import com.liyou.product.common.model.criteria.HistoryIndexQuery;
import com.liyou.product.enumeration.EstateDataType;
import com.liyou.product.enumeration.HouseDimension;
import com.liyou.product.enumeration.HouseSegmentEnum;
import com.liyou.product.model.HousePriceAreaSegmentData;
import com.liyou.product.model.IndexDataCollection;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: ltc
 * @Date: 2018/11/6 11:40
 * @Description: 报告商城
 */
public interface ReportFacade {

    /**
     * 指标查询报告
     *
     * @param query
     * @return
     */
    Response<IndexDataCollection> findHistoryIndex(@Valid HistoryIndexQuery query);

    /**
     * 查询 总价段，面积段，单价段 数据
     *
     * @param cityId
     * @param houseSegmentEnum
     * @param dimension
     * @param estateDataType
     * @param year
     * @param month
     * @return
     */
    Response<List<HousePriceAreaSegmentData>> getHousePriceAreaSegmentDataList(Integer cityId, AnalyticsObjectTypeEnum analyticsObjectType,
                                                                               Integer targetId,
                                                                               HouseSegmentEnum houseSegmentEnum,
                                                                               HouseDimension dimension, EstateDataType estateDataType, int year,
                                                                               int month);

}
