package com.liyou.product.biz;

import com.liyou.product.common.model.AnalyticsObjectTypeEnum;
import com.liyou.product.enumeration.EstateDataType;
import com.liyou.product.enumeration.HouseDimension;
import com.liyou.product.enumeration.HouseSegmentEnum;
import com.liyou.product.model.HousePriceAreaSegmentData;

import java.util.List;

/**
 * @Auther: ltc
 * @Date: 2018/11/30 15:02
 * @Description:
 */
public interface ReportService {
    /**
     * 获取总价格段，单价段，面积段
     *
     * @param dimension
     * @param estateDataType
     * @param year
     * @param month
     * @return
     */
    List<HousePriceAreaSegmentData> getHousePriceAreaSegmentDataList(Integer cityId, AnalyticsObjectTypeEnum analyticsObjectType,
                                                                     Integer targetId, HouseSegmentEnum houseSegmentEnum, HouseDimension dimension,
                                                                     EstateDataType estateDataType, int year, int month);


}
