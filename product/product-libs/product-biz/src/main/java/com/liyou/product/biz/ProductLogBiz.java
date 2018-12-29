package com.liyou.product.biz;


import com.liyou.product.biz.model.ProductLogBO;

/**
 * @Auther: ltc
 * @Date: 2018/12/29 9:26
 * @Description:
 */
public interface ProductLogBiz {
    
    /**
     * 创建任务调度记录
     *
     * @param productLogBO
     * @return
     */
    ProductLogBO create(ProductLogBO productLogBO);
}
