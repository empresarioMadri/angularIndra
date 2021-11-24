package com.indra.cloud.ProyectoActuator.listeners;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TarjetaCreditoExecutionListener implements JobExecutionListener{

	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.info("Antes de empezar");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		log.info("Despues de terminar");
	}
	
	

}
