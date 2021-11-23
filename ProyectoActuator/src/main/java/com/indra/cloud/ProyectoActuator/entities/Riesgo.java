package com.indra.cloud.ProyectoActuator.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Riesgo {
	
	public static final int ALTO =3;
    public static final int BAJO =2;
    public static final int NORMAL =1;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Date fecha;
    private int puntuacion;
    
    @OneToOne(optional=false)
    private TarjetaCredito tarjetaCredito;


}
