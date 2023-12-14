package com.eukolos.userrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRestApiApplication.class, args);
	}

}
