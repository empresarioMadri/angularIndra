package com.indra.springboot.ProyectoMongoDb.controllers;

import com.indra.springboot.ProyectoMongoDb.entities.Cliente;
import com.indra.springboot.ProyectoMongoDb.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/altaCliente")
    public String altaCliente(@RequestParam Map<String,String> parametros){
        return clienteService.altaCliente(parametros.get("nombre"),parametros.get("direccion"));
    }



}
