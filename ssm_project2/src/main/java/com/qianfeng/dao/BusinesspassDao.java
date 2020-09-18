package com.qianfeng.dao;

import com.qianfeng.pojo.Businesspass;

public interface BusinesspassDao {

    //检查用户名对应的密码是否正确
    Businesspass selectBusinessPass(Businesspass businesspass);

    //创建用户密码
    int insertBusinessPass(Businesspass businesspass);
}
