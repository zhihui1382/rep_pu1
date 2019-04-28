package com.tooltar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tooltar.bean.LogBean;
import com.tooltar.util.Page;
@Repository
public interface LogDaoI {
	/*
	 * �����û�����
	 */
	public Integer insertLog(LogBean log);
	/*
	 * ��ȡ���еĵ���Ϣ
	 */
	public List<LogBean> getLog(@Param("page")Page page);
	/*
	 * ��ȡ���е�����
	 */
	public Integer getConut();
}
