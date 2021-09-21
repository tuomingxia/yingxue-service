package com.baizzhi.controller;

import com.baizzhi.service.AdminService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController//controller组件对象交给工厂管理
@CrossOrigin //跨域
@RequestMapping("admin")
public class AdminController {
    @Resource
    AdminService adminService;

    @PostMapping("getImageCode")
    HashMap<String,Object> getImageCode(){
        //调用验证码并生成数据
       return adminService.getImageCode();
    }

}
