package com.indra.cloud.ProyectoEurekaClient.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

	@GetMapping("/")
	public String inicio() {
		return "Hola mundo";
	}

}
