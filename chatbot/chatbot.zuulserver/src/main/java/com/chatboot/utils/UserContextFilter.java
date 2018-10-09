package com.chatboot.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;



/**
 * This Filter storage the contextUser locally
 * El filtro es llamado antes del interceptor  
 * Este valor se almacena en UserContextHolder
 * @author Angel Mercado Ponce
 *
 */


@Component
public class UserContextFilter implements Filter{
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserContextFilter.class);

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) arg0;	
		 
		UserContextHolder.getContext().setCorrelationId(httpServletRequest.getHeader(UserContext.CORRELATION_ID));
		UserContextHolder.getContext().setUserId(httpServletRequest.getHeader(UserContext.USER_ID));
		UserContextHolder.getContext().setAuthToken(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
		
		LOGGER.debug("UserContextFilter Correlationid:{}",UserContextHolder.getContext().getUserId());
		
		arg2.doFilter(httpServletRequest, arg1);
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
