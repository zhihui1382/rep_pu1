package com.tooltar.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tooltar.bean.MSportBean;
import com.tooltar.service.MSportServiceI;

@Controller
public class MSportController implements MSportControllerI {
	
	@Autowired
	private MSportServiceI mSportServiceI;
	
	@RequestMapping("/loadTwmSportByMuid")
	@ResponseBody
	@Override
	public List<MSportBean> loadTwmSportByMuid(Integer mu_id) {
		return mSportServiceI.loadTwmSportByMuidService(mu_id);
	}

}
