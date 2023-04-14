package com.example.configservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServiceApplication {

    private String readyToOrder;
    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceApplication.class, args);
    }

}
