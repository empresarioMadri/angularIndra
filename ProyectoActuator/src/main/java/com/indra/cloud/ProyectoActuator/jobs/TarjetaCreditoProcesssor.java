package com.indra.cloud.ProyectoActuator.jobs;

import org.springframework.batch.item.ItemProcessor;

import com.indra.cloud.ProyectoActuator.entities.Riesgo;
import com.indra.cloud.ProyectoActuator.entities.TarjetaCredito;

public class TarjetaCreditoProcesssor implements ItemProcessor<TarjetaCredito, Riesgo>{

	@Override
	public Riesgo process(TarjetaCredito item) throws Exception {

		
		
		
		return null;
	}
	
	

}
