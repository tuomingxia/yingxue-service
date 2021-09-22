package com.baizzhi.controller;

import com.baizzhi.dto.PageDTO;
import com.baizzhi.entity.Feedback;
import com.baizzhi.service.FeedbackService;
import com.baizzhi.vo.CommonResult;
import com.baizzhi.vo.CommonResultPageVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.PreUpdate;
import java.util.HashMap;

@RestController//controller组件对象交给工厂管理
@CrossOrigin //跨域
@RequestMapping("feedback")
public class FeedbackController {

    @Resource
    FeedbackService feedbackService;

    @PostMapping("queryAllPage")
    public CommonResultPageVO queryAllPage(@RequestBody PageDTO pageDTO){
        System.out.println("pageDTO: "+pageDTO);
        return feedbackService.queryAllPage(pageDTO);
    }

    @RequestMapping("delete")
    public CommonResult delete(@RequestBody Feedback feedback){
        System.out.println("feedback: "+feedback);
        try {
            feedbackService.delete(feedback);
            return  CommonResult.success();
        }catch ( Exception e){
            e.printStackTrace();
            return  CommonResult.faild();
        }

    }
}
