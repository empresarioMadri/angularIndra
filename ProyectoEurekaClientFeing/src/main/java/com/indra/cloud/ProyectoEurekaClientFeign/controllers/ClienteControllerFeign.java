package com.indra.cloud.ProyectoEurekaClientFeign.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteControllerFeign {

	@Autowired
	private SaludoClient saludoClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicio() {
		List<ServiceInstance> instances = discoveryClient.getInstances("HolaMundoClient");
		ServiceInstance serviceInstance = instances.get(new Random().nextInt(instances.size()));
		return "Saludo desde el cliente Feign " + saludoClient.saludo() + serviceInstance.getServiceId() + ":"
				+ serviceInstance.getHost() + ":" + serviceInstance.getPort();
	}

	@FeignClient("HolaMundoClient")
	interface SaludoClient {
		@RequestMapping(value = "/", method = RequestMethod.GET)
		String saludo();
	}

}
