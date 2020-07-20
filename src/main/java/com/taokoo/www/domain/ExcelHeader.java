package com.taokoo.www.domain;

/**
 * Description:
 * <p>
 * User: Angus
 * Date: 2017-12-28
 * Time: 9:24
 * Version: 1.0
 */
@lombok.Data
public class ExcelHeader implements Comparable<ExcelHeader>{
    /**
     * excel的标题名称
     */
    private String title;
    /**
     * 每一个标题的顺序
     */
    private int order;
    /**
     * 所对应方法名称
     */
    private String methodName;

    public int compareTo(ExcelHeader o) {
        return order>o.order?1:(order<o.order?-1:0);
    }

    public ExcelHeader(String title, int order, String methodName) {
        super();
        this.title = title;
        this.order = order;
        this.methodName = methodName;
    }
}