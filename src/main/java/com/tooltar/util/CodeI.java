package com.tooltar.util;

public interface CodeI {
	/*
	 * 获取短信验证码
	 * 使用阿里云短信接口，接口密钥等固定信息请使用配置文件
	 */
	public Integer getCode(String code);
}
