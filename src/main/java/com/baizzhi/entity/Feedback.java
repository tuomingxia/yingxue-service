package com.baizzhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Table(name = "yx_feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    @Id  //主键
    private Integer id;

    private String title;

    private String content;
    @Column(name = "user_id")
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "delete_time")
    private Date deleteTime;

}