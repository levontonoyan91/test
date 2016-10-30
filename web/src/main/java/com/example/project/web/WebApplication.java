package com.example.project.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(
        scanBasePackages = {
                "com.example.project.web",
                "com.example.project.data",
                "com.example.project.common",
                "com.example.project.data.repository",
                "com.example.project.data.dao"
        }
)
@EnableJpaRepositories
@EnableTransactionManagement
public class WebApplication extends SpringBootServletInitializer implements CommandLineRunner {

    /**
     * in case of application is deployed under traditional server
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
    }
}
