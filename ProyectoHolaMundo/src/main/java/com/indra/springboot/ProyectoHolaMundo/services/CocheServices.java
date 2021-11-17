package com.indra.springboot.ProyectoHolaMundo.services;

import com.indra.springboot.ProyectoHolaMundo.controllers.CocheForm;
import com.indra.springboot.ProyectoHolaMundo.entities.CocheDto;
import com.indra.springboot.ProyectoHolaMundo.entities.ComercialDto;
import com.indra.springboot.ProyectoHolaMundo.entities.VentasDto;
import com.indra.springboot.ProyectoHolaMundo.repositories.CocheRepository;
import com.indra.springboot.ProyectoHolaMundo.repositories.ComercialRepository;
import com.indra.springboot.ProyectoHolaMundo.repositories.VentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class CocheServices {

    @Autowired
    private CocheRepository cocheRepository;

    @Autowired
    private ComercialRepository comercialRepository;

    @Autowired
    private VentaRepository ventaRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public void agregarCoche(CocheForm cocheForm){
        //CocheDto cocheDto = new CocheDto(null,cocheForm.getMarca(),cocheForm.getColor());

        CocheDto cocheDto = modelMapper.map(cocheForm,CocheDto.class);

        cocheRepository.save(cocheDto);


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
        Set<VentasDto> ventasDtoSet = ventaRepository.findByComercialDtoSet(comercialDto);
        List<CocheForm> coches = new ArrayList<>();
        Iterator it = ventasDtoSet.iterator();
        while(it.hasNext()){
            VentasDto ventasDto = (VentasDto) it.next();
            CocheDto cocheDto = cocheRepository.findByVentasDto(ventasDto);
            VentasDto ventaTmp = cocheDto.getVentasDto();
            coches.add(modelMapper.map(cocheDto,CocheForm.class));
        }
        return coches;
    }
}
