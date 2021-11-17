package com.indra.springboot.ProyectoHolaMundo.controllers;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CocheForm {
    @NotNull
    @Size(min = 2,max = 30)
    private String marca;
    private String color;
    private Long comercial;
    private Date fecha;
}
