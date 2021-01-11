package com.rabbitmq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rabbitmq.entity.Policy;

@Repository
public interface PolicyDao extends JpaRepository<Policy, Integer> {

	Policy findPolicyByPolicyId(Integer policyId);

}
