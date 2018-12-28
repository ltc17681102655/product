package com.liyou.product.biz;


import com.liyou.product.biz.model.TaskSchedulingBO;

/**
 * <pre>
 * @description
 * @copyright: Copyright (c)2017
 * @author: vincent
 * @version: 1.0
 * @date: 2018/11/7
 * </pre>
 */
public interface TaskSchedulingBiz {
    
    /**
     * 创建任务调度记录
     *
     * @param taskSchedulingBO
     * @return
     */
    TaskSchedulingBO create(TaskSchedulingBO taskSchedulingBO);
}
