package com.indra.springboot.ProyectoMongoDb.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;

@Setter
@Getter
public class Coche {

    private String marca;
    private String color;
}
