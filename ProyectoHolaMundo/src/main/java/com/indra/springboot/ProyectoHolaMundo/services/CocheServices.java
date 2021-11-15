package com.indra.springboot.ProyectoHolaMundo.services;

import com.indra.springboot.ProyectoHolaMundo.controllers.CocheForm;
import com.indra.springboot.ProyectoHolaMundo.entities.CocheDto;
import com.indra.springboot.ProyectoHolaMundo.repositories.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CocheServices {

    @Autowired
    private CocheRepository cocheRepository;

    public void agregarCoche(CocheForm cocheForm){
        //CocheDto cocheDto = new CocheDto(null,cocheForm.getMarca(),cocheForm.getColor());




    }
}
