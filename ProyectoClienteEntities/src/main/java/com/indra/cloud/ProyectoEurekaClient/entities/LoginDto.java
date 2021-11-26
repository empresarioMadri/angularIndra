package com.indra.cloud.ProyectoEurekaClient.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("Usuarios")
public class LoginDto {
	
	@Id
	private String dni;
	
	private String usuario;
	
	private String clave;

}
