package com.liyou.product.dao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHouseDealRoomtypeAanalysisEntity is a Querydsl query type for HouseDealRoomtypeAanalysisEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHouseDealRoomtypeAanalysisEntity extends EntityPathBase<HouseDealRoomtypeAanalysisEntity> {

    private static final long serialVersionUID = 511145496L;

    public static final QHouseDealRoomtypeAanalysisEntity houseDealRoomtypeAanalysisEntity = new QHouseDealRoomtypeAanalysisEntity("houseDealRoomtypeAanalysisEntity");

    public final NumberPath<Integer> avgprice = createNumber("avgprice", Integer.class);

    public final NumberPath<Integer> cityId = createNumber("cityId", Integer.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Integer> dealArea = createNumber("dealArea", Integer.class);

    public final NumberPath<Integer> dealCnt = createNumber("dealCnt", Integer.class);

    public final NumberPath<Integer> houseId = createNumber("houseId", Integer.class);

    public final NumberPath<Integer> maxprice = createNumber("maxprice", Integer.class);

    public final NumberPath<Integer> medprice = createNumber("medprice", Integer.class);

    public final NumberPath<Integer> minprice = createNumber("minprice", Integer.class);

    public final NumberPath<Integer> proportion = createNumber("proportion", Integer.class);

    public final StringPath roomtype = createString("roomtype");

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QHouseDealRoomtypeAanalysisEntity(String variable) {
        super(HouseDealRoomtypeAanalysisEntity.class, forVariable(variable));
    }

    public QHouseDealRoomtypeAanalysisEntity(Path<? extends HouseDealRoomtypeAanalysisEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHouseDealRoomtypeAanalysisEntity(PathMetadata metadata) {
        super(HouseDealRoomtypeAanalysisEntity.class, metadata);
    }

}

