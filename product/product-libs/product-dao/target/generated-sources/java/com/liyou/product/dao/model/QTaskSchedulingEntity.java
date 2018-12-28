package com.liyou.product.dao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTaskSchedulingEntity is a Querydsl query type for TaskSchedulingEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTaskSchedulingEntity extends EntityPathBase<TaskSchedulingEntity> {

    private static final long serialVersionUID = 728127989L;

    public static final QTaskSchedulingEntity taskSchedulingEntity = new QTaskSchedulingEntity("taskSchedulingEntity");

    public final DateTimePath<java.util.Date> beginTime = createDateTime("beginTime", java.util.Date.class);

    public final StringPath className = createString("className");

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath message = createString("message");

    public final StringPath methodName = createString("methodName");

    public final NumberPath<Long> performDuration = createNumber("performDuration", Long.class);

    public final EnumPath<com.liyou.framework.base.model.YesOrNo> success = createEnum("success", com.liyou.framework.base.model.YesOrNo.class);

    public final StringPath taskName = createString("taskName");

    public QTaskSchedulingEntity(String variable) {
        super(TaskSchedulingEntity.class, forVariable(variable));
    }

    public QTaskSchedulingEntity(Path<? extends TaskSchedulingEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTaskSchedulingEntity(PathMetadata metadata) {
        super(TaskSchedulingEntity.class, metadata);
    }

}

