package com.qianfeng.controller;

import com.qianfeng.pojo.*;
import com.qianfeng.service.VideoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/VideoController")
public class VideoController {

    @Autowired
    VideoService videoService;

    //============管理员模块===============start=============
    /**
     * （管理员）查看所有用户的视频
     * @param request
     * @return
     */
    @RequestMapping("/getAllVideoInfo")
    public String getALLVideoInfo(HttpServletRequest request){
        List<Video> list = videoService.getAllVideoInfo();
        request.setAttribute("admin_list",list);
        return "../page/video/admin_query_video.jsp";
    }

    /**
     * (管理员)视频查找功能
     * @param business_username
     * @param video_start_date
     * @param video_end_date
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping("/getselectvideo")
    public String getselectvideo(String business_username, String video_start_date,String video_end_date,  HttpServletRequest request) throws ParseException {

        Map<String,Object> returnmap=new HashMap<>();
        Map<String, Object> map1=new HashMap<>();

        map1.put("business_username",business_username);
        map1.put("video_start_date",video_start_date);
        map1.put("video_end_date",video_end_date);
        List<Video> list1=videoService.getselectvideo(map1,request);
        request.setAttribute("admin_list",list1);
        return "../page/video/admin_query_video.jsp";

    }

    /**
     * （管理员）视频回收站
     * @param request
     * @return
     */
    @RequestMapping("/admingetDeleteVideoInfo")
    public String getDeleteVideoInfo(HttpServletRequest request)
    {
        List<Video> list=videoService.selectDeleteVideoInfo();
        request.setAttribute("adime_delete_video_list",list);
        return "../page/admin_recycle_bin/admin_video.jsp";
    }

    /**
     * （管理员删除视频）
     * @param video_id
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/adimeDeleteVideo",method = {RequestMethod.POST,RequestMethod.GET})
    public String adimeDeleteVideo(@RequestParam(value = "video_id",required = true)Integer video_id,HttpServletRequest request) throws Exception
    {
        boolean b=videoService.deleteVideoByID(video_id);
        if(b){
            request.setAttribute("msg","删除成功");
        }else{
            request.setAttribute("msg","删除失败");
        }

        List<Video> list =videoService.getAllVideoInfo();
        request.setAttribute("admin_list",list);
        return "../page/video/admin_query_video.jsp";
    }

    /**
     * （管理员）还原视频
     * @param video_id
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/adminrebackVideo",method = {RequestMethod.POST,RequestMethod.GET})
    public String adminrebackVideo(@RequestParam(value = "video_id",required = true)Integer video_id,HttpServletRequest request) throws Exception
    {
        boolean b=videoService.adminrebackVideoByID(video_id);
        if(b){
            request.setAttribute("msg","还原成功");
        }else{
            request.setAttribute("msg","还原失败");
        }

        List<Video> list=videoService.selectDeleteVideoInfo();
        request.setAttribute("adime_delete_video_list",list);
        return "../page/admin_recycle_bin/admin_video.jsp";
    }
    //===================管理员模块=============end==================




    @RequestMapping("/uploadVideo")
    public String uploadVideo(Video video, @RequestParam("VideoFile") MultipartFile multipartFile, HttpServletRequest request){
        boolean result = false;
        //1 执行上传功能
        try{
            result=videoService.upload(video,multipartFile,request);
        }catch (IOException e) {
            e.printStackTrace();
        }
        //处理反馈数据
        if (result){
            return "../page/video/addVideo.jsp";
        }else{
            return null;
        }
    }

    @RequestMapping("/getVideoAllInfo")
    public String getVideoAllInfo(HttpServletRequest request){
        HttpSession session=request.getSession();
        int business_id=((Business)session.getAttribute("business")).getBusiness_id();
        List<Video> list =videoService.getVideoAllInfoByID(business_id);
        request.setAttribute("videolist",list);
        return "../page/video/query_Video.jsp";
    }

    @RequestMapping(value = "/deleteVideo",method = {RequestMethod.POST,RequestMethod.GET})
    public String deleteVideo(@RequestParam(value = "video_id",required = true)Integer video_id,HttpServletRequest request) throws Exception
    {
        boolean b=videoService.deleteVideoByID(video_id);
        if(b){
            request.setAttribute("msg","删除成功");
        }else{
            request.setAttribute("msg","删除失败");
        }
        HttpSession session=request.getSession();
        int business_id=((Business)session.getAttribute("business")).getBusiness_id();
        List<Video> list =videoService.getVideoAllInfoByID(business_id);
        request.setAttribute("videolist",list);
        return "../page/video/query_Video.jsp";
    }

    @RequestMapping("/getDeleteVideoInfoByID")
    public String getDeleteVideoInfoByID(HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        int business_id=((Business)session.getAttribute("business")).getBusiness_id();
        List<Video> list=videoService.selectDeleteVideoInfoByID(business_id);
        request.setAttribute("delete_videolist",list);
        return "../page/recycle_bin/video.jsp";
    }

    @RequestMapping(value = "/rebackVideo",method = {RequestMethod.POST,RequestMethod.GET})
    public String rebackVideo(@RequestParam(value = "video_id",required = true)Integer video_id,HttpServletRequest request) throws Exception
    {
        boolean b=videoService.rebackVideoByID(video_id);
        if(b){
            request.setAttribute("msg","还原成功");
        }else{
            request.setAttribute("msg","还原失败");
        }
        HttpSession session=request.getSession();
        int business_id=((Business)session.getAttribute("business")).getBusiness_id();
        List<Video> list=videoService.selectDeleteVideoInfoByID(business_id);
        request.setAttribute("delete_videolist",list);
        return "../page/recycle_bin/video.jsp";
    }

}