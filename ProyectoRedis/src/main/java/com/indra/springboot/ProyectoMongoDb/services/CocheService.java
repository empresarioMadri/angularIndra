package com.indra.springboot.ProyectoMongoDb.services;

import com.indra.springboot.ProyectoMongoDb.form.CocheForm;
import com.indra.springboot.ProyectoMongoDb.entities.Coche;
import com.indra.springboot.ProyectoMongoDb.repositories.CocheRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CocheService {

    @Autowired
    private CocheRepository cocheRepository;

    @Autowired
    private RedisTemplate<String, Coche> redisTemplate;

    private ModelMapper modelMapper = new ModelMapper();

    public void agregarCoche(CocheForm cocheF) {

        Coche coche = modelMapper.map(cocheF, Coche.class);
        if(coche.getId()==null || coche.getId().equals("0"))
            coche.setId(UUID.randomUUID().toString());
        cocheRepository.save(coche);
        redisTemplate.opsForValue().set(coche.getId(),coche);
    }

    public CocheForm getCocheRedis(String idCoche){
        return modelMapper.map(redisTemplate.opsForValue().get(idCoche),CocheForm.class);
    }

    public List<CocheForm> listadoCoches() {

        List<Coche> coches = cocheRepository.findAll();
        List<CocheForm> retorno = new ArrayList<>();
        for (Coche coche : coches) {
            retorno.add(modelMapper.map(coche, CocheForm.class));
        }
        return retorno;
    }

    public List<CocheForm> listadoCochesPorComercial(Long idComercial) {
        List<Coche> coches = cocheRepository.findByComercial(idComercial);
        List<CocheForm> retorno = new ArrayList<>();
        for (Coche coche : coches) {
            retorno.add(modelMapper.map(coche, CocheForm.class));
        }
        return retorno;
    }

    public void borrarCoche(String idCoche) {
        cocheRepository.deleteById(idCoche);
    }

    public List<CocheForm> listadoCochesPorColor(String color) {
        List<Coche> coches = cocheRepository.findByColor(color);
        List<CocheForm> retorno = new ArrayList<>();
        for (Coche coche : coches) {
            retorno.add(modelMapper.map(coche, CocheForm.class));
        }
        return retorno;
    }

    public List<CocheForm> listadoCochesPorMarca(String marca) {
        List<Coche> coches = cocheRepository.findByMarca(marca);
        List<CocheForm> retorno = new ArrayList<>();
        for (Coche coche : coches) {
            retorno.add(modelMapper.map(coche, CocheForm.class));
        }
        return retorno;
    }
}
