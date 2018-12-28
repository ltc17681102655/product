package com.liyou.product.dao;

import com.liyou.framework.jpa.extend.TupleJpaSpecificationExecutorExt;
import com.liyou.product.dao.model.HistoryIndexEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 *
 *   @author linxiaohui
 *   @date 2018/5/15
 ***/
public interface HistoryIndexRepo extends JpaRepository<HistoryIndexEntity, Long>,
        TupleJpaSpecificationExecutorExt<HistoryIndexEntity> {
}
