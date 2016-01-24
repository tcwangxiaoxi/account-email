package com.juvenxu.mvnbook.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@EnableConfigurationProperties(PropertyPlaceholderAutoConfiguration.class)
@ComponentScan
// @EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		// 第一个简单的应用，
		SpringApplication.run(Application.class, args);
	}

}
