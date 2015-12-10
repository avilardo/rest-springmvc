package br.com.globosat.spring.sample.config;

import io.swagger.model.ApiInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
//@EnableSwagger
public class SwaggerConfig {

	
//	private SpringSwaggerConfig springSwaggerConfig;
//	/**
//    * Required to autowire SpringSwaggerConfig
//    */
//	@Autowired
//	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
//		this.springSwaggerConfig = springSwaggerConfig;
//	}
//	
//	/**
//    * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc framework - allowing for multiple
//    * swagger groups i.e. same code base multiple swagger resource listings.
//    */
//	@Bean //Don't forget the @Bean annotation
//	public SwaggerSpringMvcPlugin members() {
//		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(this.apiInfo())
//																   .includePatterns(".*/.*")
//																   .swaggerGroup("external");
//	}
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("Globoast API", 
									  "Sample API for Globosat",
									  "Globosat API terms of service", 
									  "andre.vilardo@sysmi.com.br",
									  "Globosat API Licence Type", 
									  "Globosat API License URL");
		return apiInfo;
	}
}