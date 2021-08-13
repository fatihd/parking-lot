package com.tarnet.deneme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class TestConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setPassword("mogan");
        dataSource.setUrl("jdbc:oracle:thin:@10.17.0.141:1521:TTK");
        dataSource.setUsername("mogan");
        return dataSource;
    }
}