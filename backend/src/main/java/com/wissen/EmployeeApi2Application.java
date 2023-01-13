package com.wissen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class EmployeeApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApi2Application.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/**"))
				.apis(RequestHandlerSelectors.basePackage("com.wissen"))
				.build()
				.apiInfo(new ApiInfo(
						"Wissen Technology",
						"Employee Details",
						"1.0",
						"Licence as per Wissen Technology",
						new Contact("Wissen Technology", "https://www.wissen.com/", "test@wissen.com"),
						"API Licence",
						"https://www.wissen.com/privacy-policy-2/"
				));
	}
}
