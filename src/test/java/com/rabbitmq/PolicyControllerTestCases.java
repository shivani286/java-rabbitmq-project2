package com.rabbitmq;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.rabbitmq.controllar.PolicyController;
import com.rabbitmq.entity.Policy;
import com.rabbitmq.exceptionHandle.DataNotFoundException;
import com.rabbitmq.repository.PolicyDao;
import com.rabbitmq.service.PolicyService;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@WebMvcTest(PolicyController.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class PolicyControllerTestCases {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PolicyService service;
	
	@Autowired
	private PolicyDao policyDao;

	@Test
	public void policyShouldReturnMessageFromService() throws Exception {
		
		Policy policy = new Policy(1,"number","type","stutus");
		 

		when(service.findPolicyById(1)).thenReturn(policy);
		this.mockMvc.perform(get("/policy/number/1")).andDo(print())
					.andExpect(status().isOk())
        				.andExpect(jsonPath("policytype", is(policy.getPolicytype())))
        					.andExpect(jsonPath("quotenumber", is(policy.getQuotenumber())))
        		               .andExpect(jsonPath("status", is(policy.getStatus())));
	}
	
	@Test
	public void retrievePolicyDetail() throws Exception {

		Policy policy = new Policy();
		policy.setPolicyId(1);
		policy.setPolicytype("type");
		policy.setQuotenumber("number");
		policy.setStatus("status");
		
		assertEquals("type", policy.getPolicytype());
		assertEquals("number", policy.getQuotenumber());
		assertEquals("status", policy.getStatus());

	}
	
	
}
