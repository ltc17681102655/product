package com.liyou.product.dao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDistrictDealPriceDistEntity is a Querydsl query type for DistrictDealPriceDistEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDistrictDealPriceDistEntity extends EntityPathBase<DistrictDealPriceDistEntity> {

    private static final long serialVersionUID = 85097727L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDistrictDealPriceDistEntity districtDealPriceDistEntity = new QDistrictDealPriceDistEntity("districtDealPriceDistEntity");

    public final NumberPath<Integer> cityId = createNumber("cityId", Integer.class);

    public final QCityPriceRangeConfigEntity cityPriceRangeConfigEntity;

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Integer> dealCnt = createNumber("dealCnt", Integer.class);

    public final NumberPath<java.math.BigDecimal> dealCntMom = createNumber("dealCntMom", java.math.BigDecimal.class);

    public final NumberPath<Integer> dealMonth = createNumber("dealMonth", Integer.class);

    public final NumberPath<Double> dealPrice = createNumber("dealPrice", Double.class);

    public final NumberPath<java.math.BigDecimal> dealPriceMom = createNumber("dealPriceMom", java.math.BigDecimal.class);

    public final NumberPath<Integer> dealYear = createNumber("dealYear", Integer.class);

    public final NumberPath<Integer> districtId = createNumber("districtId", Integer.class);

    public final NumberPath<Integer> isFirst = createNumber("isFirst", Integer.class);

    public final NumberPath<Integer> priceId = createNumber("priceId", Integer.class);

    public final NumberPath<java.math.BigDecimal> proportion = createNumber("proportion", java.math.BigDecimal.class);

    public final NumberPath<Integer> quoteCnt = createNumber("quoteCnt", Integer.class);

    public final NumberPath<java.math.BigDecimal> quoteCntMom = createNumber("quoteCntMom", java.math.BigDecimal.class);

    public final NumberPath<Double> quotePrice = createNumber("quotePrice", Double.class);

    public final NumberPath<java.math.BigDecimal> quotePriceMom = createNumber("quotePriceMom", java.math.BigDecimal.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QDistrictDealPriceDistEntity(String variable) {
        this(DistrictDealPriceDistEntity.class, forVariable(variable), INITS);
    }

    public QDistrictDealPriceDistEntity(Path<? extends DistrictDealPriceDistEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDistrictDealPriceDistEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDistrictDealPriceDistEntity(PathMetadata metadata, PathInits inits) {
        this(DistrictDealPriceDistEntity.class, metadata, inits);
    }

    public QDistrictDealPriceDistEntity(Class<? extends DistrictDealPriceDistEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cityPriceRangeConfigEntity = inits.isInitialized("cityPriceRangeConfigEntity") ? new QCityPriceRangeConfigEntity(forProperty("cityPriceRangeConfigEntity")) : null;
    }

}

