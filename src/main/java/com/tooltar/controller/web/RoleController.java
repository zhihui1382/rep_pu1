package com.tooltar.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tooltar.bean.ResultRoleBean;
import com.tooltar.bean.RoleBean;
import com.tooltar.bean.UserBean;
import com.tooltar.service.RoleServiceI;

/**
 * 	角色相关Controller实现类
 * @author 赵国正
 *
 */
@Controller
public class RoleController implements RoleControllerI {
	
	@Autowired
	private RoleServiceI roleServiceI;
	
	/**
	 * 	 跳转角色管理页面
	 */
	@RequestMapping("/toRole")
	public ModelAndView toRole(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("web/role");
		return model;
	}
	
	/**
	 * 	处理添加角色的请求
	 */
	@RequestMapping("/addRole")
	public Integer addRole(RoleBean role) {
		return roleServiceI.addRole(role);
	}

	/**
	 * 	处理删除角色的请求
	 */
	@RequestMapping("/delRole")
	public Integer delRole(Integer id) {
		return roleServiceI.delRole(id);
	}
	
	/***
	 * 处理给角色授权的请求
	 */
	@RequestMapping("/updRole")
	@Override
	public Integer updRole(RoleBean role) {
		return roleServiceI.updRole(role);
	}
	
	/***
	 * 处理多条件查询
	 */
	@Override
	public List<ResultRoleBean> selRole(RoleBean role, UserBean user) {
		return roleServiceI.selRole(user, role);
	}
	
	
	
}
