package com.baizzhi;

import com.baizzhi.dao.AdminDAO;
import com.baizzhi.entity.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class YingxuesApplicationTests {
    @Resource
    AdminDAO adminDAO;
    @Test
    void contextLoads() {
        Admin admin=adminDAO.queryByUserName("admin");
        System.out.println(admin);
    }
}
