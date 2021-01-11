package com.rabbitmq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Optional;
import com.google.common.base.Predicates;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket api() 
    {
        return new Docket(DocumentationType.SWAGGER_2)
    		.select()
    		.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))) 
    		.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.cloud"))) 
    		.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.data.rest.webmvc")))
            .paths(Predicates.not(PathSelectors.regex("/error")))
            .build()
            .apiInfo(apiInfo())
            .useDefaultResponseMessages(false)
	        //.securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("Bearer %token", "Authorization", "Header"))))
	        .genericModelSubstitutes(Optional.class);
    }
	
	private ApiInfo apiInfo() 
	{
		return new ApiInfoBuilder().title("Policy-Service").description("Service for Policy")
          .contact(new Contact("Developer Team", null,"thakur.shivani220@gmail.com"))
            .version("1.0.0").build();
	}
}
