package com.mycom.myapp.common;

import org.springframework.web.servlet.HandlerInterceptor;

import com.mycom.myapp.user.dto.UserDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor >>> "+ request.getRequestURI());
        
        HttpSession session = request.getSession();
        UserDto userDto= (UserDto) session.getAttribute("userDto");
        
        if(userDto==null) {
        	System.out.println("LoginInterceptor >>>login.jsp");
        	response.sendRedirect("/pages/login");
        	return false;
        }

        
        return true; // 이어서 계속 진행, false : 더이상 진행 X
    }
}
