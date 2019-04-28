package com.tooltar.mapper;

import org.springframework.stereotype.Repository;

import com.tooltar.bean.UserBean;

/**
 * 	注册操作
 * @author 赵国正
 *
 */
@Repository
public interface RegisterDaoI {

	/**
	 * 注册用户
	 * 
	 * @param userBean 用户信息
	 * @return 返回值大于0则代表注册成功
	 */
	public Integer insertUser(UserBean userBean);

}
