package com.tooltar.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.tooltar.bean.ResultBean;
import com.tooltar.bean.UserBean;

/**
 *	 本类为注册操作接口
 * @author 赵国正
 *
 */
public interface RegisterControllerI {
	/**
	 * 跳转到注册页面
	 * @param request request
	 * @param response response
	 * @return ModelAndView
	 */
	public ModelAndView toRegister(HttpServletRequest request,HttpServletResponse response);
	
	/**
	 * 注册用户
	 * @return 注册的结果
	 */
	public ResultBean showRegister(UserBean userBean);
}
