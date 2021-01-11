package com.rabbitmq.service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface MessageQueueService {
	
	public void consumeMessage() throws IOException, TimeoutException ;
	public void sendMessage(String message) throws IOException, TimeoutException ;
}
