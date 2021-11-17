package com.indra.springboot.ProyectoHolaMundo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VentaComercialId implements Serializable {

    @Column(name = "venta_id")
    private Long ventaId;

    @Column(name = "comercial_id")
    private Long comercialId;

}
