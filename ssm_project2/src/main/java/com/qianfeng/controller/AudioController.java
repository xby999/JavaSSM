package com.qianfeng.controller;

import com.qianfeng.pojo.Audio;
import com.qianfeng.pojo.Business;
import com.qianfeng.service.AudioService;
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
@RequestMapping("/AudioController")
public class AudioController {

    @Autowired
    AudioService audioService;

    //============管理员模块===============start=============

    /**
     * （管理员）查看所有用户的音频
     * @param request
     * @return
     */
    @RequestMapping("/getAllAudioInfo")
    public String getALLAudioInfo(HttpServletRequest request){
        List<Audio> list = audioService.getAllAudioInfo();
        request.setAttribute("list",list);
        return "../page/audio/admin_query_audio.jsp";
    }

    /**
     * （管理员）查找用户音频
     * @param business_username
     * @param audio_start_date
     * @param audio_end_date
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping("/getselectaudio")
    public String getselectaudio(String business_username, String audio_start_date,String audio_end_date,  HttpServletRequest request) throws ParseException {
        Map<String,Object> returnmap=new HashMap<>();
        Map<String, Object> map1=new HashMap<>();

        map1.put("business_username",business_username);
        map1.put("audio_start_date",audio_start_date);
        map1.put("audio_end_date",audio_end_date);
        List<Audio> list1=audioService.getselectaudio(map1,request);
        int len=list1.size();
        if(len<0){
            return "../page/audio/admin_search_audio.jsp";
        }
        request.setAttribute("list",list1);
        return "../page/audio/admin_query_audio.jsp";
    }

    /**
     * （管理员）删除用户音频
     * @param audio_id
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/admindeleteAudio",method = {RequestMethod.POST,RequestMethod.GET})
    public String admindeleteAudio(@RequestParam(value = "audio_id",required = true)Integer audio_id, HttpServletRequest request) throws Exception
    {
        System.out.println(audio_id);
        boolean b=audioService.deleteAudioByID(audio_id);
        if(b){
            request.setAttribute("msg","删除成功");
        }else{
            request.setAttribute("msg","删除失败");
        }

        List<Audio> list =audioService.getAllAudioInfo();
        request.setAttribute("list",list);
        return "../page/audio/admin_query_audio.jsp";
    }

    /**
     * （管理员）音频回收站
     * @param request
     * @return
     */
    @RequestMapping("/admingetDeleteAudioInfo")
    public String getDeleteVideoInfoByID(HttpServletRequest request)
    {
        List<Audio> list=audioService.selectDeleteAudioInfo();
        request.setAttribute("delete_audiolist",list);
        return "../page/admin_recycle_bin/admin_audio.jsp";
    }

    /**
     * （管理员）还原音频
     * @param audio_id
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/adminrebackAudio",method = {RequestMethod.POST,RequestMethod.GET})
    public String adminrebackAudio(@RequestParam(value = "audio_id",required = true)Integer audio_id,HttpServletRequest request) throws Exception
    {
        boolean b=audioService.adminrebackAudioByID(audio_id);
        if(b){
            request.setAttribute("msg","还原成功");
        }else{
            request.setAttribute("msg","还原失败");
        }

        List<Audio> list=audioService.selectDeleteAudioInfo();
        request.setAttribute("delete_audiolist",list);
        return "../page/admin_recycle_bin/admin_audio.jsp";
    }

    //============管理员模块===============end=============


    //============用户模块===============start=============
    @RequestMapping("/uploadAudio")
    public String uploadAudio(Audio audio, @RequestParam("AudioFile") MultipartFile multipartFile, HttpServletRequest request){
        boolean result = false;
        //1 执行上传功能
        try{
            result=audioService.upload(audio,multipartFile,request);
        }catch (IOException e) {
            e.printStackTrace();
        }
        //处理反馈数据
        if (result){
            return "../page/audio/addAudio.jsp";
        }else{
            return null;
        }
    }

    @RequestMapping("/getAudioInfo")
    public String getAudioInfo(HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        int business_id=((Business)session.getAttribute("business")).getBusiness_id();
        List<Audio> list=audioService.getAudioInfoByID(business_id);
        request.setAttribute("audiolist",list);
        return "../page/audio/query_Audio.jsp";
    }

    @RequestMapping(value = "/deleteAudio",method = {RequestMethod.POST,RequestMethod.GET})
    public String deleteAudio(@RequestParam(value = "audio_id",required = true)Integer audio_id,HttpServletRequest request) throws Exception
    {
        boolean b=audioService.deleteAudioByID(audio_id);
        if(b){
            request.setAttribute("msg","删除成功");
        }else{
            request.setAttribute("msg","删除失败");
        }
        HttpSession session=request.getSession();
        int business_id=((Business)session.getAttribute("business")).getBusiness_id();
        List<Audio> list=audioService.getAudioInfoByID(business_id);
        request.setAttribute("audiolist",list);
        return "../page/audio/query_Audio.jsp";
    }




    @RequestMapping("/getDeleteAudioInfoByID")
    public String getDeleteAudioInfoByID(HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        int business_id=((Business)session.getAttribute("business")).getBusiness_id();
        List<Audio> list=audioService.getDeleteAudioInfoByID(business_id);
        request.setAttribute("delete_audiolist",list);
        return "../page/recycle_bin/audio.jsp";
    }

    @RequestMapping(value = "/rebackAudio",method = {RequestMethod.POST,RequestMethod.GET})
    public String rebackAudio(@RequestParam(value = "audio_id",required = true)Integer audio_id,HttpServletRequest request) throws Exception
    {
        boolean b=audioService.rebackAudioByID(audio_id);
        if(b){
            request.setAttribute("msg","还原成功");
        }else{
            request.setAttribute("msg","还原失败");
        }
        HttpSession session=request.getSession();
        int business_id=((Business)session.getAttribute("business")).getBusiness_id();
        List<Audio> list=audioService.getDeleteAudioInfoByID(business_id);
        request.setAttribute("delete_audiolist",list);
        return "../page/recycle_bin/audio.jsp";
    }
}
