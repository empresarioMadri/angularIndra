package com.indra.springboot.ProyectoMongoDb.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

@Setter
@Getter
@Document("coches")
public class Coche implements Serializable {

    @Id
    private String id;

    private String marca;
    private String color;

    private Long comercial;

    private String idCliente;
}
