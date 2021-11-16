package com.indra.springboot.ProyectoHolaMundo.repositories;

import com.indra.springboot.ProyectoHolaMundo.entities.CocheDto;
import com.indra.springboot.ProyectoHolaMundo.entities.ComercialDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComercialRepository extends CrudRepository<ComercialDto, Long> {

}
