package com.indra.springboot.ProyectoHolaMundo.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Coches")
public class CocheDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String color;

    @ManyToOne
    @JoinColumn(name="comercialId")
    private ComercialDto comercialDto;
}
