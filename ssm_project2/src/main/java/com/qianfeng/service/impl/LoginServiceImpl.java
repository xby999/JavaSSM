package com.qianfeng.service.impl;

import com.qianfeng.dao.LoginPassDao;
import com.qianfeng.dao.LoginUserDao;
import com.qianfeng.pojo.LoginPass;
import com.qianfeng.pojo.LoginUser;
import com.qianfeng.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl  implements LoginService {



    @Autowired
    LoginPassDao loginPassDao;

    @Autowired
    LoginUserDao loginUserDao;
    /**
     * 接收定用户名,密码，
     * 处理数据
     * 返回数据到map
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> login(Map<String, Object> map, HttpServletRequest requset) {

        Map<String,Object> returnmap=new HashMap<>();

        String login_user_name = (String) map.get("login_user_name");
        String login_pass_word =(String) map.get("login_pass_word");

        List<LoginUser> list=loginUserDao.selectByUsername(login_user_name);
        int re = list.size();
        if(re>0) //有人，判断密码
        {
            LoginUser loginUser= list.get(0);
            Map<String,Object> paramap=new HashMap<>();
            paramap.put("login_pass_word",login_pass_word);
            paramap.put("login_user_id",loginUser.getLogin_user_id());
           List<LoginPass> loginPasses= loginPassDao.selectByPasswordAndUserId(paramap);

           int len2=loginPasses.size();
           if(len2>0) //登录成功
           {
               //============start==============
               returnmap.put("result",true);
               //1 将在session空间张保存一份角色类型
               HttpSession session=requset.getSession();
               session.setAttribute("roleType","1");
               //2 在session空间中保存一份用户相关信息（LoginUser）
                session.setAttribute("loginUser",loginUser);
               //=============end==============
           }else{ //登录失败
               returnmap.put("result",false);
               returnmap.put("msg","密码错误");
           }
        }else //没有人，返回结果
        {
            returnmap.put("result",false);
            returnmap.put("msg","用户不存在");
        }

       return returnmap;
    }
}