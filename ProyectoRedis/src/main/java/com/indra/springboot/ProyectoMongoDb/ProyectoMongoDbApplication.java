package com.indra.springboot.ProyectoMongoDb;

import com.indra.springboot.ProyectoMongoDb.entities.Coche;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
@Slf4j
public class ProyectoMongoDbApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoMongoDbApplication.class, args);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String clave = encoder.encode("123");
		log.info("Clave para el usuario " + clave);
	}

	@Bean
	@Description("Spring Message Resolver")
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("mensajes");
		return messageSource;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("idioma");
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public LocaleResolver localeResolver()
	{
		final SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("en", "UK"));
		return localeResolver;
	}

	@Bean
	public RedisTemplate<String, Coche> redisTemplate(RedisConnectionFactory connectionFactory){
		RedisTemplate<String,Coche> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		return redisTemplate;
	}

}
