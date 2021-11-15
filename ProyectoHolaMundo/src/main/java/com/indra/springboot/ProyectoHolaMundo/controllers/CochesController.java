package com.indra.springboot.ProyectoHolaMundo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class CochesController {

    @RequestMapping("/")
    public String hola(Model modelo){
        CocheForm coche = new CocheForm("seat","rojo");
        modelo.addAttribute("coche",coche);
        return "hola";
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("coche") @Valid CocheForm coche, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.info("Error agregando el coche " + coche );
        }
        log.info("Agregando el coche " + coche );
        return "hola";
    }

}
