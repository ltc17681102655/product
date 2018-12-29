package com.liyou.product.facade;

import com.liyou.framework.base.utils.ObjectUtils;
import com.liyou.product.biz.ProductLogBiz;
import com.liyou.product.biz.model.ProductLogBO;
import com.liyou.product.dao.ProductLogInfoRepo;
import com.liyou.product.dao.model.ProductLogInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: ltc
 * @Date: 2018/12/29 9:26
 * @Description:
 */
@Service
public class ProductLogBizImpl implements ProductLogBiz {
    
    @Autowired
    private ProductLogInfoRepo productLogInfoRepo;
    
    @Override
    public ProductLogBO create(ProductLogBO productLogBO) {
        ProductLogInfoEntity entity = convert(productLogBO);
        entity = this.productLogInfoRepo.save(entity);
        return ObjectUtils.copy(entity, ProductLogBO.class);
    }
    
    static ProductLogInfoEntity convert(ProductLogBO productLogBO) {
        ProductLogInfoEntity entity = ObjectUtils.copy(productLogBO, ProductLogInfoEntity.class);
        // 计算任务用时
        if (Objects.nonNull(entity.getBeginTime()) && Objects.nonNull(entity.getEndTime())) {
            long time = entity.getEndTime().getTime() - entity.getBeginTime().getTime();
            entity.setPerformDuration(TimeUnit.MILLISECONDS.convert(time, TimeUnit.SECONDS));
        }
        
        if (entity.getPerformDuration() == null) {
            entity.setPerformDuration(0L);
        }
        
        return entity;
    }
}
