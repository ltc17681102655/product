package com.liyou.product.common.model;

import java.io.Serializable;

/***
 *
 *   @author linxiaohui
 *   @date 2018/5/15
 ***/
public enum IndexEnum implements Index, Serializable {

    /**
     * SECOND_HAND_HOUSE
     **/
    SHH_DEAL_UNIT_PRICE_AVG("二手房成交均价㎡", DimensionEnum.SECOND_HAND_HOUSE),
    SHH_DEAL_PRICE_AVG("二手房成交均总价", DimensionEnum.SECOND_HAND_HOUSE),
    SHH_DEAL_VOLUME("二手房成交总套数", DimensionEnum.SECOND_HAND_HOUSE),

    SHH_LISTING_UNIT_PRICE_AVG("二手房挂牌均价㎡", DimensionEnum.SECOND_HAND_HOUSE),
    SHH_LISTING_PRICE_AVG("二手房挂牌均总价", DimensionEnum.SECOND_HAND_HOUSE),
    SHH_LISTING_VOLUME("二手房挂牌数量", DimensionEnum.SECOND_HAND_HOUSE),
    SHH_INVENTORY_REMOVAL_CYCLE("二手房库存去化周期", DimensionEnum.SECOND_HAND_HOUSE),
    SHH_LANDLORD_PRICE_COEFFICIENT("二手房房东守价系数", DimensionEnum.SECOND_HAND_HOUSE),


    H_DEAL_UNIT_PRICE_AVG("新房成交均价㎡", DimensionEnum.NEW_HOUSE),
    H_DEAL_PRICE_AVG("新房成交均总价", DimensionEnum.NEW_HOUSE),
    H_DEAL_VOLUME("新房成交总套数", DimensionEnum.NEW_HOUSE),
    H_DEAL_PRICE_SUM("新房成交总金额", DimensionEnum.NEW_HOUSE),
    H_DEAL_AREA_SUM("新房成交总面积㎡", DimensionEnum.NEW_HOUSE),
    H_DEAL_AREA_AVG("新房成交均面积㎡", DimensionEnum.NEW_HOUSE),
    H_STOCK_RATE("新房库存量", DimensionEnum.NEW_HOUSE),
    H_SALE_PROJECT("新房在售项目", DimensionEnum.NEW_HOUSE)


//    一手房	成交均价	成交套数	成交均价同比	成交均价环比	成交套数环比	成交均总价	成交总金额	成交总面积	成交套均面积				库存去化周期	房东守价系数	总价段（成交套数 均价）	单价段（成交套数 均价）	面积段（成交套数 成交均价）
//    DEAL_PRICE("成交价格"),
//    DEAL_VOLUME("成交量"),
//    LISTING_PRICE("挂牌价格"),
//    LISTING_VOLUME("挂牌数量"),
//    SUM_AREA("总面积"),
//    SUM_PRICE("总价格")

//    二手房	成交均价	成交套数	成交均价同比	成交均价环比	成交套数环比	成交均总价	挂牌套数	挂牌均价	挂牌均价同比	挂牌均价环比	挂牌套数环比
// 挂牌总价	库存去化周期	房东守价系数
    ;

    //库存去化周期	房东守价系数	总价段（成交套数 均价）	单价段（成交套数 均价）	面积段（成交套数 成交均价）

    private String desc;
    private DimensionEnum dimensionEnum;

    IndexEnum(String desc, DimensionEnum dimensionEnum) {
        this.desc = desc;
        this.dimensionEnum = dimensionEnum;
    }

    @Override
    public Dimension dimension() {
        return dimensionEnum;
    }

    /**
     * 获取描述
     *
     * @return
     */
    @Override
    public String getDescription() {
        return desc;
    }
}