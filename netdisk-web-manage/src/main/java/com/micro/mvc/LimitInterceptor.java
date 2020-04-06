package com.micro.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.common.Result;
import com.micro.disk.user.bean.SessionUserBean;
import com.micro.disk.user.service.UserService;

/**
 * app拦截器
 * @author zwy
 * 2018年10月16日
 */
@Component
public class LimitInterceptor implements HandlerInterceptor{
	@Reference(check=false)
	private UserService userService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Origin", origin);
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Headers","Origin,Content-Type,Accept,token,X-Requested-With");
		response.setHeader("Access-Control-Allow-Credentials", "true");
	
		try{
			String token="";
			token=request.getHeader("token");
			if(StringUtils.isEmpty(token)){			
				token=request.getParameter("token");
			}
			if(StringUtils.isEmpty(token)){
				throw new RuntimeException("ssofail");
			}
			SessionUserBean ui=userService.getUserByToken(token);
			if(ui==null){
				throw new RuntimeException("ssofail");
			}else{					
				request.setAttribute("userInfo",ui);
				request.setAttribute("userid",ui.getId());
				request.setAttribute("username",ui.getNickname());
			}
		}catch(Exception e){
			throw new RuntimeException("ssofail");				
		}
		return true;
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mv)
			throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}
}
