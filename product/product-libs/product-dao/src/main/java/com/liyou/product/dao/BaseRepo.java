package com.liyou.product.dao;

import com.liyou.framework.jpa.extend.JpaSpecificationExecutorExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * <pre>
 * @description
 * @copyright: Copyright (c)2017
 * @author: vincent
 * @version: 1.0
 * @date: 2018/10/1
 * </pre>
 */
@NoRepositoryBean
public interface BaseRepo<T> extends JpaRepository<T, Long>, JpaSpecificationExecutorExt<T> {
}
