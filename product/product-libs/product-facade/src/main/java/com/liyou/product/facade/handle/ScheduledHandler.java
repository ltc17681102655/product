package com.liyou.product.facade.handle;

import com.liyou.framework.base.model.YesOrNo;
import com.liyou.product.biz.ProductLogBiz;
import com.liyou.product.biz.model.ProductLogBO;
import com.liyou.product.common.annotations.Product;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * @Auther: ltc
 * @Date: 2018/12/28 15:46
 * @Description: 通过AOP监控方法的执行情况，并保存到数据库中
 */
@Aspect
@Component
public class ScheduledHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledHandler.class);

    private static int MAX_MESSAGE_LENGTH = 500;

    @Autowired
    private ProductLogBiz productLogBiz;

    @Around("@annotation(org.springframework.scheduling.annotation.Scheduled)")
    public Object aroundScheduled(ProceedingJoinPoint point) {
        return this.around(point, null);
    }

    @Around("@annotation(product)")
    public Object aroundScheduled1(ProceedingJoinPoint point, Product product) {
        return this.around(point, product);
    }

    private Object around(ProceedingJoinPoint point, Product product) {
        Object result = null;
        Date beginDate = new Date();
        try {
            //打印参数
            this.printPointMessage(point);
            result = point.proceed();
        } catch (Throwable ex) {
            ProductLogBO schedulingBO = new ProductLogBO();
            String taskName = product == null ? point.getTarget().getClass().getSimpleName() : product.value();
            schedulingBO.setTaskName(taskName);
            schedulingBO.setClassName(point.getTarget().getClass().getName());
            schedulingBO.setMethodName(point.getSignature().getName());
            schedulingBO.setBeginTime(beginDate);
            String message = ex.getMessage();
            if (message != null && message.length() > MAX_MESSAGE_LENGTH) {
                message = message.substring(0, MAX_MESSAGE_LENGTH);
            }
            schedulingBO.setSuccess(YesOrNo.N);
            schedulingBO.setMessage(message);
            schedulingBO.setEndTime(new Date());
            try {
                schedulingBO = this.productLogBiz.create(schedulingBO);
            } catch (Exception e) {
                LOGGER.info("商品服务调用失败id:{},message:{}", schedulingBO.getId(), message, e);
            }
        }

        return result;
    }

    private void printPointMessage(ProceedingJoinPoint point) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("调用方法：{}", point.getSignature().toLongString());
            LOGGER.debug("方法参数：{}", this.getRequestParam(point));
        }
    }

    private String getRequestParam(ProceedingJoinPoint point) {
        StringBuilder builder = new StringBuilder();
        for (Object obj : point.getArgs()) {
            builder.append("\r\n");
            builder.append(Objects.nonNull(obj) ? obj.toString() : null);
            builder.append(";");
        }
        return builder.toString();
    }
}
