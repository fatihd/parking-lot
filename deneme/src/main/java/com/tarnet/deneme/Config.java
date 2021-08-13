package com.tarnet.deneme;

import com.tarnet.excluded.OtherService;
import com.tarnet.excluded.OtherServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public OtherService otherService() {
        return new OtherServiceImpl();
    }
}
