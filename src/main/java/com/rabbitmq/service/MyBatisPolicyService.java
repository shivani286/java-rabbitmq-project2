package com.rabbitmq.service;

import java.util.List;

import com.rabbitmq.entity.MyBatisObject;
import com.rabbitmq.request.MyBatisPolicyRequest;

public interface MyBatisPolicyService {

	List<MyBatisObject> findAllDetails();

	MyBatisObject create(MyBatisPolicyRequest myBatisPolicyRequest);

	MyBatisObject findDetailById(Integer policyId);

}
