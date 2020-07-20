package com.taokoo.www.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

/**
 * Description:
 * <p>
 * User: Angus
 * Date: 2017-12-28
 * Time: 9:58
 * Version: 1.0
 */
public class TemplateFileUtil {

    public static FileInputStream getTemplates(String tempName) throws FileNotFoundException {
        return new FileInputStream(ResourceUtils.getFile("classpath:excel-templates/"+tempName));
    }
}