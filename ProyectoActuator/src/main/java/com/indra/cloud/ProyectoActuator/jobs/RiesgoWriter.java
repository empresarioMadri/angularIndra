package com.indra.cloud.ProyectoActuator.jobs;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.indra.cloud.ProyectoActuator.entities.Riesgo;
import com.indra.cloud.ProyectoActuator.repositories.RiesgoRepository;

public class RiesgoWriter implements ItemWriter<Riesgo> {

	@Autowired
	private RiesgoRepository riesgoRepositorio;

	@Override
	public void write(List<? extends Riesgo> items) throws Exception {
		riesgoRepositorio.saveAll(items);
	}

}
