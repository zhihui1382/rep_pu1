package com.tooltar.service;

import java.util.List;

import com.tooltar.bean.MUserBean;

public interface MUserServiceI {
	
	/***
	 * 查询所有用户
	 */
	public List<MUserBean> loadMUserListService(); 
	
	/***
	 * 用户多条件查询
	 */
	public List<MUserBean> loadMUsersListService(MUserBean user);
	
	
}
