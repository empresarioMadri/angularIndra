package com.indra.springboot.ProyectoMongoDb.repositories;

import com.indra.springboot.ProyectoMongoDb.entities.Cliente;
import com.indra.springboot.ProyectoMongoDb.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    Usuario findByLogin(String s);
}
