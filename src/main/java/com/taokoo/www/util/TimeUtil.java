package com.taokoo.www.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeUtil {
    public static LocalDateTime convertDate2LocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static Date convertLocalDateTime2Date(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date convertLocalDate2Date(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date convertString2Date(String text) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(text);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static Date convertString2Date3(String text) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(text);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
    public static Date convertString2Date2(String text) {
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss").parse(text);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
    public static Date convertString2DateD(String text) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(text);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }


    public static String convertString2DateString(Object o) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(o);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static String convertDoubledecimal(Object object) {
        try {
            return new DecimalFormat("#0.00").format(object);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static String convertOnedecimal(Object object) {
        try {
            return new DecimalFormat("#0.0").format(object);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static String convertString3DateString(Object o) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(o);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }

    }
    public static long convertDate2long(Date date) {
        LocalDateTime localDateTime = convertDate2LocalDateTime(date);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    public static String convertLocalDateTime2String(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static String convertLocalDateTime2String11(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static String convertLocalDate2String(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");

    public static String getLatestDayOfMonth(String date) {
        LocalDate localDate = LocalDate.parse(date); //本月的第一天
        LocalDate lastDay =localDate.with(TemporalAdjusters.lastDayOfMonth());
        return convertLocalDate2String(lastDay);
    }

    public static String getNextMonth(String date) {
        LocalDate localDate = LocalDate.parse(date);; //本月的第一天
        return convertLocalDate2String(localDate.plusMonths(1));
    }

    public static LocalDate convertDate2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate;
    }

    public static Date convertLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String formatDate(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        String time = df.format(date);
        return time;
    }
    /** 获取当前日期（yyyy-MM-dd）*/
    public static String getCurrentDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(new Date().getTime());
        String currentDate = format.format(date);
        return currentDate;
    }
}
