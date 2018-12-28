package com.liyou.product.biz.impl;

import com.liyou.framework.base.criteria.Expressions;
import com.liyou.framework.base.criteria.predicate.CompoundPredicate;
import com.liyou.product.biz.ReportService;
import com.liyou.product.biz.model.HousePriceAreaPieChartInfo;
import com.liyou.product.common.model.AnalyticsObjectTypeEnum;
import com.liyou.product.dao.*;
import com.liyou.product.dao.model.*;
import com.liyou.product.enumeration.EstateDataType;
import com.liyou.product.enumeration.HouseDimension;
import com.liyou.product.enumeration.HouseSegmentEnum;
import com.liyou.product.model.HousePriceAreaSegmentData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: ltc
 * @Date: 2018/11/30 15:05
 * @Description:
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private CityDealAreaDistRepo cityDealAreaDistRepo;

    @Autowired
    private CityDealTotalpriceDistRepo cityDealTotalpriceDistRepo;

    @Autowired
    private CityDealPriceDistRepo cityDealPriceDistRepo;

    @Autowired
    private DistrictDealAreaDistRepo districtDealAreaDistRepo;

    @Autowired
    private DistrictDealTotalpriceDistRepo districtDealTotalpriceDistRepo;

    @Autowired
    private DistrictDealPriceDistRepo districtDealPriceDistRepo;

    @Override
    public List<HousePriceAreaSegmentData> getHousePriceAreaSegmentDataList(Integer cityId, AnalyticsObjectTypeEnum analyticsObjectType,
                                                                            Integer targetId, HouseSegmentEnum houseSegmentEnum, HouseDimension
                                                                                    dimension, EstateDataType estateDataType, int year, int
                                                                                    month) {

        CompoundPredicate compoundPredicate = Expressions.and()
                .addEquals("cityId", cityId)
                .addEquals("isFirst", dimension.getId())
                .addEquals("dealYear", year).addEquals("dealMonth", month);

        if (analyticsObjectType == AnalyticsObjectTypeEnum.DISTRICT) {
            compoundPredicate.add(Expressions.eq("districtId", targetId));
        }

        //优化代码
        switch (houseSegmentEnum) {
            case TOTAL_PRICE_SEGMENT:
                Sort sortTotal = new Sort(Sort.Direction.ASC, "totalpriceId");
                switch (analyticsObjectType) {
                    case CITY:
                        List<CityDealTotalpriceDistEntity> cityDealTotalpriceDist = cityDealTotalpriceDistRepo.findAll(compoundPredicate, sortTotal);
                        if (CollectionUtils.isEmpty(cityDealTotalpriceDist)) {
                            return Collections.emptyList();
                        }
                        return cityDealTotalpriceDist.stream().map(e -> {
                            return this.convert2HousePriceAreaSegmentData(e, estateDataType);
                        }).collect(Collectors.toList());
                    case DISTRICT:
                        List<DistrictDealTotalpriceDistEntity> districtDealTotalpriceDist = districtDealTotalpriceDistRepo.findAll
                                (compoundPredicate, sortTotal);
                        if (CollectionUtils.isEmpty(districtDealTotalpriceDist)) {
                            return Collections.emptyList();
                        }
                        return districtDealTotalpriceDist.stream().map(e -> {
                            return this.convert2HousePriceAreaSegmentData(e, estateDataType);
                        }).collect(Collectors.toList());
                }
                break;
            case PRICE_SEGMENT:
                Sort sortPrice = new Sort(Sort.Direction.ASC, "priceId");
                switch (analyticsObjectType) {
                    case CITY:
                        List<CityDealPriceDistEntity> CityDealPriceDist = cityDealPriceDistRepo.findAll(compoundPredicate, sortPrice);
                        if (CollectionUtils.isEmpty(CityDealPriceDist)) {
                            return Collections.emptyList();
                        }
                        return CityDealPriceDist.stream().map(e -> {
                            return this.convert2HousePriceAreaSegmentData(e, estateDataType);
                        }).collect(Collectors.toList());
                    case DISTRICT:
                        List<DistrictDealPriceDistEntity> districtDealPriceDist = districtDealPriceDistRepo.findAll
                                (compoundPredicate, sortPrice);
                        if (CollectionUtils.isEmpty(districtDealPriceDist)) {
                            return Collections.emptyList();
                        }
                        return districtDealPriceDist.stream().map(e -> {
                            return this.convert2HousePriceAreaSegmentData(e, estateDataType);
                        }).collect(Collectors.toList());
                }
                break;
            case AREA_SEGMENT:
                Sort sortArea = new Sort(Sort.Direction.ASC, "areaId");
                switch (analyticsObjectType) {
                    case CITY:
                        List<CityDealAreaDistEntity> cityDealAreaDist = cityDealAreaDistRepo.findAll(compoundPredicate, sortArea);
                        if (CollectionUtils.isEmpty(cityDealAreaDist)) {
                            return Collections.emptyList();
                        }
                        return cityDealAreaDist.stream().map(e -> {
                            return this.convert2HousePriceAreaSegmentData(e, estateDataType);
                        }).collect(Collectors.toList());
                    case DISTRICT:
                        List<DistrictDealAreaDistEntity> districtDealAreaDist = districtDealAreaDistRepo.findAll
                                (compoundPredicate, sortArea);
                        if (CollectionUtils.isEmpty(districtDealAreaDist)) {
                            return Collections.emptyList();
                        }
                        return districtDealAreaDist.stream().map(e -> {
                            return this.convert2HousePriceAreaSegmentData(e, estateDataType);
                        }).collect(Collectors.toList());
                }
                break;
        }

        return Collections.emptyList();
    }

    private HousePriceAreaSegmentData convert2HousePriceAreaSegmentData(Object obj, EstateDataType estateDataType) {
        //统一转换
        HousePriceAreaPieChartInfo e = new HousePriceAreaPieChartInfo();
        BeanUtils.copyProperties(obj, e);

        HousePriceAreaSegmentData data = new HousePriceAreaSegmentData();
        if (obj instanceof CityDealTotalpriceDistEntity) {
            CityDealTotalpriceDistEntity cityDealTotalprice = (CityDealTotalpriceDistEntity) obj;
            data.setName(cityDealTotalprice.getCityTotalpriceRangeConfigEntity() == null ? "" : cityDealTotalprice
                    .getCityTotalpriceRangeConfigEntity().getPeriodName());
            data.setId(e.getTotalpriceId());
        }
        if (obj instanceof DistrictDealTotalpriceDistEntity) {
            DistrictDealTotalpriceDistEntity districtDealTotalprice = (DistrictDealTotalpriceDistEntity) obj;
            data.setName(districtDealTotalprice.getCityTotalpriceRangeConfigEntity() == null ? "" : districtDealTotalprice
                    .getCityTotalpriceRangeConfigEntity().getPeriodName());
            data.setId(e.getTotalpriceId());
        }
        if (obj instanceof CityDealPriceDistEntity) {
            CityDealPriceDistEntity cityDealPriceDist = (CityDealPriceDistEntity) obj;
            data.setName(cityDealPriceDist.getCityPriceRangeConfigEntity() == null ? "" : cityDealPriceDist
                    .getCityPriceRangeConfigEntity().getPeriodName());
            data.setId(e.getPriceId());
        }
        if (obj instanceof DistrictDealPriceDistEntity) {
            DistrictDealPriceDistEntity districtDealPriceDist = (DistrictDealPriceDistEntity) obj;
            data.setName(districtDealPriceDist.getCityPriceRangeConfigEntity() == null ? "" : districtDealPriceDist
                    .getCityPriceRangeConfigEntity().getPeriodName());
            data.setId(e.getPriceId());
        }
        if (obj instanceof CityDealAreaDistEntity) {
            CityDealAreaDistEntity cityDealAreaDist = (CityDealAreaDistEntity) obj;
            data.setName(cityDealAreaDist.getCityAreaRangeConfigEntity() == null ? "" : cityDealAreaDist
                    .getCityAreaRangeConfigEntity().getPeriodName());
            data.setId(e.getAreaId());
        }
        if (obj instanceof DistrictDealAreaDistEntity) {
            DistrictDealAreaDistEntity districtDealAreaDist = (DistrictDealAreaDistEntity) obj;
            data.setName(districtDealAreaDist.getCityAreaRangeConfigEntity() == null ? "" : districtDealAreaDist
                    .getCityAreaRangeConfigEntity().getPeriodName());
            data.setId(e.getAreaId());
        }


        data.setProportion(getDoubleValue(e.getProportion()));
        //成交
        if (estateDataType == EstateDataType.HOUSING_TRANSACTION) {
            data.setCount(e.getDealCnt());
            data.setCountRelativeRate(getDoubleValue(e.getDealCntMom()));
            data.setPrice(e.getDealPrice());
            data.setPriceRelativeRate(getDoubleValue(e.getDealPriceMom()));
        } else {//挂牌
            data.setCount(e.getQuoteCnt());
            data.setCountRelativeRate(getDoubleValue(e.getQuoteCntMom()));
            data.setPrice(e.getQuotePrice());
            data.setPriceRelativeRate(getDoubleValue(e.getQuotePriceMom()));
        }
        return data;
    }

    private Double getDoubleValue(BigDecimal value) {
        if (value == null) {
            return null;
        }
        return value.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
