package com.tooltar.controller.web;

import java.util.List;

import com.tooltar.bean.MUserBean;

public interface MUserControllerI {
	
	/***
	 * 处理查询所有用户的请求
	 */
	public List<MUserBean> loadMUserList(); 
	
	/***
	 * 处理用户多条件查询的请求
	 */
	public List<MUserBean> loadMUsersList(MUserBean user);
	
}
