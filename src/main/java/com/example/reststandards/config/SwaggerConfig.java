package com.example.reststandards.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author abhishek
 *
 */
@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
			log.info("swagger initialized");
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.reststandards")).paths(PathSelectors.any())
				.build();

	}
}
