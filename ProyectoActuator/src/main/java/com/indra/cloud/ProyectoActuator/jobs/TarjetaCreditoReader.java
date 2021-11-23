package com.indra.cloud.ProyectoActuator.jobs;

import java.util.Iterator;

import javax.batch.runtime.StepExecution;

import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.indra.cloud.ProyectoActuator.entities.TarjetaCredito;
import com.indra.cloud.ProyectoActuator.repositories.TarjetaCreditoRepository;

public class TarjetaCreditoReader implements ItemReader<TarjetaCredito>{
	
	@Autowired
    private TarjetaCreditoRepository tarjetaCreditoRepositorio;

    private Iterator<TarjetaCredito> tarjetaCreditoIterator;
    
    
    @BeforeStep
    public void before(StepExecution stepExecution) {
    	tarjetaCreditoIterator = tarjetaCreditoRepositorio.findAll().iterator();
    }


	@Override
	public TarjetaCredito read() {
		if(tarjetaCreditoIterator != null && tarjetaCreditoIterator.hasNext()){
            return tarjetaCreditoIterator.next();
        }else{
            return null;
        }
	}
	
	

}
