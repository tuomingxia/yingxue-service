package com.baizzhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.baizzhi.dao")
@SpringBootApplication
public class YingxuesApplication {

    public static void main(String[] args) {
        SpringApplication.run(YingxuesApplication.class, args);
    }

}
