package com.indra.cloud.ProyectoEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProyectoEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoEurekaServerApplication.class, args);
	}

}
