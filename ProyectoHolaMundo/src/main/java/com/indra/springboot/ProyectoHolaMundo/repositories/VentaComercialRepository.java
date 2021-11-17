package com.indra.springboot.ProyectoHolaMundo.repositories;

import com.indra.springboot.ProyectoHolaMundo.entities.ComercialDto;
import com.indra.springboot.ProyectoHolaMundo.entities.VentaComercial;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface VentaComercialRepository extends CrudRepository<VentaComercial, Long> {

    public Set<VentaComercial> findByComercialDto(ComercialDto comercialDto);

}
