package com.baizzhi.service.impl;

import com.baizzhi.entity.Admin;
import com.baizzhi.service.AdminService;
import com.baizzhi.uitl.ImageCodeUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Resource
    StringRedisTemplate stringRedisTemplate;


    @Override
    public HashMap<String,Object> getImageCode() {

        //1.生成验证码随机数
       String imgCode=ImageCodeUtil.getSecurityCode();
        //存储验证码随机数
        System.out.println("验证码: "+imgCode);
        //key(唯一)  value验证码随机数
        String codeId= UUID.randomUUID().toString();
        //2.存储验证码随机数 redis 设置key的存活时间为15分钟
        stringRedisTemplate.opsForValue().set(codeId,imgCode,15, TimeUnit.MINUTES);


        HashMap<String,Object>map=new HashMap<>();

        //3.将验证码图片转为Base64  生成验证码图片
        try {
            String base64Img = ImageCodeUtil.careateImgBase64(imgCode);

            map.put("imageCode",base64Img);
            map.put("codeId",codeId);

        }catch (IOException e){
            e.printStackTrace();
        }
        return map;
    }
}
