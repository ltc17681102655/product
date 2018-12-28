package com.liyou.product.common.model;

import com.google.common.collect.Lists;
import com.liyou.framework.base.utils.DateUtils;
import com.liyou.product.common.model.criteria.HistoryIndexQuery;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/***
 *
 *   @author linxiaohui
 *   @date 2018/5/15
 ***/
public class HistoryIndexQueryHelp implements Serializable {

    public static class CustomRange implements Range, Serializable {

        private Long rangeValue;
        private RangeTypeEnum type;
        private Date date;

        private CustomRange() {

        }

        public CustomRange(Date date, RangeTypeEnum type) {

            switch (type) {
                case MONTH:
                    this.rangeValue = Long.valueOf(DateUtils.format(date, "yyyyMM"));
                    break;
                case DAY:
                    this.rangeValue = Long.valueOf(DateUtils.format(date, "yyyyMMdd"));
                    break;
                case WEEK:
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(date);
                    int year = instance.get(Calendar.YEAR);
                    int week = instance.get(Calendar.WEEK_OF_YEAR);
                    String weekStr = week < 10 ? ("0" + week) : (week + "");
                    this.rangeValue = Long.valueOf("" + year + 0 + weekStr);
//                    this.rangeValue = Long.valueOf(DateUtils.format(instance.getTime(), "yyyy0ww"));
                    break;
            }

            this.date = date;
            this.type = type;
        }

        @Override
        public Long rangeValue() {
            return rangeValue;
        }

        @Override
        public RangeTypeEnum getType() {
            return type;
        }

        @Override
        public Date getDate() {
            return date;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CustomRange that = (CustomRange) o;
            return Objects.equals(rangeValue, that.rangeValue) &&
                    type == that.type;
        }

        @Override
        public int hashCode() {

            return Objects.hash(rangeValue, type);
        }
    }

    public static class CustomStatisticsObject implements StatisticsObject<IndexEnum, SimpleStatisticsTypeEnum> {

        private List<IndexEnum> index;
        private SimpleStatisticsTypeEnum statistics;
        private StatisticsObjectType statisticsObjectType;

        private CustomStatisticsObject() {

        }

        public CustomStatisticsObject(List<IndexEnum> index, SimpleStatisticsTypeEnum simpleStatisticsTypeEnum, StatisticsObjectType
                statisticsObjectType) {
            this.index = index;
            this.statistics = simpleStatisticsTypeEnum;
            this.statisticsObjectType = statisticsObjectType;
        }

        @Override
        public StatisticsObjectType getStatisticsObjectType() {
            return statisticsObjectType;
        }

        @Override
        public List<IndexEnum> getIndexs() {
            return index;
        }

        @Override
        public SimpleStatisticsTypeEnum getStatistics() {
            return statistics;
        }
    }

    public static class CustomAnalytics implements AnalyticsObject, Serializable {

        private Integer cityId;
        private Integer targetId;
        private AnalyticsObjectTypeEnum type;

        private CustomAnalytics() {

        }

        public CustomAnalytics(Integer cityId, AnalyticsObjectTypeEnum type, Integer targetId) {
            this.cityId = cityId;
            this.type = type;
            this.targetId = targetId;
        }

        public Integer getCityId() {
            return cityId;
        }

        public Integer getTargetId() {
            return targetId;
        }

        public AnalyticsObjectTypeEnum type() {
            return type;
        }

        @Override
        public String id() {

            switch (type) {
                case CITY:
                    return "city:" + cityId;
                case DISTRICT:
                    return "city:" + cityId + ",district:" + targetId;
                case PLATE:
                    return "city:" + cityId + ",plate:" + targetId;
                case HOUSE:
                    return "city:" + cityId + ",house:" + targetId;
                default:
                    return "";
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CustomAnalytics that = (CustomAnalytics) o;
            return Objects.equals(cityId, that.cityId) &&
                    Objects.equals(targetId, that.targetId) &&
                    type == that.type;
        }

        @Override
        public int hashCode() {

            return Objects.hash(cityId, targetId, type);
        }
    }

