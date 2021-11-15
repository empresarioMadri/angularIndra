package com.indra.springboot.ProyectoHolaMundo.services;

import com.indra.springboot.ProyectoHolaMundo.controllers.CocheForm;
import com.indra.springboot.ProyectoHolaMundo.entities.CocheDto;
import com.indra.springboot.ProyectoHolaMundo.repositories.CocheRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CocheServices {

    @Autowired
    private CocheRepository cocheRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public void agregarCoche(CocheForm cocheForm){
        //CocheDto cocheDto = new CocheDto(null,cocheForm.getMarca(),cocheForm.getColor());

        CocheDto cocheDto = modelMapper.map(cocheForm,CocheDto.class);

        cocheRepository.save(cocheDto);


    }
}
