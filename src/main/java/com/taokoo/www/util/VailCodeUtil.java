package com.taokoo.www.util;
/**
 * @ClassName: VailCodeUtil  
 * @Description: 验证码工具类
 * @author Taokoo
 * @date 2020-7-20
 */
public class VailCodeUtil {
	public static Integer getVailCode() {
		String randomString = null;
		Integer random = null;
		do {
			random = (int) (Math.random() * 1000000);
			randomString = random + "";
		} while (randomString.length() < 6);

		return random;
	}
}
