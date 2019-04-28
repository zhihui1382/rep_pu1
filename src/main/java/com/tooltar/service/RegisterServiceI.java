package com.tooltar.service;

import com.tooltar.bean.ResultBean;
import com.tooltar.bean.UserBean;

/**
 * 	注册操作
 * @author 赵国正
 *
 */
public interface RegisterServiceI {
	
	/**
	 * 	返回注册结果
	 * @return
	 */
	public ResultBean showRegister(UserBean userBean);
	
}
