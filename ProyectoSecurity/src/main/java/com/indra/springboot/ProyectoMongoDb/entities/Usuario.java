package com.indra.springboot.ProyectoMongoDb.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("usuarios")
@Setter
@Getter
public class Usuario {

    @Id
    private String id;

    private String login;

    private String clave;

    private List<Rol> roles;

}
