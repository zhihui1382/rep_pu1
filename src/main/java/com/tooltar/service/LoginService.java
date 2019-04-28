package com.tooltar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tooltar.bean.ResultBean;
import com.tooltar.bean.UserBean;
import com.tooltar.mapper.LoginDaoI;
@Service
@Transactional
public class LoginService implements LoginServiceI {
	@Autowired
	private LoginDaoI loginDaoI;

	/**
	 * 登陆业务
	 * */
	@Override
	public ResultBean showLogin(UserBean userBean) {
		UserBean userPassWord = loginDaoI.getUserPassWord(userBean);
		ResultBean resultBean = new ResultBean();
		if(userPassWord!=null) {
			resultBean.setState(1);
			resultBean.setMessage("登陆成功");
			resultBean.setUrl("/web/common/header");
			return resultBean;
		}else {
			resultBean.setState(0);
			resultBean.setMessage("登陆失败");
			resultBean.setUrl("/web/web/login");
			return resultBean;
		}
		
//		List<UserBean> user = loginDaoI.getUser();
//		System.out.println("user:"+user);
//		
//		if(user!=null) {
//			if(user.getPassword().equals(userBean.getPassword())&&user.getUsername().equals(userBean.getUsername())) {
//				
//				return resultBean;
//			}else {
//				
//			}
//			
//		}else {
//			resultBean.setState(0);
//			resultBean.setMessage("账号没有注册");
//			resultBean.setUrl("/web/register.html");
//			return resultBean;
//		}
		
	}

}
