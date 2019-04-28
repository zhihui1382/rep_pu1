package com.tooltar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tooltar.bean.MUserBean;
import com.tooltar.mapper.MUserDaoI;

@Service
public class MUserService implements MUserServiceI {

	@Autowired
	private MUserDaoI mUserDaoI;
	@Override
	public List<MUserBean> loadMUserListService() {
		return mUserDaoI.loadMUserList();
	}
	@Override
	public List<MUserBean> loadMUsersListService(MUserBean user) {
		return mUserDaoI.loadMUsersList(user);
	}

}
