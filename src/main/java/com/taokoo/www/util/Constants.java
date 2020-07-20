package com.taokoo.www.util;

/**
 * 常量
 */
public class Constants {

    /**
     * 存储当前登录用户id的字段名
     */
    public static final String CURRENT_USER_ID = "currentUserId";

    /**
     * token有效期（小时）
     */
    public static final int TOKEN_EXPIRES_HOUR = 24;

    /**
     * 存放Authorization的header字段
     */
    public static final String AUTHENTICATION = "authentication";

//    public static final String IMAGE_SERVER ="C:\\Users\\Administrator\\Desktop\\";
    public static final String IMAGE_SERVER = "http://prd9.hbjk.com.cn:82/";
    public static final String IMAGE_SERVER_XT = "http://prd9.hbjk.com.cn:82/xiantao/";
    public static final String SY_IMAGE_SERVER = "http://shenyang.hbjk.com.cn:82/";
    public static final String IMAGE_PATH = "/root/projects/static/images/";
    public static final String IMAGE_PATH_XT = "/root/projects/static/images/xiantao/";

    public static final String FILE_SERVER_NT_APPLY = "http://prd9.hbjk.com.cn:83/";
    public static final String FILE_PATH_NT_APPLY = "/root/projects/static/ntapply/";

//    public static final String IMAGE_SERVER_NT_APPLY = "http://prd9.hbjk.com.cn:83/ntapply/";
    public static final String IMAGE_PATH_NT_APPLY = "/root/projects/static/ntapply/images/";

    public static final String IMAGE_PATH2 = "C:\\Users\\Administrator\\Desktop\\11\\";


    public static final String Monitor_Type_PM10  = "pm10";
    public static final String Monitor_Type_PM25  = "pm25";
    public static final String Monitor_Type_SO2   = "so2";
    public static final String Monitor_Type_NO2   = "no2";
    public static final String Monitor_Type_CO    = "co";
    public static final String Monitor_Type_O3    = "o3";
    public static final String Monitor_Type_TSP    = "tsp";
    public static final String Monitor_Type_NOISE    = "noise";
    public static final String Monitor_Type_TEMP    = "temp";
    public static final String Monitor_Type_HUMID    = "humid";
    public static final String Monitor_Type_WINDSPEED    = "windSpeed";
    public static final String Monitor_Type_WINDDIRECTION    = "windDirection";
    public static final String Monitor_Type_AIRPEESSURE    = "airPressure";
    public static final String Monitor_Type_AQI   = "aqi";
    public static final String Monitor_Type_VOC   = "voc";
    public static final String getMonitor_Type_NOISE   = "noise";

    public static final int Time_Type_Real  = 0;
    public static final int Time_Type_Hour  = 1;
    public static final int Time_Type_day   = 2;

}
