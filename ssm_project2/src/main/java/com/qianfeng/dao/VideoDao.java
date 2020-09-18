package com.qianfeng.dao;

import com.qianfeng.pojo.Video;

import java.util.List;
import java.util.Map;

public interface VideoDao {
    //============管理员模块===============start=============
    /**
     * （管理员）查看所有用户的视频
     * @return
     */
    List<Video> selectallvideoinfo();

    /**
     * (管理员)视频查找功能
     * @param map
     * @return
     */
    List<Video> selectbyusernameanddate(Map<String,Object> map);

    /**管理员查看删除的视频**/
    List<Video> selectDeleteVideoInfo();

    /**
     * （管理员）还原视频
     * @param video_id
     * @return
     */
    int adminrebackVideoByID(int video_id);
    //============管理员模块===============end=============

    //============用户模块===============start=============
    /**
     * 用户查看自己所上传的视频
     * @param business_id
     * @return
     */
    List<Video> selectVieoAllInfoByID(int business_id);

    /**
     * 插入视频相关信息
     * @param video
     * @return
     */
    int insertVideo(Video video);

    /**
     * 删除视频
     * @param video_id
     * @return
     */
    int deleteVideoByID(int video_id);

    /**
     * 显示已删除视频的信息
     * @param business_id
     * @return
     */
    List<Video> selectDeleteVideoInfoByID(int business_id);

    /**
     * 还原视频
     * @param video_id
     * @return
     */
    int rebackVideoByID(int video_id);
}
