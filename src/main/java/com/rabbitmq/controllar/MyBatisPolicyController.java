package com.rabbitmq.controllar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.entity.MyBatisObject;
import com.rabbitmq.request.MyBatisPolicyRequest;
import com.rabbitmq.service.MyBatisPolicyService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("policy/v1")
@Slf4j
@Api(tags = "MyBatus-Policy")
public class MyBatisPolicyController {

	@Autowired
	private MyBatisPolicyService myBatisPolicyService;
	
	@GetMapping("/all")
    public List<MyBatisObject> getAllDetails() {
        return myBatisPolicyService.findAllDetails();
    }
	
	@GetMapping("/{id}")
    public MyBatisObject getDetail(@PathVariable Integer policyId) {
        return myBatisPolicyService.findDetailById(policyId);
    }

    @PostMapping("/create")
    private MyBatisObject create(@RequestBody MyBatisPolicyRequest myBatisPolicyRequest) {
        return  myBatisPolicyService.create(myBatisPolicyRequest);
    }
}
