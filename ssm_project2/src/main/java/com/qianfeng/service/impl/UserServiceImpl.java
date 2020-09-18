package com.qianfeng.service.impl;

import com.qianfeng.dao.UserDao;
import com.qianfeng.pojo.User;
import com.qianfeng.service.LoginService;
import com.qianfeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user)==0 ? false : true;
    }
}
