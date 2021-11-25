package com.indra.cloud.ProyectoEurekaClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProyectoEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoEurekaClientApplication.class, args);
	}

}
