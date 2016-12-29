package com.avasojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PAvasojoApplication {

	public static void main(String[] args) {
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(AvasojoConfig.class);
//
//		AvasojoError helloWorld = ctx.getBean(AvasojoError.class);
//
//		helloWorld.setMessage("Hello World!");
//		helloWorld.getMessage();

		SpringApplication.run(PAvasojoApplication.class, args);
	}

}
