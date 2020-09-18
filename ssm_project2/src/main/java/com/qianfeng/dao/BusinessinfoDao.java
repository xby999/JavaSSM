package com.qianfeng.dao;

import com.qianfeng.pojo.Businessinfo;

public interface BusinessinfoDao {

/*    insert into businessinfo (business_id) values (#{business_id});*/

    //插入商家信息
    int insertBusinessInfo(int business_id);

    //根据id查询用hu信息
    Businessinfo selectBusinessInfoByID(int business_id);

    //更新用户数据
    int updateAllData(Businessinfo businessinfo);

}
