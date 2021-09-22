package com.baizzhi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
        private String username;
        private String password;
        private String enCode;
        private String codeId;
}
