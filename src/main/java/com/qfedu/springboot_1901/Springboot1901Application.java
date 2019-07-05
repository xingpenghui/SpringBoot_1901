package com.qfedu.springboot_1901;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Springboot1901Application {
    public static void main(String[] args) {
        SpringApplication.run(Springboot1901Application.class, args);
    }

}
