package com.indra.springboot.ProyectoHolaMundo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CochesController {

    @RequestMapping("/")
    public String hola(Model modelo){
        modelo.addAttribute("mensaje","Hola mundo");
        return "hola";
    }

}
