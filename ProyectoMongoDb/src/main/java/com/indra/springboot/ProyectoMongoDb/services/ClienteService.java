package com.indra.springboot.ProyectoMongoDb.services;

import com.indra.springboot.ProyectoMongoDb.entities.Cliente;
import com.indra.springboot.ProyectoMongoDb.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente getCliente(String id){
        try {
            return clienteRepository.findById(id).get();
        }catch (NoSuchElementException e){
            return new Cliente();
        }

    }

    public String altaCliente(String nombre,String direccion){
        Cliente cliente = new Cliente();
        UUID uuid = UUID.randomUUID();
        cliente.setId(uuid.toString());
        cliente.setNombre(nombre);
        cliente.setDireccion(direccion);
        cliente = clienteRepository.save(cliente);
        return cliente.getId();
    }


    public void borrarCliente(String idCliente) {
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        clienteRepository.delete(cliente);
    }
}
