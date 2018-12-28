package com.liyou.product.biz.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther: ltc
 * @Date: 2018/10/27 23:58
 * @Description: 抽取公用饼状图数据
 */
public class HousePriceAreaPieChartInfo implements Serializable {

    private int totalpriceId;
    private int priceId;
    private int areaId;
    private BigDecimal proportion;
    private Integer dealCnt;
    private BigDecimal dealCntMom;
    private Double dealPrice;
    private BigDecimal dealPriceMom;
    private Integer quoteCnt;
    private BigDecimal quoteCntMom;
    private Double quotePrice;
    private BigDecimal quotePriceMom;

    public int getTotalpriceId() {
        return totalpriceId;
    }

    public void setTotalpriceId(int totalpriceId) {
        this.totalpriceId = totalpriceId;
    }

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    public Integer getDealCnt() {
        return dealCnt;
    }

    public void setDealCnt(Integer dealCnt) {
        this.dealCnt = dealCnt;
    }

    public BigDecimal getDealCntMom() {
        return dealCntMom;
    }

    public void setDealCntMom(BigDecimal dealCntMom) {
        this.dealCntMom = dealCntMom;
    }

    public Double getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(Double dealPrice) {
        this.dealPrice = dealPrice;
    }

    public BigDecimal getDealPriceMom() {
        return dealPriceMom;
    }

    public void setDealPriceMom(BigDecimal dealPriceMom) {
        this.dealPriceMom = dealPriceMom;
    }

    public Integer getQuoteCnt() {
        return quoteCnt;
    }

    public void setQuoteCnt(Integer quoteCnt) {
        this.quoteCnt = quoteCnt;
    }

    public BigDecimal getQuoteCntMom() {
        return quoteCntMom;
    }

    public void setQuoteCntMom(BigDecimal quoteCntMom) {
        this.quoteCntMom = quoteCntMom;
    }

    public Double getQuotePrice() {
        return quotePrice;
    }

    public void setQuotePrice(Double quotePrice) {
        this.quotePrice = quotePrice;
    }

    public BigDecimal getQuotePriceMom() {
        return quotePriceMom;
    }

    public void setQuotePriceMom(BigDecimal quotePriceMom) {
        this.quotePriceMom = quotePriceMom;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "HousePriceAreaPieChartInfo{" +
                "totalpriceId=" + totalpriceId +
                ", priceId=" + priceId +
                ", areaId=" + areaId +
                ", proportion=" + proportion +
                ", dealCnt=" + dealCnt +
                ", dealCntMom=" + dealCntMom +
                ", dealPrice=" + dealPrice +
                ", dealPriceMom=" + dealPriceMom +
                ", quoteCnt=" + quoteCnt +
                ", quoteCntMom=" + quoteCntMom +
                ", quotePrice=" + quotePrice +
                ", quotePriceMom=" + quotePriceMom +
                '}';
    }
}
