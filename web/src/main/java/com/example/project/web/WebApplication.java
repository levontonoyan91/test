package com.example.project.web;

import com.example.project.common.data.model.User;
import com.example.project.common.data.model.lcp.UserStatus;
import com.example.project.common.data.model.lcp.UserType;
import com.example.project.common.exception.DatabaseException;
import com.example.project.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        final boolean emailExist = userService.isEmailExist("admin@mail.com");
        if (!emailExist){
            User user = new User();
            user.setName("admin");
            user.setSurname("admin");
            user.setEmail("admin@mail.com");
            user.setPassword("123456");
            user.setUserStatus(UserStatus.ACTIVE);
            user.setUserType(UserType.ADMIN);

            try {
                userService.add(user);
            }catch (Exception e){
                throw new DatabaseException(e);
            }
        }
    }
}
