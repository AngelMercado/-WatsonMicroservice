package com.chatbot.zuulserver;





import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import com.chatboot.utils.UserContext;
import com.chatboot.utils.UserContextInterceptor;





@SpringBootApplication
@EnableZuulProxy
public class ZuulserverApplication {
	//cada que se haga referencia al bean RestTemplate referencia a este bean
	@Bean 
	public RestTemplate getRestTemplate() {
		RestTemplate template = new RestTemplate();
			List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
			
			if(interceptors==null) {
				template.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
			}else {
				interceptors.add(new UserContextInterceptor());
			}
			return template;
		
	}
	public static void main(String[] args) {
		SpringApplication.run(ZuulserverApplication.class, args);
	}
}
