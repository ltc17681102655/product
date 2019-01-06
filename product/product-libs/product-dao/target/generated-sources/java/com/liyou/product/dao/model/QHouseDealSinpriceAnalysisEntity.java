package com.liyou.product.dao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHouseDealSinpriceAnalysisEntity is a Querydsl query type for HouseDealSinpriceAnalysisEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHouseDealSinpriceAnalysisEntity extends EntityPathBase<HouseDealSinpriceAnalysisEntity> {

    private static final long serialVersionUID = -1732971229L;

    public static final QHouseDealSinpriceAnalysisEntity houseDealSinpriceAnalysisEntity = new QHouseDealSinpriceAnalysisEntity("houseDealSinpriceAnalysisEntity");

    public final NumberPath<Integer> avgprice = createNumber("avgprice", Integer.class);

    public final NumberPath<Integer> cityId = createNumber("cityId", Integer.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Integer> dealCnt = createNumber("dealCnt", Integer.class);

    public final NumberPath<Integer> houseId = createNumber("houseId", Integer.class);

    public final NumberPath<Integer> hPrice = createNumber("hPrice", Integer.class);

    public final NumberPath<Integer> lPrice = createNumber("lPrice", Integer.class);

    public final NumberPath<Integer> proportion = createNumber("proportion", Integer.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QHouseDealSinpriceAnalysisEntity(String variable) {
        super(HouseDealSinpriceAnalysisEntity.class, forVariable(variable));
    }

    public QHouseDealSinpriceAnalysisEntity(Path<? extends HouseDealSinpriceAnalysisEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHouseDealSinpriceAnalysisEntity(PathMetadata metadata) {
        super(HouseDealSinpriceAnalysisEntity.class, metadata);
    }

}

