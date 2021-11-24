package com.indra.cloud.ProyectoActuator.listeners;

import org.springframework.batch.core.ItemReadListener;

import com.indra.cloud.ProyectoActuator.entities.TarjetaCredito;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TarjetaCreditoReaderListener implements ItemReadListener<TarjetaCredito>{

	@Override
	public void beforeRead() {
		 log.info("Antes de leer");		
	}

	@Override
	public void afterRead(TarjetaCredito item) {
		 log.info("Despues de leer " + item);
	}

	@Override
	public void onReadError(Exception ex) {
		 log.info("Error en la lectura " + ex.getMessage());
	}
	
	

}
