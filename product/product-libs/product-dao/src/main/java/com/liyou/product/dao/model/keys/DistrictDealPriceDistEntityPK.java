package com.liyou.product.dao.model.keys;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DistrictDealPriceDistEntityPK implements Serializable {
    private int cityId;
    private int districtId;
    private int isFirst;
    private int priceId;
    private int dealYear;
    private int dealMonth;

    @Column(name = "city_id", nullable = false)
    @Id
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Column(name = "district_id", nullable = false)
    @Id
    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    @Column(name = "is_first", nullable = false)
    @Id
    public int getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(int isFirst) {
        this.isFirst = isFirst;
    }

    @Column(name = "price_id", nullable = false)
    @Id
    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    @Column(name = "deal_year", nullable = false)
    @Id
    public int getDealYear() {
        return dealYear;
    }

    public void setDealYear(int dealYear) {
        this.dealYear = dealYear;
    }

    @Column(name = "deal_month", nullable = false)
    @Id
    public int getDealMonth() {
        return dealMonth;
    }

    public void setDealMonth(int dealMonth) {
        this.dealMonth = dealMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DistrictDealPriceDistEntityPK that = (DistrictDealPriceDistEntityPK) o;
        return cityId == that.cityId &&
                isFirst == that.isFirst &&
                priceId == that.priceId &&
                dealYear == that.dealYear &&
                dealMonth == that.dealMonth;
    }

    @Override
    public int hashCode() {

        return Objects.hash(cityId, isFirst, priceId, dealYear, dealMonth);
    }
}
