package com.lzw.seckill.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 手机号校验
 *
 * @author lzw
 * @since 2022-04-12
 */
public class ValidatorUtil {

	/**
	 * 该正则表达式随便写的
	 */
	private static final Pattern mobile_pattern = Pattern.compile("[1]([3-9])[0-9]{9}$");

	public static boolean isMobile(String mobile){
		if (StringUtils.isEmpty(mobile)){
			return false;
		}
		Matcher matcher = mobile_pattern.matcher(mobile);
		return matcher.matches();
	}

}
