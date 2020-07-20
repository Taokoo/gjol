package com.taokoo.www;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Description: 用来在对象的get方法上加入的annotation，通过该annotation说明某个属性所对应的标题
 * <p>
 * User: Angus
 * Date: 2017-12-28
 * Time: 9:48
 * Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelResources {
    /**
     * 属性的标题名称
     * @return
     */
    String title();

    /**
     * 在excel的顺序
     * @return
     */
    int order() default 9999;
}