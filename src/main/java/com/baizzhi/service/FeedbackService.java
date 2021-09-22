package com.baizzhi.service;

import com.baizzhi.dto.PageDTO;
import com.baizzhi.entity.Feedback;
import com.baizzhi.vo.CommonResultPageVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

public interface FeedbackService {
    CommonResultPageVO queryAllPage(PageDTO pageDTO);

    HashMap<String,Object> deletes( Feedback feedback);

    void delete( Feedback feedback);
}
