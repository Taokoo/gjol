package com.taokoo.www.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @ClassName: StaticConfig  
 * @Description: 自定义配置文件
 * @author Taokoo
 * @date 2020-7-29
 */
@Data
@Component
@ConfigurationProperties(prefix="sf")
@PropertySource("classpath:config/static-config.properties")
public class StaticConfig {

	private String imgpath;//头像路径
	
	private String imageserverpath;//头像URL路径
}