    public static class FuzzyAnalytics implements AnalyticsObject, Serializable {

        private Integer cityId;
        private AnalyticsObjectTypeEnum type;

        private FuzzyAnalytics() {

        }

        public FuzzyAnalytics(Integer cityId, AnalyticsObjectTypeEnum type) {
            this.cityId = cityId;
            this.type = type;
        }

        public Integer getCityId() {
            return cityId;
        }

        public AnalyticsObjectTypeEnum getType() {
            return type;
        }

        @Override
        public String id() {

            switch (type) {
                case CITY:
                    return "city:";
                case PLATE:
                    return "city:" + cityId + ",plate:";
                case DISTRICT:
                    return "city:" + cityId + ",district:";
                case HOUSE:
                    return "city:" + cityId + ",house:";
            }

            return "";
        }
    }

    private HistoryIndexQueryHelp() {

    }

    public static StatisticsObject statisticsObject(List<IndexEnum> index,
                                                    SimpleStatisticsTypeEnum statisticsType,
                                                    StatisticsObject.StatisticsObjectType statisticsObjectType) {

        return new CustomStatisticsObject(index, statisticsType, statisticsObjectType);

    }

    public static AnalyticsObject analytics(String id) {

        String[] s = id.split(",");
        Integer cityId = Integer.parseInt(s[0].replace("city:", ""));


        if (id.contains(",house")) {

            Integer houseId = Integer.parseInt(s[1].replace("house:", ""));
            return new CustomAnalytics(cityId, AnalyticsObjectTypeEnum.HOUSE, houseId);
        } else if (id.contains(",plate")) {

            Integer plateId = Integer.parseInt(s[1].replace("plate:", ""));
            return new CustomAnalytics(cityId, AnalyticsObjectTypeEnum.PLATE, plateId);
        } else if (id.contains(",district")) {

            Integer districtId = Integer.parseInt(s[1].replace("district:", ""));
            return new CustomAnalytics(cityId, AnalyticsObjectTypeEnum.DISTRICT, districtId);
        } else {

            return new CustomAnalytics(cityId, AnalyticsObjectTypeEnum.CITY, null);
        }


    }

    public static AnalyticsObject cityAnalytics(Integer cityId) {
        return new CustomAnalytics(cityId, AnalyticsObjectTypeEnum.CITY, null);
    }

    public static AnalyticsObject plateAnalytics(Integer cityId, Integer plateId) {
        return new CustomAnalytics(cityId, AnalyticsObjectTypeEnum.PLATE, plateId);
    }

    public static AnalyticsObject districtAnalytics(Integer cityId, Integer districtId) {
        return new CustomAnalytics(cityId, AnalyticsObjectTypeEnum.DISTRICT, districtId);
    }

    public static AnalyticsObject houseAnalytics(Integer cityId, Integer houseId) {
        return new CustomAnalytics(cityId, AnalyticsObjectTypeEnum.HOUSE, houseId);
    }

    public static AnalyticsObject fuzzyAnalytics(Integer cityId, AnalyticsObjectTypeEnum type) {
        return new FuzzyAnalytics(cityId, type);
    }

