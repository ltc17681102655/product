package com.liyou.product.dao.model;

import com.liyou.framework.base.model.YesOrNo;

import javax.persistence.*;
import java.util.Date;

/**
 * @Auther: ltc
 * @Date: 2018/12/28 17:56
 * @Description: 商品日志
 */
@Entity
@Table(name = "product_log_info")
public class ProductLogInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**
     * 任务名称
     */
    @Column(name = "task_name")
    private String taskName;
    /**
     * 任务执行的类名
     */
    @Column(name = "class_name")
    private String className;
    /**
     * 任务执行的方法
     */
    @Column(name = "method_name")
    private String methodName;
    /**
     * 开始时间
     */
    @Column(name = "begin_time")
    private Date beginTime;
    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;
    /**
     * 执行时长
     */
    @Column(name = "perform_duration")
    private Long performDuration;
    /**
     * 是否成功
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "success")
    private YesOrNo success;
    /**
     * 信息
     */
    @Column(name = "message")
    private String message;

    public Long getId() {
        return id;
    }

    public ProductLogInfoEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTaskName() {
        return taskName;
    }

    public ProductLogInfoEntity setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public ProductLogInfoEntity setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public ProductLogInfoEntity setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public ProductLogInfoEntity setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public ProductLogInfoEntity setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Long getPerformDuration() {
        return performDuration;
    }

    public ProductLogInfoEntity setPerformDuration(Long performDuration) {
        this.performDuration = performDuration;
        return this;
    }

    public YesOrNo getSuccess() {
        return success;
    }

    public ProductLogInfoEntity setSuccess(YesOrNo success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ProductLogInfoEntity setMessage(String message) {
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
