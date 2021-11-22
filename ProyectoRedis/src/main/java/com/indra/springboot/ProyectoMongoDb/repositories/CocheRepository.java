package com.indra.springboot.ProyectoMongoDb.repositories;

import com.indra.springboot.ProyectoMongoDb.entities.Cliente;
import com.indra.springboot.ProyectoMongoDb.entities.Coche;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Set;

public interface CocheRepository extends MongoRepository<Coche,String> {

    public Coche findByIdCliente(String idCliente);

    public List<Coche> findByComercial(Long comercial);

    public List<Coche> findByColor(String color);

    public List<Coche> findByMarca(String marca);
}
