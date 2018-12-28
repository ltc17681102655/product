package com.liyou.product.controller;

import com.google.common.collect.Lists;
import com.liyou.framework.base.model.Response;
import com.liyou.framework.page.PageCustom;
import com.liyou.product.ReportFacade;
import com.liyou.product.common.enums.DealTypeEnum;
import com.liyou.product.common.model.AnalyticsObjectTypeEnum;
import com.liyou.product.enumeration.EstateDataType;
import com.liyou.product.enumeration.HouseDimension;
import com.liyou.product.enumeration.HouseSegmentEnum;
import com.liyou.product.model.HouseDealInfo;
import com.liyou.product.model.HousePriceAreaSegmentData;
import com.liyou.product.response.OResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ReportFacade reportFacade;

    /**
     * 报告商城饼状图-上海
     *
     * @return
     */
    @GetMapping("test_housePriceAreaSegmentDataList_city")
    public OResultVO test_housePriceAreaSegmentDataList_city() {
        //城市(上海)
        Response<List<HousePriceAreaSegmentData>> housePriceAreaSegmentDataList = reportFacade.getHousePriceAreaSegmentDataList(605,
                AnalyticsObjectTypeEnum
                        .CITY, null, HouseSegmentEnum.PRICE_SEGMENT,
                HouseDimension.SECOND_HAND_HOUSE, EstateDataType.HOUSING_TRANSACTION, 2018, 9);

        return new OResultVO(housePriceAreaSegmentDataList.getData());
    }

    /**
     * 报告商城饼状图-浦东
     *
     * @return
     */
    @GetMapping("test_housePriceAreaSegmentDataList_district")
    public OResultVO test_housePriceAreaSegmentDataList_district() {
        //区域(浦东)
        Response<List<HousePriceAreaSegmentData>> housePriceAreaSegmentDataList = reportFacade.getHousePriceAreaSegmentDataList(605,
                AnalyticsObjectTypeEnum
                        .DISTRICT, 5342, HouseSegmentEnum.PRICE_SEGMENT,
                HouseDimension.SECOND_HAND_HOUSE, EstateDataType.HOUSING_TRANSACTION, 2018, 9);

        return new OResultVO(housePriceAreaSegmentDataList.getData());
    }

    /**
     * 新房成交饼状图
     *
     * @return
     */
    @GetMapping("test_houseDealInfoByDealType")
    public OResultVO test_houseDealInfoByDealType() {
        Response<PageCustom<HouseDealInfo>> houseDealInfoByDealType = reportFacade.getHouseDealInfoByDealType(666, 4691, Lists.newArrayList
                (DealTypeEnum
                                .ROOM_TYPE,
                        DealTypeEnum.SING_PRICE, DealTypeEnum.FLOOR, DealTypeEnum.BUILDING), -1, 100);

        return new OResultVO(houseDealInfoByDealType.getData());
    }

}
