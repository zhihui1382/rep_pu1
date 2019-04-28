package com.tooltar.controller.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tooltar.service.LogServiceI;
import com.tooltar.util.Page;
@Controller
public class LogController implements LogControllerI {
	@Autowired
	private LogServiceI logServiceI;
//	@RequestMapping(value = "manager/logout.do",method = RequestMethod.GET) 
	@RequestMapping(value = "toLog",method = RequestMethod.GET)
	public ModelAndView toLog(Page page) {
		System.err.println("webpage:"+page);
		Map<String, Object> log = logServiceI.getLog(page);
		ModelAndView model = new ModelAndView();
		model.addObject("log", log);
		model.setViewName("web/log");
		return model;
	}
	
}
