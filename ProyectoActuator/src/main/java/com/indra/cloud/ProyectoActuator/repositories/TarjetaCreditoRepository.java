package com.indra.cloud.ProyectoActuator.repositories;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.cloud.ProyectoActuator.entities.Riesgo;
import com.indra.cloud.ProyectoActuator.entities.TarjetaCredito;
import com.indra.cloud.ProyectoActuator.jobs.TarjetaCreditoReader;
import com.indra.cloud.ProyectoActuator.jobs.RiesgoWriter;

@Configuration
@EnableBatchProcessing
public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, Long>{
	
	@Autowired
    public JobBuilderFactory jobBuilderFactory;


    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    
    @Bean
    public TarjetaCreditoReader reader() {
        return new TarjetaCreditoReader();
    }
    
    @Bean
    public RiesgoWriter writer() {
        return new RiesgoWriter();
    }

}
