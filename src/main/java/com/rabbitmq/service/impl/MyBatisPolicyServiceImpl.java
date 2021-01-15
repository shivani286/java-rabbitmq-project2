package com.rabbitmq.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.entity.MyBatisObject;
import com.rabbitmq.exceptionHandle.DataNotFoundException;
import com.rabbitmq.myBatisMapper.PolicyMapper;
import com.rabbitmq.request.MyBatisPolicyRequest;
import com.rabbitmq.service.MyBatisPolicyService;

@Service
public class MyBatisPolicyServiceImpl implements MyBatisPolicyService {

	@Autowired
	private PolicyMapper policyMapper;

	@Override
	public List<MyBatisObject> findAllDetails() {
		return policyMapper.findAll();
	}

	@Override
	public MyBatisObject create(MyBatisPolicyRequest myBatisPolicyRequest) {

		if (Objects.nonNull(myBatisPolicyRequest)) {

			MyBatisObject myBatisObject = new MyBatisObject();
			myBatisObject.setQuotenumber(myBatisPolicyRequest.getQuotenumber());
			myBatisObject.setStatus(myBatisPolicyRequest.getStatus());
			
			policyMapper.insert(myBatisObject);
			
			return null;
		}
		throw new DataNotFoundException("Requested data is not found");
	}

	@Override
	public MyBatisObject findDetailById(Integer policyId) {

		if (Objects.isNull(policyId))
			throw new IllegalArgumentException("Policy id is null");

		return policyMapper.findPolicyById(policyId);
	}

}
