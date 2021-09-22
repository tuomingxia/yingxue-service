package com.baizzhi.service;

import com.baizzhi.dao.AdminDAO;
import com.baizzhi.dto.AdminDTO;
import com.baizzhi.entity.Admin;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;


public interface AdminService {
        //获取验证码
        HashMap<String,Object> getImageCode();

        //登录方法
        HashMap<String,Object>login(@RequestBody AdminDTO adminDTO);
        //查询用户信息
        Admin queryToken(String token);
        //退出方法
        HashMap<String,Object> logout(String token);
}
