package com.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.rabbitmq.service.impl.MessageQueueServiceImpl;

@SpringBootApplication

public class RabbitMQApplication extends SpringBootServletInitializer{

	public static void main(String[] args) throws IOException, TimeoutException {
		
		SpringApplication.run(RabbitMQApplication.class, args);
		MessageQueueServiceImpl MessageQueueService = new MessageQueueServiceImpl();
		
		for (int i = 0; i < 5; i++) {
			String message ="Hello rabbitmq";
			MessageQueueService.sendMessage(message);
			System.out.println("Message Number "+ i +" sent.");
		}
		
		MessageQueueService.consumeMessage();
	}



}
