package com.rabbitmq.service;

import com.rabbitmq.entity.Policy;

public interface PolicyService {

	Policy findPolicyById(Integer policyId);

}
