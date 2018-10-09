package com.company.chatbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoChatBootApplication implements CommandLineRunner{
	
	private static Logger LOG = LoggerFactory.getLogger(DemoChatBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoChatBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.debug("initialized context variables");
		System.out.println("initialized context variables");
		
	}
}
