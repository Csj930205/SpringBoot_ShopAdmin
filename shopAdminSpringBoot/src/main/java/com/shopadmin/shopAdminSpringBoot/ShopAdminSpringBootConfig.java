package com.shopadmin.shopAdminSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.shopadmin.shopAdminSpringBoot.interceptor.LoginInterceptor;

@Configuration
public class ShopAdminSpringBootConfig implements WebMvcConfigurer{
	@Autowired
	LoginInterceptor loginInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/")
		.excludePathPatterns("/login/login.do")
		.excludePathPatterns("/signup/signup.do");
	}


	
}
