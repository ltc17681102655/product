package com.liyou.product.biz.model;

import com.liyou.framework.base.model.YesOrNo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * @Auther: ltc
 * @Date: 2018/12/28 15:49
 * @Description: 商品服务错误记录
 */
public class ProductErrorLogBO {
    private Long id;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务执行的类名
     */
    private String className;
    /**
     * 任务执行的方法
     */
    private String methodName;
    /**
     * 开始时间
     */
    private Date beginTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 信息
     */
    private String message;

    public Long getId() {
        return id;
    }

    public ProductErrorLogBO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTaskName() {
        return taskName;
    }

    public ProductErrorLogBO setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public ProductErrorLogBO setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public ProductErrorLogBO setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public ProductErrorLogBO setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public ProductErrorLogBO setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ProductErrorLogBO setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TaskSchedulingBO{");
        sb.append("id=").append(id);
        sb.append(", taskName='").append(taskName).append('\'');
        sb.append(", className='").append(className).append('\'');
        sb.append(", methodName='").append(methodName).append('\'');
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
