package com.tooltar.controller.web;

import org.springframework.web.servlet.ModelAndView;

import com.tooltar.util.Page;

public interface LogControllerI {
	//跳转日志页面
	//日志内需展示的详细内容参考需求说明
	//自行定义业务层持久层接口并实现
	//说明
	//log数据库数据为id值主键，用户id，时间，操作说明（如登陆操作，改密操作）关联用户表及log表获取信息
	//需要做分页查询操作
	//每页显示15条，暂定
	
	public ModelAndView toLog(Page page);
}
