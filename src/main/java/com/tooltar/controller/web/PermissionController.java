package com.tooltar.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tooltar.bean.PermissionBean;
import com.tooltar.bean.RoleBean;
import com.tooltar.service.PermissionServiceI;

/**
 * 	角色相关Controller实现类
 * @author 赵国正
 *
 */
@Controller
public class PermissionController implements PermissionControllerI {
	
	@Autowired
	private PermissionServiceI permissionServiceI;
	
	/**
	 * 	 跳转权限管理页面
	 */
	@RequestMapping("/toPermission")
	public ModelAndView toPermission(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("web/role");
		return model;
	}
	
	/**
	 * 	查询所有权限
	 */
	@RequestMapping("/getPermission")
	public List<PermissionBean> getPermission() {
		
		return permissionServiceI.getPermission();
	}
	
	/**
	 * 	修改指定id用户的权限
	 */
	@RequestMapping("/setPermission")
	public Integer setPermission(RoleBean roleBean) {
		
		return permissionServiceI.setPermission(roleBean);
	}

}
