package com.liyou.product.dao;

import com.liyou.framework.jpa.extend.JpaSpecificationExecutorExt;
import com.liyou.framework.jpa.extend.TupleJpaSpecificationExecutorExt;
import com.liyou.product.dao.model.DistrictDealPriceDistEntity;
import com.liyou.product.dao.model.keys.DistrictDealPriceDistEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictDealPriceDistRepo extends JpaSpecificationExecutorExt<DistrictDealPriceDistEntity>,
        JpaRepository<DistrictDealPriceDistEntity, DistrictDealPriceDistEntityPK>,
        TupleJpaSpecificationExecutorExt<DistrictDealPriceDistEntity> {
}
