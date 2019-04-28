package com.tooltar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tooltar.bean.ResultBean;
import com.tooltar.bean.UserBean;
import com.tooltar.mapper.RegisterDaoI;
import com.tooltar.util.Code;
import com.tooltar.util.SecurityCode;

/**
 *	 注册操作
 * @author 赵国正
 *
 */
@Transactional
@Service
public class RegisterService implements RegisterServiceI {
	
	@Autowired
	private RegisterDaoI registerDao;
	
	public ResultBean showRegister(UserBean userBean) {
		String code = SecurityCode.getMsgCode();
		new Code().getCode(code);
		
		// 默认为失败
		Integer state = 0;
		String message = "注册失败";
		String url = null;
		try {
			// 若返回值为0则表示添加失败，不为0则表示添加成功
			int row = registerDao.insertUser(userBean);
			if(row != 0) {
				state = 1;
				message = "注册成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResultBean result = new ResultBean(state, message, url);
		return result;
	}

}
