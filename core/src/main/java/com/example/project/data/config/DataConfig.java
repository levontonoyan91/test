package com.example.project.data.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db-config.properties")
@EntityScan("com.example.project.common.data.model")
@EnableJpaRepositories("com.example.project.data")
@EnableTransactionManagement
public class DataConfig {
}
