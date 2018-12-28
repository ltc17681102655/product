package com.liyou.product.biz;

import com.liyou.product.ProductApplicationTest;
import com.liyou.product.common.model.AnalyticsObjectTypeEnum;
import com.liyou.product.enumeration.EstateDataType;
import com.liyou.product.enumeration.HouseDimension;
import com.liyou.product.enumeration.HouseSegmentEnum;
import com.liyou.product.model.HousePriceAreaSegmentData;
import com.liyou.product.utils.FormatUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Rollback(value = false)
public class ReportServiceImplTest extends ProductApplicationTest {

    @Autowired
    private ReportService reportService;

    @Test
    public void getHousePriceAreaSegmentDataList() {
        //城市(上海)
        List<HousePriceAreaSegmentData> cityHousePriceAreaSegmentDataList = reportService.getHousePriceAreaSegmentDataList(605,
                AnalyticsObjectTypeEnum
                        .CITY, null, HouseSegmentEnum.PRICE_SEGMENT,
                HouseDimension.SECOND_HAND_HOUSE, EstateDataType.HOUSING_TRANSACTION, 2018, 13);

        FormatUtil.formatList(cityHousePriceAreaSegmentDataList);

        //区域(浦东)
        List<HousePriceAreaSegmentData> districtHousePriceAreaSegmentDataList = reportService.getHousePriceAreaSegmentDataList(605,
                AnalyticsObjectTypeEnum
                        .DISTRICT, 5342, HouseSegmentEnum.PRICE_SEGMENT,
                HouseDimension.SECOND_HAND_HOUSE, EstateDataType.HOUSING_TRANSACTION, 2018, 9);

        FormatUtil.formatList(districtHousePriceAreaSegmentDataList);

    }

}
