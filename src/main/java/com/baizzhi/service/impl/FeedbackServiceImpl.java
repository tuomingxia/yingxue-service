package com.baizzhi.service.impl;

import com.baizzhi.dao.FeedbackMapper;
import com.baizzhi.dto.PageDTO;
import com.baizzhi.entity.Feedback;
import com.baizzhi.entity.FeedbackExample;
import com.baizzhi.service.FeedbackService;
import com.baizzhi.vo.CommonResultPageVO;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    FeedbackMapper feedbackMapper;
    @Override
    public CommonResultPageVO queryAllPage(PageDTO pageDTO) {
        HashMap<String,Object>map=new HashMap<>();
        //page 1  pageSize 2    1 0~1   2 2~3  3 4~5  起始条数(page-1)*pageSize

        //创建条件对象
        FeedbackExample example=new FeedbackExample();
        example.createCriteria().andDeleteTimeIsNull();
        //查询总条数
        int total=feedbackMapper.selectCountByExample(example);

        //创建分页对象 参数(limit): 起始条数
        RowBounds rowBounds=new RowBounds(pageDTO.getPage()-1* pageDTO.getPageSize(),pageDTO.getPageSize());

        //分页查询数据 参数:条件对象, 分页对象
        List<Feedback> feedbackList=feedbackMapper.selectByExampleAndRowBounds(example,rowBounds);
//        map.put("page",pageDTO.getPage());//当前页
//        map.put("total",total);//分页条数 3
//        map.put("rows",feedbackList);//分页数据 2
        CommonResultPageVO commonResultPageVO=new CommonResultPageVO(pageDTO.getPage(),total,feedbackList);
        return commonResultPageVO;
    }

    @Override
    public HashMap<String, Object> deletes(Feedback feedback) {

        HashMap<String,Object>map=new HashMap<>();
        //添加删除时间
        feedback.setDeleteTime(new Date());
        try {
            feedbackMapper.updateByPrimaryKeySelective(feedback);
            map.put("message","删除成功!!!");
            map.put("status",200);
        }catch (Exception e){
            e.printStackTrace();
            map.put("message","删除失败!!!");
            map.put("status",500);
        }
        return map;
    }

    @Override
    public void delete(Feedback feedback) {
        feedback.setDeleteTime(new Date());
        feedbackMapper.updateByPrimaryKeySelective(feedback);
    }


}
