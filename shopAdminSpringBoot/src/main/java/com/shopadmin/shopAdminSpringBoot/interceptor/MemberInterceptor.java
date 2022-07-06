package com.shopadmin.shopAdminSpringBoot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shopadmin.shopAdminSpringBoot.vo.MemberVo;

@Configuration
public class MemberInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		Object MemObj=session.getAttribute("memVo");
		if(MemObj!=null && ((MemberVo)MemObj).getGrade()<2) {
			return true;
		}else {
			session.setAttribute("msg", "해당 페이지에 대한 접근 권한이 없습니다.");
			response.sendRedirect("/");
			return false;
		}
	}

}
