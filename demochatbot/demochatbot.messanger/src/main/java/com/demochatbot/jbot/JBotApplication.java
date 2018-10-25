package com.demochatbot.jbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.demochatbot.jbot", "com.demochatbot.jbot"})
@EnableFeignClients
@EnableEurekaClient
public class JBotApplication {
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    } 

    /**
     * Entry point of the application. Run this method to start the sample bots,
     * but don't forget to add the correct tokens in application.properties file.
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(JBotApplication.class, args);
    }
}
