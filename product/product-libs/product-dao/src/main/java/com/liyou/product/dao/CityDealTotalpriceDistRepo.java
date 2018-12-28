package com.liyou.product.dao;

import com.liyou.framework.jpa.extend.JpaSpecificationExecutorExt;
import com.liyou.framework.jpa.extend.TupleJpaSpecificationExecutorExt;
import com.liyou.product.dao.model.CityDealTotalpriceDistEntity;
import com.liyou.product.dao.model.keys.CityDealTotalpriceDistEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 *
 *   @author lukang
 *   @date 2018/5/21
 ***/
public interface CityDealTotalpriceDistRepo extends JpaSpecificationExecutorExt<CityDealTotalpriceDistEntity>,
        JpaRepository<CityDealTotalpriceDistEntity, CityDealTotalpriceDistEntityPK>,
        TupleJpaSpecificationExecutorExt<CityDealTotalpriceDistEntity> {
}
