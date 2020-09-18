package com.qianfeng.service.impl;

import com.qianfeng.dao.VideoDao;
import com.qianfeng.pojo.Audio;
import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.Video;
import com.qianfeng.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoDao videoDao;

    //============管理员模块===============start=============
    /**
     * （管理员）查看所有用户的视频
     * @return
     */
    @Override
    public List<Video> getAllVideoInfo() {
        return videoDao.selectallvideoinfo();
    }

    /**
     * (管理员)视频查找功能
     * @param map
     * @param request
     * @return
     */
    @Override
    public List<Video> getselectvideo(Map<String, Object> map, HttpServletRequest request)  {
        Map<String,Object> parammap = new HashMap<>();
        String business_username=(String)map.get("business_username");
        String video_start_date=(String)map.get("video_start_date");
        String video_end_date=(String)map.get("video_end_date");
        parammap.put("video_end_date",video_end_date);
        parammap.put("business_username",business_username);
        parammap.put("video_start_date",video_start_date);
        List<Video> list=videoDao.selectbyusernameanddate(parammap);
        return  list;
    }

    /**
     * （管理员）视频回收站
     * @return
     */
    @Override
    public List<Video> selectDeleteVideoInfo() {
        return videoDao.selectDeleteVideoInfo();
    }

    /**
     * （管理员）还原视频
     * @param video_id
     * @return
     */
    @Override
    public boolean adminrebackVideoByID(int video_id) {
        int res=videoDao.adminrebackVideoByID(video_id);
        if(res>0)
            return true;
        else
            return false;
    }
    //============管理员模块===============end=============


    //================用户模块============start==============
    /**
     * 实现视频快传
     * @param video
     * @param multipartFile
     * @param request
     * @return
     */
    @Override
    public boolean upload(Video video, MultipartFile multipartFile, HttpServletRequest request)throws IOException {
        //===========文件上传============start=======================
        //1 设置当前的文件放在哪一个路径，（全路径：路径+文件名.扩展名）定义成File
        //（1.1）获取项目的根目录
        String projectPath = request.getServletContext().getRealPath("");
        //（1.2）设置文件的全路径
        String filePath = projectPath+"/video/"+multipartFile.getOriginalFilename();
        //（1.3）创建file对象
        File file = new File(filePath);

        //2 判断路径是否存在，如果不存在则创建对应的父路径
        File fileParentFile = file.getParentFile();
        if (!fileParentFile.exists()){
            fileParentFile.mkdirs();
        }

        //3 创建文件（路径+文件名.扩展名）空文件
        if (!file.exists()){
            file.createNewFile();
        }
        System.out.println(file+"========================");

        //4 转移文件
        multipartFile.transferTo(new File(filePath));
        //========================end======================


        //============数据保存===========start=======================
        Business business=(Business) request.getSession().getAttribute("business");
        //获取数据
        video.setVideo_src("/video/"+multipartFile.getOriginalFilename());
        video.setBusiness_id(business.getBusiness_id());
        //1 获取对应dao层
        int res=videoDao.insertVideo(video);
        //2 带着相关参数执行数据库方法，返回结果即可
        if(res>0){
            return true;
        }else{
            return false;
        }
        //======================end========================
    }

    @Override
    public List<Video> getVideoAllInfoByID(int business_id) {
        return videoDao.selectVieoAllInfoByID(business_id);
    }

    @Override
    public boolean deleteVideoByID(int video_id) {
        int res=videoDao.deleteVideoByID(video_id);
        if(res>0)
            return true;
        else
            return false;
    }

    @Override
    public List<Video> selectDeleteVideoInfoByID(int business_id) {
        return videoDao.selectDeleteVideoInfoByID(business_id);
    }

    @Override
    public boolean rebackVideoByID(int video_id) {
        int res=videoDao.rebackVideoByID(video_id);
        if(res>0)
            return true;
        else
            return false;
    }
    //================用户模块============end==============

}