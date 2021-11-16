package com.indra.springboot.ProyectoHolaMundo.controllers;

import com.indra.springboot.ProyectoHolaMundo.services.CocheServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CochesController {

    @Autowired
    private CocheServices cocheServices;

    @RequestMapping("/")
    public String hola(Model modelo){
        CocheForm coche = new CocheForm("seat","rojo");
        modelo.addAttribute("coche",coche);
        return "hola";
    }

    @PostMapping("/agregar")
    public String agregarCoche(@ModelAttribute("coche") @Valid CocheForm coche, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.info("Error agregando el coche " + coche );
        }
        log.info("Agregando el coche " + coche );
        cocheServices.agregarCoche(coche);
        return "hola";
    }

    @PostMapping("/agregarAngular")
    public ResponseEntity<String> agregarCocheAngular(@RequestBody @Valid CocheForm coche, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.toString(),HttpStatus.BAD_REQUEST);
        }
        log.info("Agregando el coche " + coche );
        cocheServices.agregarCoche(coche);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @GetMapping("/coches")
    public ResponseEntity<List<CocheForm>> listadoCoches(){
        return new ResponseEntity<List<CocheForm>>(cocheServices.listadoCoches(), HttpStatus.OK);
    }


    @GetMapping("/cochesPorComercial")
    public ResponseEntity<List<CocheForm>> listadoCoches(@RequestParam(name="id",required = true)Long idComercial){
        return new ResponseEntity<List<CocheForm>>(cocheServices.listadoCochesPorComercial(idComercial), HttpStatus.OK);
    }

}
