package com.alitbit.sizeDesign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SizeDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SizeDesignApplication.class, args);
    }
}
