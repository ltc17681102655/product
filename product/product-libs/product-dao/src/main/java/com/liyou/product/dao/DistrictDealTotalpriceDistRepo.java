package com.liyou.product.dao;

import com.liyou.framework.jpa.extend.JpaSpecificationExecutorExt;
import com.liyou.framework.jpa.extend.TupleJpaSpecificationExecutorExt;
import com.liyou.product.dao.model.DistrictDealTotalpriceDistEntity;
import com.liyou.product.dao.model.keys.DistrictDealTotalpriceDistEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictDealTotalpriceDistRepo extends JpaSpecificationExecutorExt<DistrictDealTotalpriceDistEntity>,
        JpaRepository<DistrictDealTotalpriceDistEntity, DistrictDealTotalpriceDistEntityPK>,
        TupleJpaSpecificationExecutorExt<DistrictDealTotalpriceDistEntity> {
}
