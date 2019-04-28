package com.tooltar.service;

import java.util.List;

import com.tooltar.bean.ResultRoleBean;
import com.tooltar.bean.RoleBean;
import com.tooltar.bean.UserBean;

/**
 * 	角色相关操作Service接口
 * @author 赵国正
 *
 */
public interface RoleServiceI {
	
	/**
	 * 	添加角色
	 * @param role 添加的角色信息
	 * @return 0表示添加失败，否则为成功
	 */
	public Integer addRole(RoleBean role);
	
	/**
	 * 	删除角色
	 * @param id 要删除的角色id
	 * @return 0表示删除失败，否则为成功
	 */
	public Integer delRole(Integer id);
	
	/***
	 * 给角色授权，修改角色信息
	 */
	public Integer updRole(RoleBean role);
	
	/***
	 * 动态查询 用户信息和角色
	 */
	public List<ResultRoleBean> selRole(UserBean user,RoleBean role);
	
	
}
