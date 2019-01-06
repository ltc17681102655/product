package com.liyou.product.dao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHouseDealBuildingAnalysisEntity is a Querydsl query type for HouseDealBuildingAnalysisEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHouseDealBuildingAnalysisEntity extends EntityPathBase<HouseDealBuildingAnalysisEntity> {

    private static final long serialVersionUID = 690838310L;

    public static final QHouseDealBuildingAnalysisEntity houseDealBuildingAnalysisEntity = new QHouseDealBuildingAnalysisEntity("houseDealBuildingAnalysisEntity");

    public final NumberPath<Integer> avgprice = createNumber("avgprice", Integer.class);

    public final StringPath building = createString("building");

    public final NumberPath<Integer> cityId = createNumber("cityId", Integer.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Integer> dealCnt = createNumber("dealCnt", Integer.class);

    public final NumberPath<Integer> houseId = createNumber("houseId", Integer.class);

    public final NumberPath<Integer> maxprice = createNumber("maxprice", Integer.class);

    public final NumberPath<Integer> medprice = createNumber("medprice", Integer.class);

    public final NumberPath<Integer> minprice = createNumber("minprice", Integer.class);

    public final NumberPath<Integer> proportion = createNumber("proportion", Integer.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QHouseDealBuildingAnalysisEntity(String variable) {
        super(HouseDealBuildingAnalysisEntity.class, forVariable(variable));
    }

    public QHouseDealBuildingAnalysisEntity(Path<? extends HouseDealBuildingAnalysisEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHouseDealBuildingAnalysisEntity(PathMetadata metadata) {
        super(HouseDealBuildingAnalysisEntity.class, metadata);
    }

}

