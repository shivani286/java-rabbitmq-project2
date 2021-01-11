package com.rabbitmq;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabbitmq.entity.Policy;
import com.rabbitmq.exceptionHandle.DataNotFoundException;
import com.rabbitmq.repository.PolicyDao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class PolictRepositaryTestCase {
	@Autowired
	private PolicyDao policyDao;
	
	
	@Test
    public void retrievePolicyDetailByDao()
    {	
		    // when
		Policy policydemo = policyDao.findPolicyByPolicyId(1);

		    // then
		    assertThat(policydemo.getPolicyId()).isEqualTo(1);
		    assertThat(policydemo.getPolicytype()).isEqualTo("abc");
			assertThat(policydemo.getQuotenumber()).isEqualTo("1234erd");
			assertThat(policydemo.getStatus()).isEqualTo("def");

    }
	
	@Test
    public void throwsExceptionWhenObjectDataNotFound() {
        try {
        	policyDao.findPolicyByPolicyId(2);
            fail("Should throw an exception if object not found");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(DataNotFoundException.class)
                    .hasMessage("Data is not found");
        }
    }
}
