package com.cafe24.jblog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.jblog.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		//1. handler 종류 확인
		
		if(handler instanceof HandlerMethod == false) {
			return true;
		}
		
		//2. casting
		HandlerMethod handlerMethod = (HandlerMethod) handler; //어노테이션 정보 꺼낼려고

		//3. @Auth 받아오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		// auth.role();
		
		//4. Method에 @Auth가 없는 경우
		if(auth == null) {
			return true;
		}
		
		//5. @Auth가 붙어 있는 경우, 인증여부 체크
		HttpSession session = request.getSession();
		if(session == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if(authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		return true;
	}
	
}
