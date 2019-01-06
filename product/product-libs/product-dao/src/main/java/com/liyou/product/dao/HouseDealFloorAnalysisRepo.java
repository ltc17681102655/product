package com.liyou.product.dao;

import com.liyou.framework.jpa.extend.JpaSpecificationExecutorExt;
import com.liyou.framework.jpa.extend.TupleJpaSpecificationExecutorExt;
import com.liyou.product.dao.model.HouseDealFloorAnalysisEntity;
import com.liyou.product.dao.model.keys.HouseDealFloorKey;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: ltc
 * @Date: 2018/12/12 8:41
 * @Description:
 */
public interface HouseDealFloorAnalysisRepo extends JpaRepository<HouseDealFloorAnalysisEntity, HouseDealFloorKey>,
        JpaSpecificationExecutorExt<HouseDealFloorAnalysisEntity>,
        TupleJpaSpecificationExecutorExt<HouseDealFloorAnalysisEntity> {
}
