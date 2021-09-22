package com.baizzhi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResultPageVO {
    private Integer page;
    private Integer total;
    private Object rows;
}
