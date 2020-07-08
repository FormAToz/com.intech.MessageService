package com.intech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppLoader.class);

    public static void main(String[] args) {
        SpringApplication.run(AppLoader.class, args);
        LOGGER.info("-- Application started --");
    }
}
