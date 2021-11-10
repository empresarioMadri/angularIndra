package com.indra.angular.AngularCoches.controllers;

import com.indra.angular.AngularCoches.controllers.beans.Coche;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CocheController {

    @RequestMapping(value="/coches",method = RequestMethod.GET)
    public ResponseEntity<List<Coche>> listado(){
        List<Coche> coches = new ArrayList<>();
        Coche coche = new Coche();
        coche.setColor("rosa");
        coche.setMarca("Tesla");
        coches.add(coche);
        coche = new Coche();
        coche.setColor("violeta");
        coche.setMarca("Mercedes");
        coches.add(coche);
        return new ResponseEntity<>(coches, HttpStatus.OK);
    }

}
