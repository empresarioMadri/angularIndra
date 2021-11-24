package com.indra.cloud.ProyectoActuator.listeners;

import org.springframework.batch.core.ItemProcessListener;

import com.indra.cloud.ProyectoActuator.entities.Riesgo;
import com.indra.cloud.ProyectoActuator.entities.TarjetaCredito;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TarjetaCreditoProcessorListener implements ItemProcessListener<TarjetaCredito, Riesgo> {

	@Override
	public void beforeProcess(TarjetaCredito item) {
		log.info("Antes de procesar");
	}

	@Override
	public void afterProcess(TarjetaCredito item, Riesgo result) {
		log.info("Despues de procesar " + item + " " + result);
	}

	@Override
	public void onProcessError(TarjetaCredito item, Exception e) {
		log.info("Error en el procesamiento " + e.getMessage());
	}

}
