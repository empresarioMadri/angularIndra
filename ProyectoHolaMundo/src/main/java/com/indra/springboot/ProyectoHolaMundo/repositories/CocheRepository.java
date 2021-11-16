package com.indra.springboot.ProyectoHolaMundo.repositories;

import com.indra.springboot.ProyectoHolaMundo.entities.CocheDto;
import com.indra.springboot.ProyectoHolaMundo.entities.ComercialDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CocheRepository extends CrudRepository<CocheDto, Long> {

    public List<CocheDto> findByComercialDto(ComercialDto comercialDto);

    @Query("select c from CocheDto c where c.color = ?1")
    public List<CocheDto> buscoColor(String color);

    @Query(value = "select * from coches c where c.marca = :marca",nativeQuery = true)
    public List<CocheDto> buscarMarca(@Param("marca") String marca);

}
