package com.indra.cloud.ProyectoActuator.listeners;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

import com.indra.cloud.ProyectoActuator.entities.Riesgo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RiesgoWriterListener implements ItemWriteListener<Riesgo>{

	@Override
	public void beforeWrite(List<? extends Riesgo> items) {
		log.info("Antes de escribir");
	}

	@Override
	public void afterWrite(List<? extends Riesgo> items) {
		log.info("Despues de escribir " + items.size());
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Riesgo> items) {
		log.info("Error al escribir " + exception.getMessage());
	}

}
