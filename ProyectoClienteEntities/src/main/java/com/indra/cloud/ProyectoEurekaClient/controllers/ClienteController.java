package com.indra.cloud.ProyectoEurekaClient.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indra.cloud.ProyectoEurekaClient.entities.LoginDto;
import com.indra.cloud.ProyectoEurekaClient.forms.LoginForm;
import com.indra.cloud.ProyectoEurekaClient.repositiries.UsuarioRepository;

@RestController
public class ClienteController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginForm login(@RequestBody LoginForm loginForm) {
		ModelMapper modelMapper = new ModelMapper();
		LoginDto loginDto = usuarioRepository.findByUsuarioAndClave(loginForm.getUsuario(), loginForm.getClave());
		return modelMapper.map(loginDto,LoginForm.class);
	}

}
