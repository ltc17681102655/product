package com.liyou.product.common.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/***
 *
 *   @author linxiaohui
 *   @date 2018/5/15
 ***/
public interface Range extends Comparable , Serializable {

    Long rangeValue();

    RangeTypeEnum getType();

    Date getDate();

    @Override
    default int compareTo(Object o) {

        if( o instanceof Range ){
            return this.rangeValue().compareTo(((Range) o).rangeValue());
        }
        return 0;
    }

    default Integer year(){

        Date date = getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    default Integer month(){

        Date date = getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH)+1;
    }

    default Integer dayOfMonth(){

        Date date = getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    default Integer weekOfYear(){

        Date date = getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }
}
