package com.springboot.micro.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootMicroWebApplication implements CommandLineRunner{

	private static final Logger LOGGER = LoggerFactory.
							getLogger(SpringBootMicroWebApplication.class);

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanName :beanDefinitionNames) {
			System.out.println(beanName);
		}
	}
}
