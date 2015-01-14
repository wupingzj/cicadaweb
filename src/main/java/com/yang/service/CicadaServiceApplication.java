package com.yang.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class CicadaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CicadaServiceApplication.class, args);
    }
}
