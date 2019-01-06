package com.liyou.product.dao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductLogInfoEntity is a Querydsl query type for ProductLogInfoEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductLogInfoEntity extends EntityPathBase<ProductLogInfoEntity> {

    private static final long serialVersionUID = 1188079519L;

    public static final QProductLogInfoEntity productLogInfoEntity = new QProductLogInfoEntity("productLogInfoEntity");

    public final DateTimePath<java.util.Date> beginTime = createDateTime("beginTime", java.util.Date.class);

    public final StringPath className = createString("className");

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath message = createString("message");

    public final StringPath methodName = createString("methodName");

    public final NumberPath<Long> performDuration = createNumber("performDuration", Long.class);

    public final EnumPath<com.liyou.framework.base.model.YesOrNo> success = createEnum("success", com.liyou.framework.base.model.YesOrNo.class);

    public final StringPath taskName = createString("taskName");

    public QProductLogInfoEntity(String variable) {
        super(ProductLogInfoEntity.class, forVariable(variable));
    }

    public QProductLogInfoEntity(Path<? extends ProductLogInfoEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductLogInfoEntity(PathMetadata metadata) {
        super(ProductLogInfoEntity.class, metadata);
    }

}

