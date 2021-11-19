package com.indra.springboot.ProyectoMongoDb.repositories;

import com.indra.springboot.ProyectoMongoDb.entities.Cliente;
import com.indra.springboot.ProyectoMongoDb.entities.Coche;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CocheRepository extends MongoRepository<Coche,String> {

    public Coche findByIdCliente(String idCliente);

}
