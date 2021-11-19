package com.indra.springboot.ProyectoMongoDb.controllers;

import com.indra.springboot.ProyectoMongoDb.entities.Cliente;
import com.indra.springboot.ProyectoMongoDb.entities.Coche;
import com.indra.springboot.ProyectoMongoDb.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/altaCliente")
    public String altaCliente(@RequestParam Map<String, String> parametros) {
        return clienteService.altaCliente(parametros.get("nombre"), parametros.get("direccion"));
    }

    @PostMapping("/altaCoche")
    public ResponseEntity<Cliente> altaCliente(@RequestBody Coche coche, @PathVariable("idCliente") String idCliente) {
        return new ResponseEntity<>(clienteService.altaCoche(coche, idCliente), HttpStatus.OK);
    }

    @GetMapping("/getCliente/{idCliente}")
    public Cliente getCliente(@PathVariable("idCliente") String idCliente) {
        return clienteService.getCliente(idCliente);
    }

    @DeleteMapping("/delCliente/{idCliente}")
    public ResponseEntity<String> delCliente(@PathVariable("idCliente") String idCliente) {
        clienteService.borrarCliente(idCliente);
        return new ResponseEntity<String>("borrado correcto", HttpStatus.OK);
    }


}
