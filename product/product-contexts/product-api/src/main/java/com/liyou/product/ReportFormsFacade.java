package com.liyou.product;

import com.liyou.framework.base.model.Response;
import com.liyou.framework.page.PageCustom;
import com.liyou.product.common.enums.DealTypeEnum;
import com.liyou.product.common.model.AnalyticsObjectTypeEnum;
import com.liyou.product.common.model.criteria.HistoryIndexQuery;
import com.liyou.product.enumeration.EstateDataType;
import com.liyou.product.enumeration.HouseDimension;
import com.liyou.product.enumeration.HouseSegmentEnum;
import com.liyou.product.model.HouseDealInfo;
import com.liyou.product.model.HousePriceAreaSegmentData;
import com.liyou.product.model.IndexDataCollection;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: ltc
 * @Date: 2018/12/29 9:41
 * @Description: 报表
 */
public interface ReportFormsFacade {

    /**
     * 根据指标查询报表
     *
     * @param query
     * @return
     */
    Response<IndexDataCollection> findHistoryIndex(@Valid HistoryIndexQuery query);

    /**
     * 查询(新房/二手房) 总价段，面积段，单价段=报表数据
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

    /**
     * 查询新房成交=报表数据
     *
     * @param cityId
     * @param houseId
     * @param dealTypes
     * @param pageNo
     * @param pageSize
     * @return
     */
    Response<PageCustom<HouseDealInfo>> getHouseDealInfoByDealType(Integer cityId, Integer houseId, List<DealTypeEnum> dealTypes, Integer pageNo,
                                                                   Integer pageSize);
}
