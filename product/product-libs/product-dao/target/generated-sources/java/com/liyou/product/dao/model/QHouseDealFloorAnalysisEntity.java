package com.liyou.product.dao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHouseDealFloorAnalysisEntity is a Querydsl query type for HouseDealFloorAnalysisEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHouseDealFloorAnalysisEntity extends EntityPathBase<HouseDealFloorAnalysisEntity> {

    private static final long serialVersionUID = -236901256L;

    public static final QHouseDealFloorAnalysisEntity houseDealFloorAnalysisEntity = new QHouseDealFloorAnalysisEntity("houseDealFloorAnalysisEntity");

    public final NumberPath<Integer> avgprice = createNumber("avgprice", Integer.class);

    public final NumberPath<Integer> cityId = createNumber("cityId", Integer.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Integer> dealCnt = createNumber("dealCnt", Integer.class);

    public final StringPath floorTag = createString("floorTag");

    public final NumberPath<Integer> houseId = createNumber("houseId", Integer.class);

    public final NumberPath<Integer> maxprice = createNumber("maxprice", Integer.class);

    public final NumberPath<Integer> medprice = createNumber("medprice", Integer.class);

    public final NumberPath<Integer> minprice = createNumber("minprice", Integer.class);

    public final NumberPath<Integer> proportion = createNumber("proportion", Integer.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QHouseDealFloorAnalysisEntity(String variable) {
        super(HouseDealFloorAnalysisEntity.class, forVariable(variable));
    }

    public QHouseDealFloorAnalysisEntity(Path<? extends HouseDealFloorAnalysisEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHouseDealFloorAnalysisEntity(PathMetadata metadata) {
        super(HouseDealFloorAnalysisEntity.class, metadata);
    }

}

