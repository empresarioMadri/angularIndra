package com.indra.springboot.ProyectoMongoDb.repositories;

import com.indra.springboot.ProyectoMongoDb.entities.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente,String> {

}
