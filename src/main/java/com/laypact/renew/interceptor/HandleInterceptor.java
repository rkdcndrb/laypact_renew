package com.laypact.renew.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.laypact.renew.component.SessionManager;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class HandleInterceptor implements HandlerInterceptor{
	
	@Resource
	private SessionManager sessionManager;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getRequestURI().contains("/admin")) {
			
			if("/admin".equals(request.getRequestURI()) || "/admin/".equals(request.getRequestURI())) {
				
				response.sendRedirect("/admin/login");
				return false;
			} 
//			else if(sessionManager == null || sessionManager.getId() == null || "".equals(sessionManager.getId())) {
//				if("XMLHttpRequest".equals(request.getHeader("x-requested-with"))) {
//					response.sendError(401);
//				} else {
//					response.sendRedirect("/admin/login");
//				}
//				
//				return false;
//			}
		} else if("/".equals(request.getRequestURI())) {
			
			response.sendRedirect("/index");
			return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}