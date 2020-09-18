package com.qianfeng.service.impl;

import com.qianfeng.dao.AudioDao;
import com.qianfeng.pojo.Audio;
import com.qianfeng.pojo.Business;
import com.qianfeng.service.AudioService;
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
public class AudioServiceImpl implements AudioService {

    @Autowired
    AudioDao audioDao;

    //============管理员模块===============start=============
    @Override
    public List<Audio> getAllAudioInfo() {
        return audioDao.selectallaudioinfo();
    }

    @Override
    public List<Audio> getselectaudio(Map<String, Object> map, HttpServletRequest request)  {
        Map<String,Object> parammap = new HashMap<>();
        String business_username=(String)map.get("business_username");
        String audio_start_date=(String)map.get("audio_start_date");
        String audio_end_date=(String)map.get("audio_end_date");
        parammap.put("audio_end_date",audio_end_date);
        parammap.put("business_username",business_username);
        parammap.put("audio_start_date",audio_start_date);
        List<Audio> list=audioDao.selectbyusernameanddate(parammap);
        return  list;
    }

    @Override
    public List<Audio> selectDeleteAudioInfo() {
        return audioDao.selectDeleteAudioInfo();
    }

    @Override
    public boolean adminrebackAudioByID(int audio_id) {
        int res=audioDao.adminrebackAudioByID(audio_id);
        if(res>0)
            return true;
        else
            return false;
    }
    //============管理员模块===============end=============

    //============用户模块===============start=============
    /**
     * 实现音频上传
     * @param audio
     * @param multipartFile
     * @param request
     * @return
     * @throws IOException
     */
    @Override
    public boolean upload(Audio audio, MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        //===========文件上传============start=======================
        //1 设置当前的文件放在哪一个路径，（全路径：路径+文件名.扩展名）定义成File
        //（1.1）获取项目的根目录
        String projectPath = request.getServletContext().getRealPath("");
        //（1.2）设置文件的全路径
        String filePath = projectPath+"/audio/"+multipartFile.getOriginalFilename();
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
        audio.setAudio_src("/audio/"+multipartFile.getOriginalFilename());
        audio.setBusiness_id(business.getBusiness_id());
        //1 获取对应dao层
        int res=audioDao.insertAudio(audio);
        //2 带着相关参数执行数据库方法，返回结果即可
        if(res>0){
            return true;
        }else{
            return false;
        }
        //======================end========================
    }

    @Override
    public List<Audio> getAudioInfoByID(int business_id) {
       return  audioDao.selectAudioInfoByID(business_id);
    }

    @Override
    public boolean deleteAudioByID(int business_id){
        int res=audioDao.deleteAudioByID(business_id);
        if(res>0)
            return true;
        else
            return false;
    }

    @Override
    public List<Audio> getDeleteAudioInfoByID(int business_id) {
        return audioDao.selectDeleteAudioInfoByID(business_id);
    }

    @Override
    public boolean rebackAudioByID(int audio_id) {
       int res=audioDao.rebackAudioByID(audio_id);
        if(res>0)
            return true;
        else
            return false;
    }

}
