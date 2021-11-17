package com.indra.springboot.ProyectoHolaMundo.services;

import com.indra.springboot.ProyectoHolaMundo.controllers.CocheForm;
import com.indra.springboot.ProyectoHolaMundo.entities.*;
import com.indra.springboot.ProyectoHolaMundo.repositories.CocheRepository;
import com.indra.springboot.ProyectoHolaMundo.repositories.ComercialRepository;
import com.indra.springboot.ProyectoHolaMundo.repositories.VentaComercialRepository;
import com.indra.springboot.ProyectoHolaMundo.repositories.VentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CocheServices {

    @Autowired
    private CocheRepository cocheRepository;

    @Autowired
    private ComercialRepository comercialRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private VentaComercialRepository ventaComercialRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public void agregarCoche(CocheForm cocheForm){
        //CocheDto cocheDto = new CocheDto(null,cocheForm.getMarca(),cocheForm.getColor());

        VentasDto ventasDto = new VentasDto(null,"Venta realizada por el comercial " + cocheForm.getComercial() +
            " del coche " + cocheForm.getMarca() + " " + cocheForm.getColor(),new ArrayList<>());

        ventaRepository.save(ventasDto);

        ComercialDto comercialDto = comercialRepository.findById(cocheForm.getComercial()).get();


        CocheDto cocheDto = modelMapper.map(cocheForm,CocheDto.class);
        cocheDto.setVentasDto(ventasDto);
        cocheDto = cocheRepository.save(cocheDto);

        VentaComercial ventaComercial = new VentaComercial();
        VentaComercialId ventaComercialId = new VentaComercialId(ventasDto.getId(),cocheForm.getComercial());
        ventaComercial.setFecha(new Date());

        ventaComercialRepository.save(ventaComercial);




    }

    public List<CocheForm> listadoCoches() {
        List<CocheForm> coches = new ArrayList<>();
        Iterator it = cocheRepository.findAll().iterator();
        while(it.hasNext()){
            CocheDto cocheDto = (CocheDto) it.next();
            coches.add(modelMapper.map(cocheDto,CocheForm.class));
        }
        return coches;
    }


    public List<CocheForm> listadoCochesPorColor(String color) {
        List<CocheForm> coches = new ArrayList<>();
        Iterator it = cocheRepository.buscoColor(color).iterator();
        while(it.hasNext()){
            CocheDto cocheDto = (CocheDto) it.next();
            coches.add(modelMapper.map(cocheDto,CocheForm.class));
        }
        return coches;
    }

    public List<CocheForm> listadoCochesPorMarca(String marca) {
        List<CocheForm> coches = new ArrayList<>();
        Iterator it = cocheRepository.buscarMarca(marca).iterator();
        while(it.hasNext()){
            CocheDto cocheDto = (CocheDto) it.next();
            coches.add(modelMapper.map(cocheDto,CocheForm.class));
        }
        return coches;
    }

    public List<CocheForm> listadoCochesPorComercial(Long idComercial) {
        ComercialDto comercialDto = comercialRepository.findById(idComercial).get();
        Set<VentaComercial> ventasDtoSet = ventaComercialRepository.findByComercialDto(comercialDto);
        List<CocheForm> coches = new ArrayList<>();
        Iterator it = ventasDtoSet.iterator();
        while(it.hasNext()){
            VentaComercial ventaComercial = (VentaComercial) it.next();
            CocheDto cocheDto = cocheRepository.findByVentasDto(ventaComercial.getVentasDto());
            VentasDto ventaTmp = cocheDto.getVentasDto();
            CocheForm cocheForm = modelMapper.map(cocheDto,CocheForm.class);
            cocheForm.setFecha(ventaComercial.getFecha());
            coches.add(cocheForm);
        }
        return coches;
    }
}
