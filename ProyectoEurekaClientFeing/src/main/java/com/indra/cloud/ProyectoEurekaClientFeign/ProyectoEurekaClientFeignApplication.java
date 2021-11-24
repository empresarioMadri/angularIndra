package com.indra.cloud.ProyectoEurekaClientFeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProyectoEurekaClientFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoEurekaClientFeignApplication.class, args);
	}

}
