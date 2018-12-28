package com.liyou.product.biz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liyou.framework.common.utils.JSONUtils;
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
        try {
            //城市(上海)
            List<HousePriceAreaSegmentData> cityHousePriceAreaSegmentDataList = reportService.getHousePriceAreaSegmentDataList(605,
                    AnalyticsObjectTypeEnum
                            .CITY, null, HouseSegmentEnum.PRICE_SEGMENT,
                    HouseDimension.SECOND_HAND_HOUSE, EstateDataType.HOUSING_TRANSACTION, 2018, 9);

            String cityResult = JSONUtils.toJSON(cityHousePriceAreaSegmentDataList);
            System.out.println("城市==" + FormatUtil.formatJson(cityResult));

            //区域(浦东)
            List<HousePriceAreaSegmentData> districtHousePriceAreaSegmentDataList = reportService.getHousePriceAreaSegmentDataList(605,
                    AnalyticsObjectTypeEnum
                            .DISTRICT, 5342, HouseSegmentEnum.PRICE_SEGMENT,
                    HouseDimension.SECOND_HAND_HOUSE, EstateDataType.HOUSING_TRANSACTION, 2018, 9);


            String districtResult = JSONUtils.toJSON(districtHousePriceAreaSegmentDataList);
            System.out.println("区域==" + FormatUtil.formatJson(districtResult));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
