package com.liyou.product.dao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDistrictDealTotalpriceDistEntity is a Querydsl query type for DistrictDealTotalpriceDistEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDistrictDealTotalpriceDistEntity extends EntityPathBase<DistrictDealTotalpriceDistEntity> {

    private static final long serialVersionUID = 1211783681L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDistrictDealTotalpriceDistEntity districtDealTotalpriceDistEntity = new QDistrictDealTotalpriceDistEntity("districtDealTotalpriceDistEntity");

    public final NumberPath<Integer> cityId = createNumber("cityId", Integer.class);

    public final QCityTotalpriceRangeConfigEntity cityTotalpriceRangeConfigEntity;

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Integer> dealCnt = createNumber("dealCnt", Integer.class);

    public final NumberPath<java.math.BigDecimal> dealCntMom = createNumber("dealCntMom", java.math.BigDecimal.class);

    public final NumberPath<Integer> dealMonth = createNumber("dealMonth", Integer.class);

    public final NumberPath<Double> dealPrice = createNumber("dealPrice", Double.class);

    public final NumberPath<java.math.BigDecimal> dealPriceMom = createNumber("dealPriceMom", java.math.BigDecimal.class);

    public final NumberPath<Integer> dealYear = createNumber("dealYear", Integer.class);

    public final NumberPath<Integer> districtId = createNumber("districtId", Integer.class);

    public final NumberPath<Integer> isFirst = createNumber("isFirst", Integer.class);

    public final NumberPath<java.math.BigDecimal> proportion = createNumber("proportion", java.math.BigDecimal.class);

    public final NumberPath<Integer> quoteCnt = createNumber("quoteCnt", Integer.class);

    public final NumberPath<java.math.BigDecimal> quoteCntMom = createNumber("quoteCntMom", java.math.BigDecimal.class);

    public final NumberPath<Double> quotePrice = createNumber("quotePrice", Double.class);

    public final NumberPath<java.math.BigDecimal> quotePriceMom = createNumber("quotePriceMom", java.math.BigDecimal.class);

    public final NumberPath<Integer> totalpriceId = createNumber("totalpriceId", Integer.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QDistrictDealTotalpriceDistEntity(String variable) {
        this(DistrictDealTotalpriceDistEntity.class, forVariable(variable), INITS);
    }

    public QDistrictDealTotalpriceDistEntity(Path<? extends DistrictDealTotalpriceDistEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDistrictDealTotalpriceDistEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDistrictDealTotalpriceDistEntity(PathMetadata metadata, PathInits inits) {
        this(DistrictDealTotalpriceDistEntity.class, metadata, inits);
    }

    public QDistrictDealTotalpriceDistEntity(Class<? extends DistrictDealTotalpriceDistEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cityTotalpriceRangeConfigEntity = inits.isInitialized("cityTotalpriceRangeConfigEntity") ? new QCityTotalpriceRangeConfigEntity(forProperty("cityTotalpriceRangeConfigEntity")) : null;
    }

}

