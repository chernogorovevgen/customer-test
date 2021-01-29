package com.chernogorov.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.flywaydb.core.Flyway;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(value = "com.chernogorov.repository.mapper")
public class PersistConfig {

    @Bean
   @ConfigurationProperties(prefix = "spring.datasource")
    DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean
    @Primary
    DataSource dataSource(DataSourceProperties dp) {

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(dp.getUrl());
        dataSourceBuilder.username(dp.getUsername());
        dataSourceBuilder.password(dp.getPassword());
        dataSourceBuilder.driverClassName(dp.getDriverClassName());

        return dataSourceBuilder.build();
    }

    @Bean
    @Primary
    SqlSessionFactory sqlSessionFactory(DataSource postgresDataSource) throws Exception {

        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(postgresDataSource);
        sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));

        return sessionFactory.getObject();

    }

    @Bean(initMethod = "migrate")
    @Primary
    Flyway flyway(DataSource dataSource) {

        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setLocations("classpath:db/migration/postgres");
        flyway.setBaselineOnMigrate(false);
        flyway.setSchemas("public");

        return flyway;

    }




}
