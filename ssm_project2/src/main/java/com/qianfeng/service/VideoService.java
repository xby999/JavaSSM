package com.qianfeng.service;

import com.qianfeng.pojo.Audio;
import com.qianfeng.pojo.SystemUserAndUsername;
import com.qianfeng.pojo.Video;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Service
public interface VideoService  {

    //============管理员模块===============start=============
    /**
     * （管理员）查看所有用户的视频
     * @return
     */
    List<Video> getAllVideoInfo();

    /**
     * (管理员)视频查找功能
     * @param map
     * @param request
     * @return
     * @throws ParseException
     */
    List<Video> getselectvideo(Map<String,Object> map, HttpServletRequest request) throws ParseException;

    /**
     * （管理员）视频回收站
     * @return
     */
    List<Video> selectDeleteVideoInfo();

    /**
     * （管理员）还原视频
     * @param video_id
     * @return
     */
    boolean adminrebackVideoByID(int video_id);

    //============管理员模块===============end=============

    boolean upload(Video video, MultipartFile multipartFile, HttpServletRequest request) throws IOException;


    List<Video> getVideoAllInfoByID(int business_id);

    boolean deleteVideoByID(int video_id);

    List<Video> selectDeleteVideoInfoByID(int business_id);

    boolean rebackVideoByID(int video_id);
}
