package com.tooltar.service;

import java.util.List;

import com.tooltar.bean.MSportBean;

public interface MSportServiceI {
	
	/***
	 * 根据用户id查询今日，本周，本月运动
	 */
	public List<MSportBean> loadTwmSportByMuidService(Integer mu_id);
	
	
}
