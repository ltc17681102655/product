package com.liyou.product.dao;

import com.liyou.framework.jpa.extend.JpaSpecificationExecutorExt;
import com.liyou.framework.jpa.extend.TupleJpaSpecificationExecutorExt;
import com.liyou.product.dao.model.HouseDealBuildingAnalysisEntity;
import com.liyou.product.dao.model.keys.HouseDealBuildingKey;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: ltc
 * @Date: 2018/12/12 8:41
 * @Description:
 */
public interface HouseDealBuildingAnalysisRepo extends JpaRepository<HouseDealBuildingAnalysisEntity, HouseDealBuildingKey>,
        JpaSpecificationExecutorExt<HouseDealBuildingAnalysisEntity>,
        TupleJpaSpecificationExecutorExt<HouseDealBuildingAnalysisEntity> {
}
