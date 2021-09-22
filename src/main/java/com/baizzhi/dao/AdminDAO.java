package com.baizzhi.dao;

import com.baizzhi.entity.Admin;

public interface AdminDAO {
    Admin queryByUserName(String username);

    Admin queryById(Integer id);
}
