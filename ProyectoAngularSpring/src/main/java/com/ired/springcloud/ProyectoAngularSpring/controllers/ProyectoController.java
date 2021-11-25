package com.ired.springcloud.ProyectoAngularSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProyectoController {
	
	@GetMapping(value="/")
	public String inicio() {
		return "index";
	}
	

}
