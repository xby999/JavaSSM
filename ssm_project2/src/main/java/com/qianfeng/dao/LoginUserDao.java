package com.qianfeng.dao;

import com.qianfeng.pojo.LoginUser;

import java.util.List;

/**
 * 用户表相关 Dao操作
 */
public interface LoginUserDao {

   /**
    * <select id="selectByUsername"
    * parameterType="string"
    * resultType="com.qianfeng.pojo.LoginUser">
    */
   List<LoginUser> selectByUsername(String login_user_name);

   int updateUserName(LoginUser loginUser);
}
