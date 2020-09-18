package com.qianfeng.service;

import com.qianfeng.pojo.Businessinfo;

import javax.servlet.http.HttpServletRequest;

public interface BusinessInfoService {

    Businessinfo selectBusinessInfoByID(int business_id);

    boolean updateBusinessInfo(Businessinfo businessinfo, HttpServletRequest request);

    boolean selectIdByName(String business_username);
}
