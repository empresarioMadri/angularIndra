package com.indra.springboot.ProyectoMongoDb.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.PathVariable;

@Setter
@Getter
@Document("coches")
public class Coche {

    @Id
    private String id;

    private String marca;
    private String color;

    private String comercial;

    private String idCliente;
}
