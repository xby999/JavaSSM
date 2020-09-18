package com.qianfeng.service.impl;

import com.qianfeng.dao.BusinessDao;
import com.qianfeng.dao.BusinessinfoDao;
import com.qianfeng.pojo.*;
import com.qianfeng.service.BusinessInfoService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class BusinessInfoServiceImpl implements BusinessInfoService {

    @Autowired
    BusinessinfoDao businessinfoDao;

    @Autowired
    BusinessDao businessDao;

    @Override
    public Businessinfo selectBusinessInfoByID(int business_id) {
        return businessinfoDao.selectBusinessInfoByID(business_id);
    }

    @Override
    public boolean updateBusinessInfo(Businessinfo businessinfo, HttpServletRequest request) {
        //0 获取session
        int business_id=((Business)request.getSession().getAttribute("business")).getBusiness_id();
        //1 修改个人信息
        Businessinfo businessinfo1=new Businessinfo();
        businessinfo1.setBusiness_id(business_id);
        businessinfo1.setBusiness_username(businessinfo.getBusiness_username());
        businessinfo1.setBusiness_info_name(businessinfo.getBusiness_info_name());
        businessinfo1.setBusiness_info_legal_person(businessinfo.getBusiness_info_legal_person());
        businessinfo1.setBusiness_info_legal_person_tel(businessinfo.getBusiness_info_legal_person_tel());
        businessinfo1.setBusiness_pass_word(businessinfo.getBusiness_pass_word());
        int res=businessinfoDao.updateAllData(businessinfo1);
        if(res>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean selectIdByName(String business_username) {
        Business business = businessDao.selectByUsername(business_username);
        if(business != null)
            return false;
        else
            return true;
    }


}
