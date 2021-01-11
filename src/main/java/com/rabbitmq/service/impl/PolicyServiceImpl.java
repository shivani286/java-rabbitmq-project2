package com.rabbitmq.service.impl;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.entity.Policy;
import com.rabbitmq.exceptionHandle.DataNotFoundException;
import com.rabbitmq.repository.PolicyDao;
import com.rabbitmq.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {

    public static final Logger logger = LoggerFactory.getLogger(PolicyServiceImpl.class);
    
	@Autowired
	private PolicyDao policyDao;
	
	@Override
	public Policy findPolicyById(Integer policyId) {
		
		if(Objects.isNull(policyId))
			throw new IllegalArgumentException("Policy id is null");
		System.out.println("step1"+policyId);

		Policy policy = policyDao.findPolicyByPolicyId(policyId);
		System.out.println("step2"+policy);
		if(Objects.nonNull(policy))
			return policy;
		else 
			throw new DataNotFoundException("Data is not found");
		
		
	}

}
