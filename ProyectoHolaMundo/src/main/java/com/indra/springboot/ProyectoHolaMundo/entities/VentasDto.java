package com.indra.springboot.ProyectoHolaMundo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Ventas")
public class VentasDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @ManyToMany
    @JoinTable(
            name = "VentasComercial",
            joinColumns = @JoinColumn(name = "comercialId"),
            inverseJoinColumns = @JoinColumn(name = "ventaId"))
    Set<ComercialDto> comercialDtoSet;
}
