package com.tooltar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tooltar.bean.ResultRoleBean;
import com.tooltar.bean.RoleBean;
import com.tooltar.bean.UserBean;

/**
 * 	角色相关操作Dao
 * @author 赵国正
 *
 */
@Repository
public interface RoleDaoI {
	
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
	 * 动态查询 用户信息和角色(新)
	 */
	/*public List<Map<String,Object>> selRole(@Param("user") UserBean user,@Param("role")RoleBean role);*/
	
	/***
	 * role 多条件查询
	 */
	public List<ResultRoleBean> selectUserRole(@Param("user") UserBean user,@Param("role")RoleBean role);
	
}

