package com.qianfeng.service;

import com.qianfeng.pojo.Businessinfo;
import com.qianfeng.pojo.SystemUserAndUsername;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
public interface SystemUserService {

    List<Businessinfo> getBusinessUserAllInfo();

    List<SystemUserAndUsername> getSystemUserAllInfo();

    SystemUserAndUsername selectSystemUserByID(int login_user_id);

    /**
     * 修稿系统用户的数据
     * @param systemUserAndUsername
     * @param request
     * @return
     */
    boolean updateSystemUser(SystemUserAndUsername systemUserAndUsername, HttpServletRequest request);


    /**
     * 查看是否有重复登录名
     * @param login_user_name
     * @return
     */
    boolean selectIdByName(String login_user_name);

}
