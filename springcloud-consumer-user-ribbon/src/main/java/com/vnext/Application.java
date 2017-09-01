package com.vnext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class Application {
	
	  @Bean
	  @LoadBalanced // 加注解，然后在controller中就可以用 http://springcloud-provide-user 来请求服务了，不需要http://localhost:8087/api/sysUsers
	  public RestTemplate restTemplate() {
	    return new RestTemplate();
	  }
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}