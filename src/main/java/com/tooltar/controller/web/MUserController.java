package com.tooltar.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tooltar.bean.MUserBean;
import com.tooltar.service.MUserServiceI;

@Controller
public class MUserController implements MUserControllerI {
	
	@Autowired
	private MUserServiceI mUserServiceI;
	
	@RequestMapping("/loadMUserList")
	@ResponseBody
	@Override
	public List<MUserBean> loadMUserList() {
		return mUserServiceI.loadMUserListService();
	}
	
	@RequestMapping("/loadMUsersList")
	@Override
	public List<MUserBean> loadMUsersList(MUserBean user) {
		return mUserServiceI.loadMUsersListService(user);
	}

}
