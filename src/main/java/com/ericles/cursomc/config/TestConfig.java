package com.ericles.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ericles.cursomc.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBService dbservice;
	
	
	@Bean
	public boolean InstantiateDatabase() throws ParseException {
		dbservice.instantatiateTestDatabase();
		return true;
	}
}
