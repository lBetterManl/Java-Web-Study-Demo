package com.imooc.page.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	/**
	 * У���ַ����Ƿ��Ǵ���0������
	 * @param string
	 * @return
	 */
	public static boolean isNum(String string){
		Pattern pattern = Pattern.compile("[1-9]{1}\\d*");
		Matcher matcher = pattern.matcher(string);
		return matcher.matches();
	}
}
