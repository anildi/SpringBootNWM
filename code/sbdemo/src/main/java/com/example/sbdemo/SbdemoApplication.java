package com.example.sbdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SbdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SbdemoApplication.class, args);

		int count = context.getBeanDefinitionCount();
		System.out.println("Num Beans: " + count);
	}
}

@Component
class MyRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello from MyRunner");
	}
}


