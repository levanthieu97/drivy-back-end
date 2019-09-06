package com.thieu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com.thieu.*.mappers")
public class TpshopApplication {
    public static void main(String[] args) {

        SpringApplication.run(TpshopApplication.class, args);

    }
}
