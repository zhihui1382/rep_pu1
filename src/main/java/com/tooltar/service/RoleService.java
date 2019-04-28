package com.tooltar.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tooltar.bean.ResultRoleBean;
import com.tooltar.bean.RoleBean;
import com.tooltar.bean.UserBean;
import com.tooltar.mapper.PermissionDaoI;
import com.tooltar.mapper.RoleDaoI;

/**
 * 	角色相关操作Service实现类
 * @author 赵国正
 *
 */
@Transactional
@Service
public class RoleService implements RoleServiceI {
	
	@Autowired
	private PermissionDaoI permissionDaoIdao;
	@Autowired
	private RoleDaoI roleDaoI;
	
	public Integer addRole(RoleBean role) {
		return roleDaoI.addRole(role);
	}

	public Integer delRole(Integer id) {
		return roleDaoI.delRole(id);
	}
	
	@Override
	public Integer updRole(RoleBean role) {
		return roleDaoI.updRole(role);
	}

	@Override
	public List<ResultRoleBean> selRole(UserBean user, RoleBean role) {
		List<ResultRoleBean> list = roleDaoI.selectUserRole(user, role);
		for (ResultRoleBean rrb : list) {
			String str1 = rrb.getAuthority();
			String[] str2 = str1.split(",");
			StringBuffer sb=new StringBuffer();
			for(String str3:str2){
				Integer pid = Integer.valueOf(str3);
				String perDesc = permissionDaoIdao.getPerDesc(pid);
				sb.append(perDesc+",");
			}
			String str4=sb.substring(0, sb.length()-1);
			rrb.setAuthority(str4);
		}
		
		return list;
	}

}
