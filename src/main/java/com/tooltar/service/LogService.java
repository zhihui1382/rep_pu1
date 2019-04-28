package com.tooltar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tooltar.bean.LogBean;
import com.tooltar.mapper.LogDaoI;
import com.tooltar.util.Page;

@Service
@Transactional
public class LogService implements LogServiceI {

	@Autowired
	private LogDaoI logDaoI;
	/*
	 *日志添加操作 
	 *
	 */
	public void insertLog(LogBean log) {
		// TODO Auto-generated method stub
		logDaoI.insertLog(log);
	}
	/*
	 * 
	 * 分页信息
	 * */
	@Override
	public Map<String, Object> getLog(Page page) {
//		获取总数
        Integer total = logDaoI.getConut();
//      获取分页的所有信息
        List<LogBean> st = logDaoI.getLog(page);
//      将总数和返回的集合数据封装到Map集合中
        Map<String, Object> date = new HashMap<>();
        date.put("total", total);
        date.put("rows", st);
        System.out.println("date:"+date);
		return date;
	}

}
