package com.liyou.product.facade;

import com.liyou.framework.base.utils.ObjectUtils;
import com.liyou.product.biz.TaskSchedulingBiz;
import com.liyou.product.biz.model.TaskSchedulingBO;
import com.liyou.product.dao.TaskSchedulingRepo;
import com.liyou.product.dao.model.TaskSchedulingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * @description
 * @copyright: Copyright (c)2017
 * @author: vincent
 * @version: 1.0
 * @date: 2018/11/7
 * </pre>
 */
@Service
public class TaskSchedulingBizImpl implements TaskSchedulingBiz {
    
    @Autowired
    private TaskSchedulingRepo taskSchedulingRepo;
    
    @Override
    public TaskSchedulingBO create(TaskSchedulingBO taskSchedulingBO) {
        TaskSchedulingEntity entity = convert(taskSchedulingBO);
        entity = this.taskSchedulingRepo.save(entity);
        return ObjectUtils.copy(entity, TaskSchedulingBO.class);
    }
    
    static TaskSchedulingEntity convert(TaskSchedulingBO taskSchedulingBO) {
        TaskSchedulingEntity entity = ObjectUtils.copy(taskSchedulingBO, TaskSchedulingEntity.class);
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
