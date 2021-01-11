package com.rabbitmq.exceptionHandle;

import java.io.Serializable;

public class DataNotFoundException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 8184716102234482923L;

	private String resourceId;

    public DataNotFoundException(String message, String resourceId) {
        super(String.format("%s%s", message, resourceId));
    }

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DataNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
