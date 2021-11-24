package com.indra.cloud.ProyectoActuator.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.indra.cloud.ProyectoActuator.entities.Riesgo;
import com.indra.cloud.ProyectoActuator.entities.TarjetaCredito;
import com.indra.cloud.ProyectoActuator.jobs.RiesgoWriter;
import com.indra.cloud.ProyectoActuator.jobs.TarjetaCreditoProcessor;
import com.indra.cloud.ProyectoActuator.jobs.TarjetaCreditoReader;
import com.indra.cloud.ProyectoActuator.listeners.RiesgoWriterListener;
import com.indra.cloud.ProyectoActuator.listeners.TarjetaCreditoExecutionListener;
import com.indra.cloud.ProyectoActuator.listeners.TarjetaCreditoProcessorListener;
import com.indra.cloud.ProyectoActuator.listeners.TarjetaCreditoReaderListener;

@Configuration
@EnableBatchProcessing
public class ProcesoConfiguration {
	
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
    
    @Bean
    public TarjetaCreditoProcessor processor() {
        return new TarjetaCreditoProcessor();
    }

    
    @Bean
    public TarjetaCreditoExecutionListener jobExecutionListener() {
        return new TarjetaCreditoExecutionListener();
    }

    @Bean
    public TarjetaCreditoProcessorListener processorListener() {
        return new TarjetaCreditoProcessorListener();
    }
    
    @Bean
    public TarjetaCreditoReaderListener readerListener(){
        return new TarjetaCreditoReaderListener();
    }
    
    @Bean
    public RiesgoWriterListener writerListener(){
        return new RiesgoWriterListener();
    }
    
    @Bean
    public Job job(Step paso,TarjetaCreditoExecutionListener tarjetaCreditoExecutionListener){
        Job job = jobBuilderFactory.get("trabajo1")
                .listener(tarjetaCreditoExecutionListener)
                .flow(paso)
                .end()
                .build();
        return job;
    }
    
    @Bean
    public Step step(TarjetaCreditoReader tarjetaCreditoReader,
                     RiesgoWriter riesgoWriter,
                     TarjetaCreditoProcessor tarjetaCreditoProcessor,
                     TarjetaCreditoReaderListener tarjetaCreditoReaderListener,
                     TarjetaCreditoProcessorListener tarjetaCreditoProcessorListener,
                     RiesgoWriterListener riesgoWriterListener){
        TaskletStep step = stepBuilderFactory.get("paso1")
                .<TarjetaCredito, Riesgo>chunk(100)
                .reader(tarjetaCreditoReader)
                .processor(tarjetaCreditoProcessor)
                .writer(riesgoWriter)
                .listener(tarjetaCreditoReaderListener)
                .listener(tarjetaCreditoProcessorListener)
                .listener(riesgoWriterListener)
                .build();
        return step;
    }

}
