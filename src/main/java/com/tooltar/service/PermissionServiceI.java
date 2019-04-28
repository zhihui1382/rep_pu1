package com.tooltar.service;

import java.util.List;

import com.tooltar.bean.PermissionBean;
import com.tooltar.bean.RoleBean;

/**
 * 	权限相关Service
 * @author 赵国正
 *
 */
public interface PermissionServiceI {
	
	/**
	 * 	查询所有权限信息
	 * @return 所有权限的集合
	 */
	public List<PermissionBean> getPermission();
	
	/**
	 * 	修改角色的权限
	 * @param roleBean 修改之后的角色信息 包含角色的id 和修改之后的权限id
	 * @return
	 */
	public Integer setPermission(RoleBean roleBean);
	
}
