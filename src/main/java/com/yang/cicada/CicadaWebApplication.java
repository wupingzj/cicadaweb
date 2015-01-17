package com.yang.cicada;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class CicadaWebApplication {
	final private static Logger LOGGER = LoggerFactory.getLogger(CicadaWebApplication.class);

    public static void main(String[] args) {
    	LOGGER.debug("************ Starting CicadaWebApplication...");
    	LOGGER.debug("The entry is {}.", "MY DUMMY MESSAGE");
        
    	SpringApplication.run(CicadaWebApplication.class, args);
        
        LOGGER.debug("Set {1,2} differs from {{}}", "3");
        LOGGER.debug("************ CicadaWebApplication started ****************.");
    }
}
