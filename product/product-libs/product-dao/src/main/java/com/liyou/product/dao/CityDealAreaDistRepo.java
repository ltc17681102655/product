package com.liyou.product.dao;

import com.liyou.framework.jpa.extend.JpaSpecificationExecutorExt;
import com.liyou.framework.jpa.extend.TupleJpaSpecificationExecutorExt;
import com.liyou.product.dao.model.CityDealAreaDistEntity;
import com.liyou.product.dao.model.keys.CityDealAreaDistEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 *
 *   @author lukang
 *   @date 2018/5/21
 ***/
public interface CityDealAreaDistRepo extends JpaSpecificationExecutorExt<CityDealAreaDistEntity>,
        JpaRepository<CityDealAreaDistEntity, CityDealAreaDistEntityPK>,
        TupleJpaSpecificationExecutorExt<CityDealAreaDistEntity> {
}
