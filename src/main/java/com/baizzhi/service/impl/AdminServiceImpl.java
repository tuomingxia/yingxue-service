package com.baizzhi.service.impl;

import com.baizzhi.dao.AdminDAO;
import com.baizzhi.dto.AdminDTO;
import com.baizzhi.entity.Admin;
import com.baizzhi.service.AdminService;
import com.baizzhi.uitl.ImageCodeUtil;
import com.baizzhi.uitl.UUIDUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
    @Resource
    AdminDAO adminDAO;

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


    @Override
    public HashMap<String, Object> login(AdminDTO adminDTO) {
        //获取redis中String类型操作
        ValueOperations<String,String>stringOption =stringRedisTemplate.opsForValue();
        //1.获取验证码
        String codeId=stringOption.get(adminDTO.getCodeId());

        HashMap<String,Object>map=new HashMap<>();
        //2.验证码是否过期
        if(codeId!=null) {
            //3.验证验证码
            if(codeId.equals(adminDTO.getEnCode())){
                //通过 根据用户查询用户  判断用户是否存在
                Admin admin=adminDAO.queryByUserName(adminDTO.getUsername());
                if(admin!=null) {
                    //存在 判断密码是否准确
                    if(admin.getPassword().equals(adminDTO.getPassword())){
                        //存储用户信息  redis key=UUID,value=用户id
                        String adminUUID=UUIDUtil.getUUID();
                        //存储用户标记
                        stringOption.set(adminUUID,admin.getId().toString(),1,TimeUnit.DAYS);

                        map.put("status",200);
                        map.put("message",adminUUID);
                    }else {
                        //准确  返回信息
                        //不正确  返回信息
                        map.put("status",401);
                        map.put("message","密码错误");
                    }
                }else {
                    //不存在 返回信息
                    map.put("status",401);
                    map.put("message","该用户不存在");
                }
            }else{
                //不通过返回提示
                map.put("status",401);
                map.put("message","验证码不正确");
            }
        }else {
            map.put("status",401);
            map.put("message","验证码已过期,请最新获取!!!");
        }
        return map;
    }

    @Override
    public Admin queryToken(String token) {
        //1.用户获取id
        String adminIds=stringRedisTemplate.opsForValue().get(token);
        //将id转为Integer类型
        Integer adminId=Integer.valueOf(adminIds);
        //2.根据id查询用户信息
        Admin admin=adminDAO.queryById((Integer) adminId);
        return admin;
    }

    @Override
    public HashMap<String, Object> logout(String token) {
        //1.获取用户id
        stringRedisTemplate.delete(token);
        HashMap<String,Object> map=new HashMap<>();
        map.put("message","删除成功");
        return map;
    }
}
