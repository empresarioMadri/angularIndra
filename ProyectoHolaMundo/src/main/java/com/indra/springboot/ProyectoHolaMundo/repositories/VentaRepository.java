package com.indra.springboot.ProyectoHolaMundo.repositories;

import com.indra.springboot.ProyectoHolaMundo.entities.CocheDto;
import com.indra.springboot.ProyectoHolaMundo.entities.ComercialDto;
import com.indra.springboot.ProyectoHolaMundo.entities.VentasDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VentaRepository extends CrudRepository<VentasDto, Long> {

    public List<VentasDto> findByComercialDto(ComercialDto comercialDto);

}
