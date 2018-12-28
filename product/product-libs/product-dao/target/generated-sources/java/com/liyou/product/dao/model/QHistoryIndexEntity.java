package com.liyou.product.dao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHistoryIndexEntity is a Querydsl query type for HistoryIndexEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHistoryIndexEntity extends EntityPathBase<HistoryIndexEntity> {

    private static final long serialVersionUID = 1215488026L;

    public static final QHistoryIndexEntity historyIndexEntity = new QHistoryIndexEntity("historyIndexEntity");

    public final StringPath analyticsObject = createString("analyticsObject");

    public final StringPath analyticsObjectName = createString("analyticsObjectName");

    public final EnumPath<com.liyou.product.common.model.AnalyticsObjectTypeEnum> analyticsObjectType = createEnum("analyticsObjectType", com.liyou.product.common.model.AnalyticsObjectTypeEnum.class);

    public final EnumPath<com.liyou.product.common.model.DimensionEnum> dimension = createEnum("dimension", com.liyou.product.common.model.DimensionEnum.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.liyou.product.common.model.IndexEnum> index = createEnum("index", com.liyou.product.common.model.IndexEnum.class);

    public final NumberPath<Double> monthOnMonth = createNumber("monthOnMonth", Double.class);

    public final NumberPath<Long> rangeValue = createNumber("rangeValue", Long.class);

    public final NumberPath<Double> value = createNumber("value", Double.class);

    public final NumberPath<Double> yearOnYear = createNumber("yearOnYear", Double.class);

    public QHistoryIndexEntity(String variable) {
        super(HistoryIndexEntity.class, forVariable(variable));
    }

    public QHistoryIndexEntity(Path<? extends HistoryIndexEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHistoryIndexEntity(PathMetadata metadata) {
        super(HistoryIndexEntity.class, metadata);
    }

}

