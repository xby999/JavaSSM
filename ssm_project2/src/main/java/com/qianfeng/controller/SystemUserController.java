package com.qianfeng.controller;

import com.qianfeng.pojo.Businessinfo;
import com.qianfeng.pojo.LoginUser;
import com.qianfeng.pojo.SystemUser;
import com.qianfeng.pojo.SystemUserAndUsername;
import com.qianfeng.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/SystemUserController")
public class SystemUserController {

    @Autowired
    SystemUserService systemUserService;

    @RequestMapping("/getBusinessUserAllInfo")
    public String getBusinessUserAllInfo(HttpServletRequest request){
        List<Businessinfo> list = systemUserService.getBusinessUserAllInfo();
        request.setAttribute("list",list);
        return "../page/business/businessOper.jsp";
    }

    @RequestMapping("/getSystemUserAllInfo")
    public String getSystemUserAllInfo(HttpServletRequest request){
        List<SystemUserAndUsername> list = systemUserService.getSystemUserAllInfo();
        request.setAttribute("list",list);
        return "../page/system/systemoper.jsp";
    }

    @RequestMapping("/getSystemUserByID")
    @ResponseBody
    public SystemUserAndUsername getSystemUserByID(HttpServletRequest request) {
        HttpSession session=request.getSession();
        int login_user_id=((LoginUser)session.getAttribute("loginUser")).getLogin_user_id();
        return systemUserService.selectSystemUserByID(login_user_id);
   }

    @RequestMapping("/updateSystemUser")
    public String updateSystemUser(SystemUserAndUsername systemUserAndUsername,HttpServletRequest request)
    {
        String login_user_name=request.getParameter("login_user_name");
        boolean a=systemUserService.selectIdByName(login_user_name);

        if(a){
            boolean b=systemUserService.updateSystemUser(systemUserAndUsername,request);
            if (b){
                request.setAttribute("msg","修改成功");
            }else {
                request.setAttribute("msg","修改失败");
            }
        }else{
            request.setAttribute("msg","登录名已被使用,请重新输入");
        }
        return "../page/system/addSystemoper.jsp";
    }
}
