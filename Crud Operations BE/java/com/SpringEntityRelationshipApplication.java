package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin()
@SpringBootApplication
public class SpringEntityRelationshipApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringEntityRelationshipApplication.class, args);
	}
   
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringEntityRelationshipApplication.class);
	}
}
