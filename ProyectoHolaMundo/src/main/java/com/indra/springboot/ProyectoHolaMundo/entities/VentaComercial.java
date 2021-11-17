package com.indra.springboot.ProyectoHolaMundo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaComercial {

    @EmbeddedId
    private VentaComercialId ventaComercialId;

    private Date fecha;

    @ManyToOne
    @MapsId("ventaId")
    @JoinColumn(name = "venta_id")
    private VentasDto ventasDto;

    @ManyToOne
    @MapsId("comercialId")
    @JoinColumn(name = "comercial_id")
    private ComercialDto comercialDto;


}
