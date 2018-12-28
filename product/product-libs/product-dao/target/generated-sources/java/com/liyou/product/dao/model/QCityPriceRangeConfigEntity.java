package com.liyou.product.dao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCityPriceRangeConfigEntity is a Querydsl query type for CityPriceRangeConfigEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCityPriceRangeConfigEntity extends EntityPathBase<CityPriceRangeConfigEntity> {

    private static final long serialVersionUID = -742648419L;

    public static final QCityPriceRangeConfigEntity cityPriceRangeConfigEntity = new QCityPriceRangeConfigEntity("cityPriceRangeConfigEntity");

    public final NumberPath<Integer> bottomPrice = createNumber("bottomPrice", Integer.class);

    public final NumberPath<Integer> cityId = createNumber("cityId", Integer.class);

    public final NumberPath<Integer> periodid = createNumber("periodid", Integer.class);

    public final StringPath periodName = createString("periodName");

    public final NumberPath<Integer> topPrice = createNumber("topPrice", Integer.class);

    public QCityPriceRangeConfigEntity(String variable) {
        super(CityPriceRangeConfigEntity.class, forVariable(variable));
    }

    public QCityPriceRangeConfigEntity(Path<? extends CityPriceRangeConfigEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCityPriceRangeConfigEntity(PathMetadata metadata) {
        super(CityPriceRangeConfigEntity.class, metadata);
    }

}

