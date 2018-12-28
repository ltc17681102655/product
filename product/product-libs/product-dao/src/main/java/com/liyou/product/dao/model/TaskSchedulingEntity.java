package com.liyou.product.dao.model;

import com.liyou.framework.base.model.YesOrNo;

import javax.persistence.*;
import java.util.Date;

/**
 * <pre>
 * @description
 * @copyright: Copyright (c)2017
 * @author: vincent
 * @version: 1.0
 * @date: 2018/11/7
 * </pre>
 */
@Entity
@Table(name = "cron_task_scheduling")
public class TaskSchedulingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * 执行时长
     */
    private Long performDuration;
    /**
     * 是否成功
     */
    @Enumerated(EnumType.STRING)
    private YesOrNo success;
    /**
     * 信息
     */
    private String message;
    
    public Long getId() {
        return id;
    }
    
    public TaskSchedulingEntity setId(Long id) {
        this.id = id;
        return this;
    }
    
    public String getTaskName() {
        return taskName;
    }
    
    public TaskSchedulingEntity setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }
    
    public String getClassName() {
        return className;
    }
    
    public TaskSchedulingEntity setClassName(String className) {
        this.className = className;
        return this;
    }
    
    public String getMethodName() {
        return methodName;
    }
    
    public TaskSchedulingEntity setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }
    
    public Date getBeginTime() {
        return beginTime;
    }
    
    public TaskSchedulingEntity setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
        return this;
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public TaskSchedulingEntity setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }
    
    public Long getPerformDuration() {
        return performDuration;
    }
    
    public TaskSchedulingEntity setPerformDuration(Long performDuration) {
        this.performDuration = performDuration;
        return this;
    }
    
    public YesOrNo getSuccess() {
        return success;
    }
    
    public TaskSchedulingEntity setSuccess(YesOrNo success) {
        this.success = success;
        return this;
    }
    
    public String getMessage() {
        return message;
    }
    
    public TaskSchedulingEntity setMessage(String message) {
        this.message = message;
        return this;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TaskSchedulingEntity{");
        sb.append("id=").append(id);
        sb.append(", taskName='").append(taskName).append('\'');
        sb.append(", className='").append(className).append('\'');
        sb.append(", methodName='").append(methodName).append('\'');
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", performDuration=").append(performDuration);
        sb.append(", success=").append(success);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
