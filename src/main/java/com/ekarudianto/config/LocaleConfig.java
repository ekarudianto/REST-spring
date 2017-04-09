package com.ekarudianto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/en-GB.properties")
public class LocaleConfig {
	
	@Autowired
    Environment env;
	
	public String getProperty(String name) {
		return env.getProperty(name);
	}
}
