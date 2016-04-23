package com.CAQAS.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.CAQAS.pojo.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) {
		boolean result = false;
		String url = request.getRequestURL().toString();
		System.out.println(url);
		User user = null;
		if (url.contains("login")) {
			result = true;
		} else {
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			if (user != null) {
				result = true;
			}
		}
		if (result == false) {
			try {
				response.sendRedirect("/CAQAS/login.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
