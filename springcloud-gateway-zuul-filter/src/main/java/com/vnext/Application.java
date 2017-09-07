package com.vnext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class Application {
	
	@Bean
	public PreZuulFilter preZuulFilter() {
		return new PreZuulFilter();
	}
	
	@Bean
	public AccessPasswordFilter accessPasswordFilter() {
		return new AccessPasswordFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
