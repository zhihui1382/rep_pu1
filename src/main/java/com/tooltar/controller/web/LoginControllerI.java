package com.tooltar.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.tooltar.bean.ResultBean;
import com.tooltar.bean.UserBean;

public interface LoginControllerI {
	/*
	 * ��ת��½ҳ��
	 */
	public ModelAndView toLogin(HttpServletRequest request,HttpServletResponse response);
	/*
	 * ���ص�½���
	 */
	public ResultBean showLogin(UserBean userBean,HttpServletRequest request);
}
