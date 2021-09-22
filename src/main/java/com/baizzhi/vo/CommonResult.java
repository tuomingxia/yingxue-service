package com.baizzhi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {
    private String message;
    private Integer status;

    public static CommonResult success(String message,Integer status){
        CommonResult commonResult=new CommonResult();

        commonResult.setMessage(message);
        commonResult.setStatus(status);
        return commonResult;
    }

    public static CommonResult success(String message){
        CommonResult commonResult=new CommonResult();
        commonResult.setMessage(message);
        commonResult.setStatus(200);
        return commonResult;
    }
    public static CommonResult success(){
        CommonResult commonResult=new CommonResult();
        commonResult.setMessage("执行成功!!");
        commonResult.setStatus(200);
        return commonResult;
    }
    public static CommonResult faild(String message,Integer status){
        CommonResult commonResult=new CommonResult();
        commonResult.setMessage(message);
        commonResult.setStatus(status);
        return commonResult;
    }

    public static CommonResult faild(String message){
        CommonResult commonResult=new CommonResult();
        commonResult.setMessage(message);
        commonResult.setStatus(500);
        return commonResult;
    }
    public static CommonResult faild(){
        CommonResult commonResult=new CommonResult();
        commonResult.setMessage("执行失败!!!");
        commonResult.setStatus(500);
        return commonResult;
    }
}
