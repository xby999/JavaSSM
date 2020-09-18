package com.qianfeng.controller;

import com.qianfeng.dao.BusinessDao;
import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.Businessinfo;
import com.qianfeng.service.BusinessInfoService;
import com.qianfeng.service.BusinessLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/BusinessInfoController")
public class BusinessInfoController {

    @Autowired
    BusinessInfoService businessInfoService;

    @Autowired
    BusinessLoginService businessLoginService;

    @RequestMapping("/getBusinessInfoByID")
    @ResponseBody
    public Businessinfo getBusinessInfoByID(HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        int business_id=((Business)session.getAttribute("business")).getBusiness_id();
        return businessInfoService.selectBusinessInfoByID(business_id);
    }

    @RequestMapping("/updateBusinessInfo")
    public String updateBusinessInfo(Businessinfo businessinfo,HttpServletRequest request)
    {
        String business_username=request.getParameter("business_username");
        boolean a=businessInfoService.selectIdByName(business_username);
        boolean b;

        if(a){
            b=businessInfoService.updateBusinessInfo(businessinfo,request);
            if(b){
                request.setAttribute("msg","修改成功");
            }else{
                request.setAttribute("msg","修改失败");
            }
        }else{
            request.setAttribute("msg","登录名已被注册,请重新输入");
        }
        return "../page/business/modifyBusinessoper.jsp";
    }

}
