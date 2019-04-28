package com.tooltar.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.tooltar.bean.PermissionBean;
import com.tooltar.bean.RoleBean;

public interface PermissionControllerI {
	
	// 跳转权限管理页面
	public ModelAndView toPermission(HttpServletRequest request, HttpServletResponse response);
	
	// 查询所有权限
	public List<PermissionBean> getPermission();
	
	// 修改指定id用户的权限
	public Integer setPermission(RoleBean roleBean);

}
