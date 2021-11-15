package com.indra.springboot.ProyectoHolaMundo.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class CocheForm {
    @NotNull
    @Size(min = 2,max = 30)
    private String marca;
    private String color;
}
