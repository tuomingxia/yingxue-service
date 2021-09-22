package com.baizzhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@tk.mybatis.spring.annotation.MapperScan("com.baizzhi.dao")
@org.mybatis.spring.annotation.MapperScan("com.baizzhi.dao")
@SpringBootApplication
public class YingxuesApplication {

    public static void main(String[] args) {
        SpringApplication.run(YingxuesApplication.class, args);
    }

}
