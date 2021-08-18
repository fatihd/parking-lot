package com.tarnet.deneme;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@Profile("development")
public class DatasourceDevelopmentConfig {

    @Bean
    public DataSource dataSource() {
        // no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
                .addScript("db/sql/create-db.sql")
                .addScript("db/sql/insert-data.sql")
                .build();
        return db;
    }

    @PostConstruct
    public void startDBManager() {
        DatabaseManagerSwing.main(new String[]{
//                "--url", "jdbc:hsqldb:mem:testdb,
                "--url", "jdbc:hsqldb:mem:testdb;sql.syntax_ora=true",
                "--user", "sa",
                "--password", ""
        });
    }
}