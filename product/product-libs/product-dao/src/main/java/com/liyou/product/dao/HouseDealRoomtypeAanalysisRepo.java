package com.liyou.product.dao;

import com.liyou.framework.jpa.extend.JpaSpecificationExecutorExt;
import com.liyou.framework.jpa.extend.TupleJpaSpecificationExecutorExt;
import com.liyou.product.dao.model.HouseDealRoomtypeAanalysisEntity;
import com.liyou.product.dao.model.keys.HouseDealRoomtypeKey;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: ltc
 * @Date: 2018/12/12 8:41
 * @Description:
 */
public interface HouseDealRoomtypeAanalysisRepo extends JpaRepository<HouseDealRoomtypeAanalysisEntity, HouseDealRoomtypeKey>,
        JpaSpecificationExecutorExt<HouseDealRoomtypeAanalysisEntity>,
        TupleJpaSpecificationExecutorExt<HouseDealRoomtypeAanalysisEntity> {
}
