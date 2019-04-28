package com.tooltar.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tooltar.bean.MUserBean;

@Repository
public interface MUserDaoI {
	
	/***
	 * 查询所有用户
	 */
	public List<MUserBean> loadMUserList(); 
	
	/***
	 * 用户多条件查询
	 */
	public List<MUserBean> loadMUsersList(MUserBean user);
	
}
