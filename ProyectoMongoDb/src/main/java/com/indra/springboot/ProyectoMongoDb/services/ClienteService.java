package com.indra.springboot.ProyectoMongoDb.services;

import com.indra.springboot.ProyectoMongoDb.entities.Cliente;
import com.indra.springboot.ProyectoMongoDb.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public String altaCliente(String nombre,String direccion){
        Cliente cliente = new Cliente();
        UUID uuid = UUID.randomUUID();
        cliente.setId(uuid.toString());
        cliente.setNombre(nombre);
        cliente.setDireccion(direccion);
        cliente = clienteRepository.save(cliente);
        return cliente.getId();
    }


}
