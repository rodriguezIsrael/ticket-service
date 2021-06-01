package com.sample.ticket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Israel I. R. E.
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String BASE_PACKAGE = "com.sample.ticket.controller";
	private static final String PROJECT_NAME = "Tickets";
	private static final String PROJECT_DESCRIPTION = "Consulta y guardado de tickets";
	private static final String VERSION = "1.0.0";

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).select()

				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE)).paths(PathSelectors.regex("/.*")).build()
				.apiInfo(apiEndPointsInfo());

	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title(PROJECT_NAME).description(PROJECT_DESCRIPTION).version(VERSION).build();

	}
}
