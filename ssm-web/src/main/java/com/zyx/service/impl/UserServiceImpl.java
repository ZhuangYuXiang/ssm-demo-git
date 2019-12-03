package com.zyx.service.impl;

import com.zyx.bean.User;
import com.zyx.dao.UserDao;
import com.zyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired            //降低扫描级别
    private UserDao userDao;

    @Override
    public  User checkName(String name){
        return this.userDao.queryData(name);
    }
}
