package com.ired.springcloud.ProyectoAngularSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProyectoAngularSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoAngularSpringApplication.class, args);
	}

}
