package com.tooltar.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tooltar.bean.ResultBean;
import com.tooltar.bean.UserBean;
import com.tooltar.service.LoginServiceI;
@Controller
public class LoginController implements LoginControllerI{
	@Autowired
	private LoginServiceI loginServiceI;
	
	@RequestMapping("toLogin")
	public ModelAndView toLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("web/login");
		return model;
	}
	@RequestMapping("/showLogin")
	@ResponseBody
	public ResultBean showLogin(UserBean userBean,HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("userBean:"+userBean);
		ResultBean showLogin = loginServiceI.showLogin(userBean);
		session.setAttribute("showLogin", showLogin);
		return showLogin;
	}
}
