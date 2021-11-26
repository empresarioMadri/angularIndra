package com.indra.cloud.ProyectoEurekaClient.repositiries;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.indra.cloud.ProyectoEurekaClient.entities.LoginDto;

public interface UsuarioRepository extends MongoRepository<LoginDto, String>{
	
	public LoginDto findByUsuarioAndClave(String usuario,String clave);

}
