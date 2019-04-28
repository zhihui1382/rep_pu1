package com.tooltar.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.tooltar.bean.ResultRoleBean;
import com.tooltar.bean.RoleBean;
import com.tooltar.bean.UserBean;

public interface RoleControllerI {
	//跳转角色管理页面
	public ModelAndView toRole(HttpServletRequest request, HttpServletResponse response);
	//添加角色
	//功能及数据库说明
	//添加角色，并为本角色设置权限
	//首先定义权限表（id主键，message 描述）
	//添加角色时会在页面显示权限表所有信息，多选框由用户选择
	//定义角色表两种选择
	//一：（id主键，~~~此处根据权限表数据量定义字段，对不同字段赋值0or1，0无权限，1有权限）
	//二：（id主键，权限（此字段通过,逗号分隔权限表id，所有包含的id皆为有权限操作））
	public Integer addRole(RoleBean role);
	//删除角色
	public Integer delRole(Integer id);
	
	//其他的一些功能和注意事项
	/*
	 * 定义一个拦截器，暂时为拦截所有请求，具体实现不写直接允许通过即可，以便后续使用
	 * 
	 * 所有功能用junit测试并保留测试代码
	 * 
	 * 不用去实现页面切记，
	 * 
	 * log and role 控制器接口已经对功能进行初步说明，参考需求文档完成功能（有不理解的联系我）
	 * 
	 * 登陆注册修改密码获取验证码等未完成功能优先做，加油~
	 */
	
	//处理给角色授权的请求
	public Integer updRole(RoleBean role);
	
	//处理多条件查询
	public List<ResultRoleBean> selRole(RoleBean role,UserBean user);
		
}
