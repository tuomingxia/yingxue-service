package com.baizzhi;

import com.baizzhi.dao.AdminDAO;
import com.baizzhi.dao.FeedbackMapper;
import com.baizzhi.entity.Admin;
import com.baizzhi.entity.Feedback;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class YingxuesApplicationTests {
    @Resource
    AdminDAO adminDAO;
    @Resource
    FeedbackMapper feedbackMapper;
    @Test
    void contextLoads() {
        Admin admin=adminDAO.queryByUserName("admin");
        System.out.println(admin);
    }
    @Test
    void contextLoadss() {

    }
}
