package com.indra.cloud.ProyectoEurekaClientFeign.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteControllerFeign {
	
	@Autowired
	private SaludoClient saludoClient;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicio() {
		return "Saludo desde el cliente Feign " + saludoClient.saludo();
	}


	@FeignClient("HolaMundoClient")
	interface SaludoClient{
		@RequestMapping(value = "/",method = RequestMethod.GET)
        String saludo();
	}

}
