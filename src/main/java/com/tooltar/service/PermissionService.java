package com.tooltar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tooltar.bean.PermissionBean;
import com.tooltar.bean.RoleBean;
import com.tooltar.mapper.PermissionDaoI;

/**
 * 	权限相关Service
 * @author 赵国正
 *
 */
@Service
public class PermissionService implements PermissionServiceI {
	
	@Autowired
	private PermissionDaoI permissionDaoI;
	
	public List<PermissionBean> getPermission() {
		
		return permissionDaoI.getPermission();
	}

	public Integer setPermission(RoleBean roleBean) {
		
		return permissionDaoI.setPermission(roleBean);
	}
	
}
