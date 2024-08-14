package com.mycom.myapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mycom.myapp.common.LoginInterceptor;



public class WebMvcConfig implements WebMvcConfigurer{
    @Autowired
    private LoginInterceptor loginInterceptor;
    
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
        		.excludePathPatterns(
        				"/",
        				"/index.html",
        				"/pages/login",
        				"/pages/user"
        				);
    }
    

}

//http://localhost:8080/
// http://localhost:8080/pages/user