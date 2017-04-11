package com.ekarudianto.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.ekarudianto.model.Locale;

@Configuration
@PropertySource("classpath:/en-GB.properties")
public class LocaleConfig {
	
	@Value("${users.not.found}")
	private String usersNotFound;
	
	@Value("${must.not.provide.id}")
	private String mustNotProvideId;
    
	/**
	 * This section is required to read all of the "en-GB.properties" file properties
	 * and bind the property into variables specified above.
	 */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    /**
     * Bind properties to Locale class
     * @return {object} locale properties
     */
    @Bean
    public Locale locale() {
    	Locale locale = new Locale();
    	locale.setUsersNotFound(usersNotFound);
    	locale.setMustNotProvideId(mustNotProvideId);
    	return locale;
    }
}
