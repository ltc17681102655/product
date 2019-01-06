package com.liyou.product.common.annotations;

import java.lang.annotation.*;

/**
 * @Auther: ltc
 * @Date: 2018/12/28 13:36
 * @Description: 商品服务
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Product {
    String value();
}
