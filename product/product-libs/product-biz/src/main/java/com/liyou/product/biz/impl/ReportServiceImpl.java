package com.liyou.product.biz.impl;

import com.liyou.framework.base.criteria.Expressions;
import com.liyou.framework.base.criteria.predicate.CompoundPredicate;
import com.liyou.framework.page.PageCustom;
import com.liyou.framework.page.PageRequestCustom;
import com.liyou.product.biz.ReportService;
import com.liyou.product.biz.model.HousePriceAreaPieChartInfo;
import com.liyou.product.common.annotations.Product;
import com.liyou.product.common.enums.DealTypeEnum;
import com.liyou.product.common.model.AnalyticsObjectTypeEnum;
import com.liyou.product.dao.*;
import com.liyou.product.dao.model.*;
import com.liyou.product.enumeration.EstateDataType;
import com.liyou.product.enumeration.HouseDimension;
import com.liyou.product.enumeration.HouseSegmentEnum;
import com.liyou.product.model.HouseDealInfo;
import com.liyou.product.model.HousePriceAreaSegmentData;
import com.liyou.product.model.mingle.BasicDealInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
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

    @Autowired
    private HouseDealRoomtypeAanalysisRepo houseDealRoomtypeAanalysisRepo;

    @Autowired
    private HouseDealSinpriceAnalysisRepo houseDealSinpriceAnalysisRepo;

    @Autowired
    private HouseDealFloorAnalysisRepo houseDealFloorAnalysisRepo;

    @Autowired
    private HouseDealBuildingAnalysisRepo houseDealBuildingAnalysisRepo;

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

    /**
     * 通过dealType获取小区成交信息
     *
     * @param cityId
     * @param houseId
     * @param dealTypes
     * @return
     */
    @Override
    public PageCustom<HouseDealInfo> getHouseDealInfoByDealType(Integer cityId, Integer houseId, List<DealTypeEnum> dealTypes, Integer pageNo,
                                                                Integer pageSize) {

        List<HouseDealInfo> houseDealInfos = new CopyOnWriteArrayList<>();

        if (CollectionUtils.isEmpty(dealTypes)) {
            return new PageCustom<>(0, new PageRequestCustom(pageNo, pageSize), houseDealInfos);
        }

        CompoundPredicate predicate = Expressions.and()
                .add(Expressions.eq("cityId", cityId))
                .add(Expressions.eq("houseId", houseId));

        Sort sort = new Sort(Sort.Direction.DESC, "dealCnt");
        //分页从0开始
        PageRequest pageRequest = new PageRequest(pageNo - 1 > 0 ? pageNo - 1 : 0, pageSize, sort);

        dealTypes.parallelStream().forEach(c -> {
            HouseDealInfo houseDealInfo = new HouseDealInfo();
            switch (c) {
                case ROOM_TYPE:
                    Page<HouseDealRoomtypeAanalysisEntity> roomTypeEntityPage = houseDealRoomtypeAanalysisRepo.findAll(predicate, pageRequest);
                    if (org.apache.commons.collections.CollectionUtils.isNotEmpty(roomTypeEntityPage.getContent())) {
                        houseDealInfo.setDealTypeEnum(c);
                        List<BasicDealInfo> roomTypesData = roomTypeEntityPage.getContent().stream().map(o -> {
                            return this.convert2BasicHouseInfo(o);
                        }).collect(Collectors.toList());
                        houseDealInfo.setDealInfos(roomTypesData);
                        houseDealInfo.setTotalCount(roomTypeEntityPage.getTotalElements());
                        houseDealInfos.add(houseDealInfo);
                    }
                    break;
                case SING_PRICE:
                    Page<HouseDealSinpriceAnalysisEntity> sinpriceEntityPage = houseDealSinpriceAnalysisRepo.findAll(predicate, pageRequest);
                    if (org.apache.commons.collections.CollectionUtils.isNotEmpty(sinpriceEntityPage.getContent())) {
                        houseDealInfo.setDealTypeEnum(c);
                        List<BasicDealInfo> sinpriceData = sinpriceEntityPage.getContent().stream().map(o -> {
                            return this.convert2BasicHouseInfo(o);
                        }).collect(Collectors.toList());
                        houseDealInfo.setDealInfos(sinpriceData);
                        houseDealInfo.setTotalCount(sinpriceEntityPage.getTotalElements());
                        houseDealInfos.add(houseDealInfo);
                    }
                    break;
                case FLOOR:
                    Page<HouseDealFloorAnalysisEntity> floorEntityPage = houseDealFloorAnalysisRepo.findAll(predicate, pageRequest);
                    if (org.apache.commons.collections.CollectionUtils.isNotEmpty(floorEntityPage.getContent())) {
                        houseDealInfo.setDealTypeEnum(c);
                        List<BasicDealInfo> floorData = floorEntityPage.getContent().stream().map(o -> {
                            return this.convert2BasicHouseInfo(o);
                        }).collect(Collectors.toList());
                        houseDealInfo.setDealInfos(floorData);
                        houseDealInfo.setTotalCount(floorEntityPage.getTotalElements());
                        houseDealInfos.add(houseDealInfo);
                    }
                    break;
                case BUILDING:
                    Page<HouseDealBuildingAnalysisEntity> buildingEntityPage = houseDealBuildingAnalysisRepo.findAll(predicate, pageRequest);
                    if (org.apache.commons.collections.CollectionUtils.isNotEmpty(buildingEntityPage.getContent())) {
                        houseDealInfo.setDealTypeEnum(c);
                        List<BasicDealInfo> builDingData = buildingEntityPage.getContent().stream().map(o -> {
                            return this.convert2BasicHouseInfo(o);
                        }).collect(Collectors.toList());
                        houseDealInfo.setDealInfos(builDingData);
                        houseDealInfo.setTotalCount(buildingEntityPage.getTotalElements());
                        houseDealInfos.add(houseDealInfo);
                    }
                    break;
            }
        });

        //根据DealTypeEnum的index升序返回
        List<HouseDealInfo> sortHouseDealInfos = houseDealInfos.stream()
                .sorted((a, b) -> a.getDealTypeEnum().getIndex().compareTo(b.getDealTypeEnum().getIndex()))
                .collect(Collectors.toList());

        return new PageCustom<>(dealTypes.size(), new PageRequestCustom(pageNo, pageSize), sortHouseDealInfos);
    }

    private BasicDealInfo convert2BasicHouseInfo(Object obj) {
        BasicDealInfo basicDealInfo = new BasicDealInfo();
        BeanUtils.copyProperties(obj, basicDealInfo);
        return basicDealInfo;
    }

    private Double getDoubleValue(BigDecimal value) {
        if (value == null) {
            return null;
        }
        return value.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
