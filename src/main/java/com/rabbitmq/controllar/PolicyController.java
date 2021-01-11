package com.rabbitmq.controllar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.entity.Policy;
import com.rabbitmq.service.PolicyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("policy")
@Slf4j
@Api(tags = "Policy")

public class PolicyController {

	@Autowired
	private PolicyService policyService;
	
	
	@GetMapping("/number/{policyId}")
	@ApiOperation(value = "${PolicyController.getPolicy}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Conversion"),
            @ApiResponse(code = 401, message = "You are not authorized to send message"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	
    public Policy getPolicyById(@PathVariable Integer policyId) {
        return policyService.findPolicyById(policyId);
    }
	
}
