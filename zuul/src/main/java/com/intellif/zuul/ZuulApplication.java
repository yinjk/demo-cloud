package com.intellif.zuul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulApplication implements CommandLineRunner {

	@Value("${spring.application.name}")
	private String name;

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(name);
	}
}
