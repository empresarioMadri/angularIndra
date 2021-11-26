package com.ired.springcloud.ProyectoAngularSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
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
	
	@Autowired
	private ClienteEntities clienteEntities;
	
	@PostMapping("/login")
	public ResponseEntity<LoginForm> login(@RequestBody LoginForm loginForm){
		LoginForm loginForm2 = clienteEntities.login(loginForm);
		return new ResponseEntity<LoginForm>(loginForm2,HttpStatus.OK);
	}
	
	@FeignClient("ClienteEntities")
	interface ClienteEntities{
		public LoginForm login(@RequestBody LoginForm loginForm);
	}

}
