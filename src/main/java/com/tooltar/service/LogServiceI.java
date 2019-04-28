package com.tooltar.service;

import java.util.Map;

import com.tooltar.bean.LogBean;
import com.tooltar.util.Page;

public interface LogServiceI {
	public void insertLog(LogBean log);

	public Map<String, Object> getLog(Page page);
}
