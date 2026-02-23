package com.ankit.spring_crud_implementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCrudImplementationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudImplementationApplication.class, args);
	}

}
