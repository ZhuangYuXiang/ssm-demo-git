package com.zyx.dao;

import com.zyx.bean.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {
    User queryData(@Param("name") String name);
}
