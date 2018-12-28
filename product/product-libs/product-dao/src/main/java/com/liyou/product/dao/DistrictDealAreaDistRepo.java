package com.liyou.product.dao;

import com.liyou.framework.jpa.extend.JpaSpecificationExecutorExt;
import com.liyou.framework.jpa.extend.TupleJpaSpecificationExecutorExt;
import com.liyou.product.dao.model.DistrictDealAreaDistEntity;
import com.liyou.product.dao.model.keys.DistrictDealAreaDistEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictDealAreaDistRepo extends JpaSpecificationExecutorExt<DistrictDealAreaDistEntity>,
        JpaRepository<DistrictDealAreaDistEntity, DistrictDealAreaDistEntityPK>,
        TupleJpaSpecificationExecutorExt<DistrictDealAreaDistEntity> {
}
