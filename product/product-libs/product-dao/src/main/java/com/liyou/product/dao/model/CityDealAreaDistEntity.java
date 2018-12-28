package com.liyou.product.dao.model;

import com.liyou.product.dao.model.keys.CityDealAreaDistEntityPK;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "city_deal_area_dist")
@IdClass(CityDealAreaDistEntityPK.class)
public class CityDealAreaDistEntity implements Serializable {
    private int cityId;
    private int isFirst;
    private int areaId;
    private int dealYear;
    private int dealMonth;
    private BigDecimal proportion;
    private Integer dealCnt;
    private BigDecimal dealCntMom;
    private Double dealPrice;
    private BigDecimal dealPriceMom;
    private Date createTime;
    private Date updateTime;
    private Integer quoteCnt;
    private BigDecimal quoteCntMom;
    private Double quotePrice;
    private BigDecimal quotePriceMom;
    private CityAreaRangeConfigEntity cityAreaRangeConfigEntity;

    @Id
    @Column(name = "city_id", nullable = false)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Id
    @Column(name = "is_first", nullable = false)
    public int getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(int isFirst) {
        this.isFirst = isFirst;
    }

    @Id
    @Column(name = "area_id", nullable = false)
    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Id
    @Column(name = "deal_year", nullable = false)
    public int getDealYear() {
        return dealYear;
    }

    public void setDealYear(int dealYear) {
        this.dealYear = dealYear;
    }

    @Id
    @Column(name = "deal_month", nullable = false)
    public int getDealMonth() {
        return dealMonth;
    }

    public void setDealMonth(int dealMonth) {
        this.dealMonth = dealMonth;
    }

    @Basic
    @Column(name = "proportion", nullable = true, precision = 2)
    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    @Basic
    @Column(name = "deal_cnt", nullable = true)
    public Integer getDealCnt() {
        return dealCnt;
    }

    public void setDealCnt(Integer dealCnt) {
        this.dealCnt = dealCnt;
    }

    @Basic
    @Column(name = "deal_cnt_mom", nullable = true, precision = 2)
    public BigDecimal getDealCntMom() {
        return dealCntMom;
    }

    public void setDealCntMom(BigDecimal dealCntMom) {
        this.dealCntMom = dealCntMom;
    }

    @Basic
    @Column(name = "deal_price", nullable = true, precision = 0)
    public Double getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(Double dealPrice) {
        this.dealPrice = dealPrice;
    }

    @Basic
    @Column(name = "deal_price_mom", nullable = true, precision = 2)
    public BigDecimal getDealPriceMom() {
        return dealPriceMom;
    }

    public void setDealPriceMom(BigDecimal dealPriceMom) {
        this.dealPriceMom = dealPriceMom;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "quote_cnt", nullable = true)
    public Integer getQuoteCnt() {
        return quoteCnt;
    }

    public void setQuoteCnt(Integer quoteCnt) {
        this.quoteCnt = quoteCnt;
    }

    @Basic
    @Column(name = "quote_cnt_mom", nullable = true, precision = 2)
    public BigDecimal getQuoteCntMom() {
        return quoteCntMom;
    }

    public void setQuoteCntMom(BigDecimal quoteCntMom) {
        this.quoteCntMom = quoteCntMom;
    }

    @Basic
    @Column(name = "quote_price", nullable = true, precision = 0)
    public Double getQuotePrice() {
        return quotePrice;
    }

    public void setQuotePrice(Double quotePrice) {
        this.quotePrice = quotePrice;
    }

    @Basic
    @Column(name = "quote_price_mom", nullable = true, precision = 2)
    public BigDecimal getQuotePriceMom() {
        return quotePriceMom;
    }

    public void setQuotePriceMom(BigDecimal quotePriceMom) {
        this.quotePriceMom = quotePriceMom;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "area_id",referencedColumnName = "periodid",insertable = false,updatable = false)
    })
    @NotFound(action= NotFoundAction.IGNORE)
    public CityAreaRangeConfigEntity getCityAreaRangeConfigEntity() {
        return cityAreaRangeConfigEntity;
    }

    public void setCityAreaRangeConfigEntity(CityAreaRangeConfigEntity cityAreaRangeConfigEntity) {
        this.cityAreaRangeConfigEntity = cityAreaRangeConfigEntity;
    }
}
