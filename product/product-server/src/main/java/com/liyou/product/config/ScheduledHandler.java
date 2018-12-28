package com.liyou.product.config;

import com.liyou.framework.base.model.YesOrNo;
import com.liyou.product.biz.TaskSchedulingBiz;
import com.liyou.product.biz.model.TaskSchedulingBO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author vincent
 * 通过AOP监控方法的执行情况，并保存到数据库中
 **/
@Aspect
@Component
public class ScheduledHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledHandler.class);
    
    private static int MAX_MESSAGE_LENGTH = 500;
    
    @Autowired
    private TaskSchedulingBiz schedulingBiz;
    
    @Around("@annotation(org.springframework.scheduling.annotation.Scheduled)")
    public Object aroundScheduled(ProceedingJoinPoint point) {
        return this.around(point, null);
    }
    
    @Around("@annotation(product)")
    public Object aroundScheduled1(ProceedingJoinPoint point, Product product) {
        return this.around(point, product);
    }
    
    private Object around(ProceedingJoinPoint point, Product product) {
        LOGGER.debug("调用方法：{}", point.getSignature());
        Object result = null;
        TaskSchedulingBO schedulingBO = new TaskSchedulingBO();
        try {
            String taskName = product == null ? point.getTarget().getClass().getSimpleName() : product.value();
            schedulingBO.setTaskName(taskName);
            schedulingBO.setClassName(point.getTarget().getClass().getName());
            schedulingBO.setMethodName(point.getSignature().getName());
            schedulingBO.setBeginTime(new Date());
            result = point.proceed();
            schedulingBO.setSuccess(YesOrNo.Y);
        } catch (Throwable ex) {
            schedulingBO.setSuccess(YesOrNo.N);
            String message = ex.getMessage();
            if (message != null && message.length() > MAX_MESSAGE_LENGTH) {
                message = message.substring(0, MAX_MESSAGE_LENGTH);
            }
            schedulingBO.setMessage(message);
            LOGGER.info("执行调度任务失败", ex);
        } finally {
            schedulingBO.setEndTime(new Date());
            schedulingBO = this.schedulingBiz.create(schedulingBO);
            LOGGER.debug("生成任务调度记录：{}", schedulingBO.getId());
        }
        return result;
    }
}
