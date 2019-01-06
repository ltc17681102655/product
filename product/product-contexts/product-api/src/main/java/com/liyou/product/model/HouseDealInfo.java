package com.liyou.product.model;


import com.liyou.product.common.enums.DealTypeEnum;
import com.liyou.product.model.mingle.BasicDealInfo;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: ltc
 * @Date: 2018/12/11 16:30
 * @Description: 小区成交数据
 */
public class HouseDealInfo implements Serializable {
    /**
     * 成交数据类型
     */
    private DealTypeEnum dealTypeEnum;
    /**
     * 成交数据
     */
    private List<BasicDealInfo> dealInfos;
    /**
     * 总数
     */
    private long totalCount;

    public DealTypeEnum getDealTypeEnum() {
        return dealTypeEnum;
    }

    public void setDealTypeEnum(DealTypeEnum dealTypeEnum) {
        this.dealTypeEnum = dealTypeEnum;
    }

    public List<BasicDealInfo> getDealInfos() {
        return dealInfos;
    }

    public void setDealInfos(List<BasicDealInfo> dealInfos) {
        this.dealInfos = dealInfos;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "HouseDealInfo{" +
                "dealTypeEnum=" + dealTypeEnum +
                ", dealInfos=" + dealInfos +
                ", totalCount=" + totalCount +
                '}';
    }
}
