package com.liyou.product.dao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCityAreaRangeConfigEntity is a Querydsl query type for CityAreaRangeConfigEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCityAreaRangeConfigEntity extends EntityPathBase<CityAreaRangeConfigEntity> {

    private static final long serialVersionUID = -181019183L;

    public static final QCityAreaRangeConfigEntity cityAreaRangeConfigEntity = new QCityAreaRangeConfigEntity("cityAreaRangeConfigEntity");

    public final NumberPath<Integer> bottomArea = createNumber("bottomArea", Integer.class);

    public final NumberPath<Integer> periodid = createNumber("periodid", Integer.class);

    public final StringPath periodName = createString("periodName");

    public final NumberPath<Integer> topArea = createNumber("topArea", Integer.class);

    public QCityAreaRangeConfigEntity(String variable) {
        super(CityAreaRangeConfigEntity.class, forVariable(variable));
    }

    public QCityAreaRangeConfigEntity(Path<? extends CityAreaRangeConfigEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCityAreaRangeConfigEntity(PathMetadata metadata) {
        super(CityAreaRangeConfigEntity.class, metadata);
    }

}

