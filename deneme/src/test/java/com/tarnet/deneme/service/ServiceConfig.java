package com.tarnet.deneme.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({
        "classpath:context.xml",
        "classpath:hibernate-config.xml",
})
public class ServiceConfig {
}
