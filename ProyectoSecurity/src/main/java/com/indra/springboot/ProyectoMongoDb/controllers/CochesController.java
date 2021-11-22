package com.indra.springboot.ProyectoMongoDb.controllers;

import com.indra.springboot.ProyectoMongoDb.form.CocheForm;
import com.indra.springboot.ProyectoMongoDb.services.CocheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class CochesController {

    @Autowired
    private CocheService cocheService;

    @RequestMapping("/menu")
    public String menu(Model modelo){
        CocheForm coche = new CocheForm("seat","rojo",null,null,new Date(),null);
        modelo.addAttribute("coche",coche);
        return "menu";
    }


    @PostMapping("/agregar")
    public String agregarCoche(@ModelAttribute("coche") @Valid CocheForm coche, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.info("Error agregando el coche " + coche );
        }
        log.info("Agregando el coche " + coche );
        cocheService.agregarCoche(coche);
        return "hola";
    }

    @PostMapping("/agregarAngular")
    public ResponseEntity<String> agregarCocheAngular(@RequestBody @Valid CocheForm coche, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.toString(),HttpStatus.BAD_REQUEST);
        }
        log.info("Agregando el coche " + coche );
        cocheService.agregarCoche(coche);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @GetMapping("/coches")
    public ResponseEntity<List<CocheForm>> listadoCoches(){
        return new ResponseEntity<List<CocheForm>>(cocheService.listadoCoches(), HttpStatus.OK);
    }


    @GetMapping("/cochesPorComercial")
    public ResponseEntity<List<CocheForm>> listadoCoches(@RequestParam(name="id",required = true)Long idComercial){
        return new ResponseEntity<List<CocheForm>>(cocheService.listadoCochesPorComercial(idComercial), HttpStatus.OK);
    }

    @DeleteMapping("/borrarAngular/{idCoche}")
    public ResponseEntity<String> borrarCoche(@PathVariable String idCoche){
        cocheService.borrarCoche(idCoche);
        return new ResponseEntity("",HttpStatus.OK);
    }

    @GetMapping("/cochesPorComercial2/{idComercial}")
    public ResponseEntity<List<CocheForm>> listadoCoches2(@PathVariable Long idComercial){
        return new ResponseEntity<List<CocheForm>>(cocheService.listadoCochesPorComercial(idComercial), HttpStatus.OK);
    }

    @GetMapping("/cochesPorColor")
    public ResponseEntity<List<CocheForm>> listadoCoches3(@RequestParam(name="color",required = true)String color){
        return new ResponseEntity<List<CocheForm>>(cocheService.listadoCochesPorColor(color), HttpStatus.OK);
    }

    @GetMapping("/cochesPorMarca/{marca}")
    public ResponseEntity<List<CocheForm>> listadoCoches4(@PathVariable String marca){
        return new ResponseEntity<List<CocheForm>>(cocheService.listadoCochesPorMarca(marca), HttpStatus.OK);
    }

}
