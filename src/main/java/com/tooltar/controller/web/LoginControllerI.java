package com.tooltar.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.tooltar.bean.ResultBean;
import com.tooltar.bean.UserBean;

public interface LoginControllerI {
	/*
	 * 跳转登陆页面
	 */
	public ModelAndView toLogin(HttpServletRequest request,HttpServletResponse response);
	/*
	 * 返回登陆结果
	 */
	public ResultBean showLogin(UserBean userBean,HttpServletRequest request);
}
