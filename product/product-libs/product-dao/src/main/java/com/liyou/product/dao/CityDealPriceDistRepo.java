package com.liyou.product.dao;

import com.liyou.framework.jpa.extend.JpaSpecificationExecutorExt;
import com.liyou.framework.jpa.extend.TupleJpaSpecificationExecutorExt;
import com.liyou.product.dao.model.CityDealPriceDistEntity;
import com.liyou.product.dao.model.keys.CityDealPriceDistEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 *
 *   @author lukang
 *   @date 2018/5/21
 ***/
public interface CityDealPriceDistRepo extends JpaSpecificationExecutorExt<CityDealPriceDistEntity>,
        JpaRepository<CityDealPriceDistEntity, CityDealPriceDistEntityPK>,
        TupleJpaSpecificationExecutorExt<CityDealPriceDistEntity> {
}
