package com.tooltar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tooltar.bean.UserBean;
@Repository
public interface LoginDaoI {
	/*
	 * 展示所有信息
	 * */
	public List<UserBean> getUser();
	/*
	 * 通过电话和密码查询信息
	 * */
	public UserBean getUserPassWord(@Param("user")UserBean user);
}
