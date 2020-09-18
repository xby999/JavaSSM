package com.qianfeng.dao;

import com.qianfeng.pojo.Business;

public interface BusinessDao {


    /*查询对应用户名的数据*/
    Business selectByUsername(String business_username);

    //插入商户登录名信息
    int insertBusiness(String business_username);

}
