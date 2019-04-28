package com.tooltar.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tooltar.bean.ResultBean;
import com.tooltar.bean.UserBean;
import com.tooltar.service.RegisterServiceI;
/**
 *	  注册操作
 * @author 赵国正
 *
 */
@Controller
public class RegisterController implements RegisterControllerI {
	
	@Autowired
	private RegisterServiceI registerServiceI;
	
	/**
	 * 	跳转注册页面
	 */
	@RequestMapping("/toRegister")
	public ModelAndView toRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("web/register");
		return model;
	}
	
	/**
	 * 	返回注册结果
	 */
	@RequestMapping("/register")
	public ResultBean showRegister(UserBean userBean) {
		ResultBean result = registerServiceI.showRegister(userBean);
		return result;
	}

}
