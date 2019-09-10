package com.ericles.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ericles.cursomc.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	@Autowired
	private DBService dbservice;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategyDb;
	
	@Bean
	public boolean InstantiateDatabase() throws ParseException {
		
		if (!"create".equals(strategyDb)) {
			return false;
		}
		dbservice.instantatiateTestDatabase();
		return true;
	}
}
