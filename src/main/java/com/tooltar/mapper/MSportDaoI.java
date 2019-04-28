package com.tooltar.mapper;

import org.springframework.stereotype.Repository;

import com.tooltar.bean.MSportBean;

@Repository
public interface MSportDaoI {
	/***
	 * 根据用户id查询今日运动
	 */
	public MSportBean loadTodaySportByMuid(Integer mu_id);
	
	/***
	 * 根据用户id查询本周运动
	 */
	public MSportBean loadWeekSportByMuid(Integer mu_id);
	
	/***
	 * 根据用户id查询本月运动
	 */
	public MSportBean loadMonthSportByMuid(Integer mu_id);
	
	
}
