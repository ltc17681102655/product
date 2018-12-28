package com.liyou.product.dao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCityDealPriceDistEntity is a Querydsl query type for CityDealPriceDistEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCityDealPriceDistEntity extends EntityPathBase<CityDealPriceDistEntity> {

    private static final long serialVersionUID = 1229992834L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCityDealPriceDistEntity cityDealPriceDistEntity = new QCityDealPriceDistEntity("cityDealPriceDistEntity");

    public final NumberPath<Integer> cityId = createNumber("cityId", Integer.class);

    public final QCityPriceRangeConfigEntity cityPriceRangeConfigEntity;

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Integer> dealCnt = createNumber("dealCnt", Integer.class);

    public final NumberPath<java.math.BigDecimal> dealCntMom = createNumber("dealCntMom", java.math.BigDecimal.class);

    public final NumberPath<Integer> dealMonth = createNumber("dealMonth", Integer.class);

    public final NumberPath<Double> dealPrice = createNumber("dealPrice", Double.class);

    public final NumberPath<java.math.BigDecimal> dealPriceMom = createNumber("dealPriceMom", java.math.BigDecimal.class);

    public final NumberPath<Integer> dealYear = createNumber("dealYear", Integer.class);

    public final NumberPath<Integer> isFirst = createNumber("isFirst", Integer.class);

    public final NumberPath<Integer> priceId = createNumber("priceId", Integer.class);

    public final NumberPath<java.math.BigDecimal> proportion = createNumber("proportion", java.math.BigDecimal.class);

    public final NumberPath<Integer> quoteCnt = createNumber("quoteCnt", Integer.class);

    public final NumberPath<java.math.BigDecimal> quoteCntMom = createNumber("quoteCntMom", java.math.BigDecimal.class);

    public final NumberPath<Double> quotePrice = createNumber("quotePrice", Double.class);

    public final NumberPath<java.math.BigDecimal> quotePriceMom = createNumber("quotePriceMom", java.math.BigDecimal.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QCityDealPriceDistEntity(String variable) {
        this(CityDealPriceDistEntity.class, forVariable(variable), INITS);
    }

    public QCityDealPriceDistEntity(Path<? extends CityDealPriceDistEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCityDealPriceDistEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCityDealPriceDistEntity(PathMetadata metadata, PathInits inits) {
        this(CityDealPriceDistEntity.class, metadata, inits);
    }

    public QCityDealPriceDistEntity(Class<? extends CityDealPriceDistEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cityPriceRangeConfigEntity = inits.isInitialized("cityPriceRangeConfigEntity") ? new QCityPriceRangeConfigEntity(forProperty("cityPriceRangeConfigEntity")) : null;
    }

}

