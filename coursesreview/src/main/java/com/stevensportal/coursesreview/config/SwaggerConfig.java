package com.stevensportal.coursesreview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author staneja14
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.stevensportal.coursesreview"))
				.paths(PathSelectors.any()).build().apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("StevensPortal-Server")
				.description("CoursesReview Project APIs")
				.version("1.0")
				.termsOfServiceUrl("Free to use")
				.license("API License")
				.licenseUrl("https://www.stevens.edu/")
				.contact(new Contact("Shivani Taneja", "https://www.stevens.edu/", "staneja1@stevens.edu"))
				.build();
	}
}
