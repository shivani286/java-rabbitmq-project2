package com.rabbitmq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class RabbitConfig {
	 
	
	@Value("${rabbitmq.host}")
	 private String rabbitmqHost;
	 @Value("${rabbitmq.username}")
	 private String rabbitmqUserName;
	 @Value("${rabbitmq.password}")
	 private String rabbitmqPassword;
	 @Value("${rabbitmq.port}")
	 private int rabbitmqPort;
	 
	 
	/*@Bean
	public ConnectionFactory connectionFactory() {
		return new ConnectionFactory();
	}*/
	
	@Bean
	public ConnectionFactory connectionFactory() {
	    ConnectionFactory connectionFactory = new ConnectionFactory();
	    connectionFactory.setConnectionTimeout(10);
	    connectionFactory.setHost(rabbitmqHost);
	    connectionFactory.setPort(rabbitmqPort);
	    connectionFactory.setUsername(rabbitmqUserName);
	    connectionFactory.setPassword(rabbitmqPassword);
	    connectionFactory.setVirtualHost("/");
	    return connectionFactory;
	  }
	
}
