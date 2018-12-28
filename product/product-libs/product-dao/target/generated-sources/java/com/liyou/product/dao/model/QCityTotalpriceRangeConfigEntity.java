package com.liyou.product.dao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCityTotalpriceRangeConfigEntity is a Querydsl query type for CityTotalpriceRangeConfigEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCityTotalpriceRangeConfigEntity extends EntityPathBase<CityTotalpriceRangeConfigEntity> {

    private static final long serialVersionUID = 1141243865L;

    public static final QCityTotalpriceRangeConfigEntity cityTotalpriceRangeConfigEntity = new QCityTotalpriceRangeConfigEntity("cityTotalpriceRangeConfigEntity");

    public final NumberPath<Integer> bottomPrice = createNumber("bottomPrice", Integer.class);

    public final NumberPath<Integer> cityId = createNumber("cityId", Integer.class);

    public final NumberPath<Integer> periodid = createNumber("periodid", Integer.class);

    public final StringPath periodName = createString("periodName");

    public final NumberPath<Integer> topPrice = createNumber("topPrice", Integer.class);

    public QCityTotalpriceRangeConfigEntity(String variable) {
        super(CityTotalpriceRangeConfigEntity.class, forVariable(variable));
    }

    public QCityTotalpriceRangeConfigEntity(Path<? extends CityTotalpriceRangeConfigEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCityTotalpriceRangeConfigEntity(PathMetadata metadata) {
        super(CityTotalpriceRangeConfigEntity.class, metadata);
    }

}

