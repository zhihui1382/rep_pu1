package com.tooltar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tooltar.bean.MSportBean;
import com.tooltar.mapper.MSportDaoI;

@Service
public class MSportService implements MSportServiceI {
	
	@Autowired
	private MSportDaoI mSportDaoI;
	@Override
	public List<MSportBean> loadTwmSportByMuidService(Integer mu_id) {
		List<MSportBean> list=new ArrayList<>();
		MSportBean m1 = mSportDaoI.loadTodaySportByMuid(mu_id);
		MSportBean m2 = mSportDaoI.loadWeekSportByMuid(mu_id);
		MSportBean m3 = mSportDaoI.loadMonthSportByMuid(mu_id);
		list.add(m1);
		list.add(m2);
		list.add(m3);
		return list;
	}

}
