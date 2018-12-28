package com.liyou.product;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.liyou.framework.jpa.extend.JpaRepositoryFactoryBeanExt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableDubbo(scanBasePackages = {"com.liyou.product"})
@EnableTransactionManagement
@EnableJpaAuditing
@EnableJpaRepositories(repositoryFactoryBeanClass = JpaRepositoryFactoryBeanExt.class)
@SpringBootApplication(scanBasePackages = "com.liyou")
public class ProductApplication {
    public static void main(String[] args) {
        new SpringApplication(ProductApplication.class).run(args);
    }
}
