package com.indra.cloud.ProyectoActuator.jobs;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.batch.item.ItemProcessor;

import com.indra.cloud.ProyectoActuator.entities.Riesgo;
import com.indra.cloud.ProyectoActuator.entities.TarjetaCredito;

public class TarjetaCreditoProcessor implements ItemProcessor<TarjetaCredito, Riesgo>{

	@Override
	public Riesgo process(TarjetaCredito item) throws Exception {

		LocalDate hoy = LocalDate.now();
        LocalDate ultimaFecha = item.getUltimoPago().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(hoy,ultimaFecha);
        int diasEntreMedias = Math.abs(period.getDays());
        
        int riesgoI;

        if(diasEntreMedias >= 20){
            riesgoI = Riesgo.ALTO;
        }else if(diasEntreMedias > 10){
            riesgoI = Riesgo.BAJO;
        }else{
            riesgoI = Riesgo.NORMAL;
        }
        
        Riesgo riesgo = new Riesgo();
        riesgo.setTarjetaCredito(item);
        riesgo.setFecha(new Date());
        riesgo.setPuntuacion(riesgoI);

        return riesgo;
	}
	
	

}
