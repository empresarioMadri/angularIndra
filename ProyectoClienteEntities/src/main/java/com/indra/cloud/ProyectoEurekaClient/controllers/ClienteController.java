package com.indra.cloud.ProyectoEurekaClient.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicio() {
		List<ServiceInstance> instances = discoveryClient.getInstances("HolaMundoClient");
		ServiceInstance serviceInstance = instances.get(new Random().nextInt(instances.size()));
		return "Hola mundo client1:" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"
				+ serviceInstance.getPort();
	}

}
