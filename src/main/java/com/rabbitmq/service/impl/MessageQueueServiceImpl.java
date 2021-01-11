package com.rabbitmq.service.impl;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.service.MessageQueueService;

public class MessageQueueServiceImpl implements MessageQueueService {

	@Autowired
	private ConnectionFactory connectionFactory;

	private final static String QUEUE_NAME = "demo-queue";
	@Value("${rabbitmq.host}")
	 private String rabbitmqHost;

	@Override
	public void sendMessage(String message) throws IOException, TimeoutException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost(rabbitmqHost);
		
		try ( Connection connection = connectionFactory.newConnection();
				 Channel channel = connection.createChannel()) {

			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			System.out.println("Sending the following message to the queue: " + message);
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));

		}
	}

	@Override
	public void consumeMessage() throws IOException, TimeoutException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost(rabbitmqHost);
		
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();

		 channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		System.out.println("Waiting for messages from the queue. To exit press CTRL+C");

		final DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			final String message = new String(delivery.getBody(), "UTF-8");
			System.out.println("Received from message from the queue: " + message);
			
			addMethod(message);
		};

		channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
		});
	}

	private void addMethod(String message) {

		for (int i = 0; i < 5; i++) {
			
			System.out.println("Message Number "+ i +" recived message is : "+message);
		}
	}

}
