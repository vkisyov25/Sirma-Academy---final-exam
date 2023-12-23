package com.sirma.academy.finalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication(scanBasePackages = "com.sirma.academy.finalProject")
public class FinalProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(FinalProjectApplication.class, args);
    }

}
