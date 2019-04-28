package com.tooltar.controller.web;

import java.util.List;

import com.tooltar.bean.MSportBean;

public interface MSportControllerI {
	
	/***
	 * 根据用户id查询今日，本周，本月运动
	 */
	public List<MSportBean> loadTwmSportByMuid(Integer mu_id);
	
}
