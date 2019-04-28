package com.tooltar.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tooltar.bean.PermissionBean;
import com.tooltar.bean.RoleBean;

/**
 * 	权限相关操作Dao
 * @author 赵国正
 *
 */
@Repository
public interface PermissionDaoI {
	
	/**
	 * 	查询所有权限
	 * @return 所有权限的集合
	 */
	public List<PermissionBean> getPermission();
	
	/**
	 * 	修改角色的权限
	 * @param roleBean 修改之后的角色信息， 包含角色的id 和角色修改之后的权限
	 * @return
	 */
	public Integer setPermission(RoleBean roleBean);
	
	/***
	 * 根据权限id查看描述
	 * @param id
	 * @return
	 */
	public String getPerDesc(Integer id);
	
}
