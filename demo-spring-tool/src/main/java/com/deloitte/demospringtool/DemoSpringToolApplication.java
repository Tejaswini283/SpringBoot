package com.deloitte.demospringtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.deloitte.demospringtool")
public class DemoSpringToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringToolApplication.class, args);
	}
	

}
