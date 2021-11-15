package com.indra.springboot.ProyectoHolaMundo.repositories;

import com.indra.springboot.ProyectoHolaMundo.entities.CocheDto;
import org.springframework.data.repository.CrudRepository;

public interface CocheRepository extends CrudRepository<CocheDto, Long> {
}
