package com.liyou.product.biz.utils;

import com.liyou.product.common.model.HistoryIndexQueryHelp;
import com.liyou.product.common.model.IndexValue;
import com.liyou.product.dao.model.HistoryIndexEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 *
 *   @author linxiaohui
 *   @date 2018/3/6
 ***/
public class Converts {

    private static final Logger logger = LoggerFactory.getLogger(Converts.class);

    public static IndexValue convert2IndexValue(HistoryIndexEntity indexEntity) {
        IndexValue indexValue = new IndexValue();
        indexValue.setValue(indexEntity.getValue());
        if (indexEntity.getYearOnYear() != null) {
            indexValue.setYearOnYear(indexEntity.getYearOnYear());
        }
        if (indexEntity.getMonthOnMonth() != null) {
            indexValue.setMonthOnMonth(indexEntity.getMonthOnMonth());
        }
        indexValue.setIndex(indexEntity.getIndex());
        indexValue.setRange(HistoryIndexQueryHelp.range(indexEntity.getRangeValue()));
        indexValue.setAnalyticsObjectName(indexEntity.getAnalyticsObjectName());
        indexValue.setAnalyticsObject(HistoryIndexQueryHelp.analytics(indexEntity.getAnalyticsObject()));

        return indexValue;
    }
}