    public static Range range(Long value) {


        try {
            RangeTypeEnum type = null;
            Date date = null;
            String sValue = String.valueOf(value);
            switch (sValue.length()) {
                case 6: {
                    type = RangeTypeEnum.MONTH;
                    date = DateUtils.parse(sValue, "yyyyMM");
                }
                break;
                case 7: {
                    type = RangeTypeEnum.WEEK;
                    String concat = sValue.substring(0, 4).concat(sValue.substring(5));
                    date = DateUtils.parse(concat, "yyyyww");
                }
                break;
                case 8: {
                    type = RangeTypeEnum.DAY;
                    date = DateUtils.parse(sValue, "yyyyMMdd");
                }
                break;
                default:
                    return null;
            }
            return new CustomRange(date, type);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }


    public static Range month(Date date) {

        return new CustomRange(date, RangeTypeEnum.MONTH);
    }

    public static Range nextMonth(Date date) {

        return month(DateUtils.addMonths(date, 1));
    }

    public static Range prevMonth() {
        return prevMonth(new Date());
    }

    public static List<Range> prevMonth(int months) {
        Calendar calendar = Calendar.getInstance();
        Date end = calendar.getTime();
        calendar.add(Calendar.MONTH, -months);
        Date start = calendar.getTime();
        return month(start, end);
    }

    public static Range prevMonth(Date date) {

        return month(DateUtils.addMonths(date, -1));
    }

    public static List<Range> month(Date begin, Date end) {

        List<Range> value = Lists.newArrayList();
        while (begin.getTime() < end.getTime()) {
            value.add(month(begin));
            begin = DateUtils.addMonths(begin, 1);
        }

        value.add(month(end));
        return value;
    }

    public static Range week(Date date) {

        return new CustomRange(date, RangeTypeEnum.WEEK);
    }

    public static Range nextWeek(Date date) {

        return week(DateUtils.addWeeks(date, 1));
    }

    public static Range prevWeek(Date date) {

        return week(DateUtils.addWeeks(date, -1));
    }

    public static List<Range> week(Date begin, Date end) {

        List<Range> value = Lists.newArrayList();
        while (begin.getTime() < end.getTime()) {
            value.add(week(begin));
            begin = DateUtils.addWeeks(begin, 1);
        }

        value.add(week(end));
        return value;
    }

    public static Range day(Date date) {

        return new CustomRange(date, RangeTypeEnum.DAY);
    }

    public static Range nextDay(Date date) {

        return week(DateUtils.addDays(date, 1));
    }

    public static Range prevDay(Date date) {

        return week(DateUtils.addDays(date, -1));
    }

    public static List<Range> day(Date begin, Date end) {

        List<Range> value = Lists.newArrayList();
        while (begin.getTime() < end.getTime()) {
            value.add(week(begin));
            begin = DateUtils.addDays(begin, 1);
        }

        value.add(week(end));
        return value;
    }


    public static HistoryIndexQuery query(IndexEnum indexEnum, AnalyticsObject analyticsObject, Range range, AnalyticsSort... sorts) {

        return query(Lists.newArrayList(indexEnum), analyticsObject, range, sorts);
    }

    public static HistoryIndexQuery query(List<IndexEnum> indexEnum, AnalyticsObject analyticsObject, Range range, AnalyticsSort... sorts) {

        return query(Lists.newArrayList(indexEnum), Lists.newArrayList(analyticsObject), range, sorts);
    }

    public static HistoryIndexQuery query(List<IndexEnum> indexEnum, List<AnalyticsObject> analyticsObject, Range range, AnalyticsSort... sorts) {

        return query(Lists.newArrayList(indexEnum), Lists.newArrayList(analyticsObject), Lists.newArrayList(range), sorts);
    }

    public static HistoryIndexQuery query(List<IndexEnum> indexEnum, List<AnalyticsObject> analyticsObject, List<Range> range, AnalyticsSort...
            sorts) {

        HistoryIndexQuery query = new HistoryIndexQuery();
        query.setAnalyticsObjects(analyticsObject);
        query.setIndexes(indexEnum);
        query.setRanges(range);
        for (AnalyticsSort sort : sorts) {
            query.getAnalyticsSorts().add(sort);
        }

        return query;
    }


    public static Integer getTargetId(AnalyticsObject analyticsObject) {
        if (analyticsObject instanceof HistoryIndexQueryHelp.CustomAnalytics) {
            HistoryIndexQueryHelp.CustomAnalytics customAnalytics = (HistoryIndexQueryHelp.CustomAnalytics) analyticsObject;
            return customAnalytics.getTargetId();
        }
        return null;
    }

}
