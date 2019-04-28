package com.tooltar.util;

import java.util.Random;

public class SecurityCode {
	/**
	  * 随机生成的6位数，短信验证码
	  **/
	public static String getMsgCode() {
     int n = 6;
     StringBuilder code = new StringBuilder();
     Random ran = new Random();
     for (int i = 0; i < n; i++) {
         code.append(Integer.valueOf(ran.nextInt(10)).toString());
     }
     return code.toString();
	}
	/*public static void main(String[] args) {
		System.out.println(SecurityCode.getMsgCode());
		System.out.println(SecurityCode.getMsgCode());
		System.out.println(SecurityCode.getMsgCode());
		System.out.println(SecurityCode.getMsgCode());
	}*/

}
