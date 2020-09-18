package com.qianfeng.dao;

import com.qianfeng.pojo.Businessinfo;
import com.qianfeng.pojo.SystemUser;
import com.qianfeng.pojo.SystemUserAndUsername;

import java.util.List;

public interface SystemUserDao {

    List<Businessinfo> selectBusinessUserAllInfo();

    List<SystemUserAndUsername> selectSystemUserAllInfo();

    //根据id查询用hu信息
    SystemUserAndUsername selectSystemUserByID(int login_user_id);

    int updateAllData(SystemUser systemUser);

    /**
     * 查看用户名是否重复
     * @param login_user_name
     * @return
     */
    SystemUserAndUsername selectByUsername(String login_user_name);

}
