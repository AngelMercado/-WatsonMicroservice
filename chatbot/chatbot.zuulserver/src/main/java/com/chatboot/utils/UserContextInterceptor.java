package com.chatboot.utils;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;


/**
 * This Filter intercepts all call rest 
 * @author root
 *
 */
public class UserContextInterceptor implements ClientHttpRequestInterceptor{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserContextInterceptor.class); 
	/**
	 * Intercept the request add cutomme header  to request and call next iterceptor
	 */
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		HttpHeaders headers = request.getHeaders();
		headers.add(UserContext.CORRELATION_ID, UserContextHolder.getContext().getCorrelationId());
		headers.add(UserContext.AUTH_TOKEN, UserContextHolder.getContext().getAuthToken());
		
		return execution.execute(request, body);
	}

}
