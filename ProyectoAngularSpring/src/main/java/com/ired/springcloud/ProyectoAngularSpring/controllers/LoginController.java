package com.ired.springcloud.ProyectoAngularSpring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ired.springcloud.ProyectoAngularSpring.forms.LoginForm;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class LoginController {
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginForm loginForm){
		return new ResponseEntity<String>("Login correcto",HttpStatus.OK);
	}

}
