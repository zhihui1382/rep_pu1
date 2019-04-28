package com.tooltar.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RoleHandleInterceptor implements HandlerInterceptor {

	 /**
	  * 在Handle执行前 执行
	  * return true 继续执行 false不继续执行
	  */

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
//		log.info("HandleInterceptor1 ...... preHandle");
//		 return true;
		return true;
	}
	 /**
	  * 在modelAndView 执行前 执行
	  */

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
//		log.info("HandleInterceptor1 ...... postHandle");
	}

	 /**
	  * 在 Handle 执行后 执行
	  */

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
