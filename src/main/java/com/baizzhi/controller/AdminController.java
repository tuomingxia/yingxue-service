package com.baizzhi.controller;

import com.baizzhi.dao.AdminDAO;
import com.baizzhi.dto.AdminDTO;
import com.baizzhi.entity.Admin;
import com.baizzhi.service.AdminService;
import jdk.nashorn.internal.parser.Token;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("login")
    public HashMap<String,Object>login(@RequestBody AdminDTO adminDTO){
        System.out.println("adminDTO"+adminDTO);
        //调用方法生成验证码 并返回数据
        return adminService.login(adminDTO);
    }
    @PostMapping("queryToken")
    public Admin queryToken(String token){
        //调用方法生成验证码 并返回数据
        return adminService.queryToken(token);
    }

    @GetMapping("logout")
    public HashMap<String,Object> logout(String token){
        System.out.println("token: "+token);
        //调用方法生成验证码 并返回数据
        return adminService.logout(token);
    }
}
