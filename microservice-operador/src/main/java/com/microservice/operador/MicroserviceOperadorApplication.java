package com.microservice.operador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroserviceOperadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOperadorApplication.class, args);
	}

}
