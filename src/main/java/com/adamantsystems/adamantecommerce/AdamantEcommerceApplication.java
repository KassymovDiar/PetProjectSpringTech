package com.adamantsystems.adamantecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class AdamantEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdamantEcommerceApplication.class, args);
    }

}
