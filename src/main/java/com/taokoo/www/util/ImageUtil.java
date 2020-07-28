package com.taokoo.www.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

public class ImageUtil {
	
	public final static Base64.Decoder decoder = Base64.getDecoder();
	
	public final static LocalDate localDate = LocalDate.now();
	
	@Value("${imgPath}")//头像保存的本地路径
	private static String imgPath;
	
	@Value("${imageServerPath}")//头像的url路径
	private static String imageServerPath;

	/**
	 * 将头像保存到图片服务器
	 * @Title: saveHeadPortrait  
	 * @param headPortrait
	 * @return 头像URL
	 * @author Taokoo
	 */
	public static String saveHeadPortrait(String headPortrait,Integer userId) {
		try {
			String dataPrix = ""; // base64格式前头
			String data = "";// 实体部分数据
			if (headPortrait == null || "".equals(headPortrait)) {
			} else {
				String[] d = headPortrait.split("base64,");// 将字符串分成数组
				if (d != null && d.length == 2) {
					dataPrix = d[0];
					data = d[1];
				} else {
				}
			}
			String suffix = "";// 图片后缀，用以识别哪种格式数据
			if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {
				suffix = ".jpg";
			} else if ("data:image/jpg;".equalsIgnoreCase(dataPrix)) {
				suffix = ".jpg";
			} else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {
				suffix = ".ico";
			} else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {
				suffix = ".gif";
			} else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {
				suffix = ".png";
			} else {
			}
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			String date = localDate.plusYears(0).toString();//当前日期，年-月-日
			String tempFileName = userId+"-"+date+"-"+uuid+suffix;
			String imgFilePath = imgPath + tempFileName;// 新生成的图片
			byte[] b = decoder.decode(data);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					// 调整异常数据
					b[i] += 256;
				}
			}
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			System.out.println("图片保存路径为：" + imgFilePath);
			return imageServerPath+imgFilePath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) {
		String s = localDate.plusYears(0).toString();
		System.out.println(s);
	}
}
