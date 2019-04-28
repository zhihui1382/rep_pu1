package com.tooltar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tooltar.bean.LogBean;
import com.tooltar.util.Page;
@Repository
public interface LogDaoI {
	/*
	 * 储存用户操作
	 */
	public Integer insertLog(LogBean log);
	/*
	 * 获取所有的的信息
	 */
	public List<LogBean> getLog(@Param("page")Page page);
	/*
	 * 获取所有的数量
	 */
	public Integer getConut();
}
