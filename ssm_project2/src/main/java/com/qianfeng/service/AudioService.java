package com.qianfeng.service;

import com.qianfeng.pojo.Audio;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface AudioService {

    //============管理员模块===============start=============

    /**
     * （管理员）查看所有用户的音频
     * @return
     */
    List<Audio> getAllAudioInfo();

    /**
     * （管理员）查找用户的音频
     * @param map
     * @param request
     * @return
     * @throws ParseException
     */
    List<Audio> getselectaudio(Map<String,Object> map, HttpServletRequest request) throws ParseException;

    /**
     * （管理员）删除用户音频
     * @return
     */
    List<Audio> selectDeleteAudioInfo();

    /**
     * （管理员）还原用户音频
     * @param audio_id
     * @return
     */
    boolean adminrebackAudioByID(int audio_id);

    //============管理员模块===============end=============

    //============用户模块===============start=============
    boolean upload(Audio audio, MultipartFile multipartFile, HttpServletRequest request) throws IOException;

    List<Audio> getAudioInfoByID(int business_id);

    boolean deleteAudioByID(int business_id);

    List<Audio> getDeleteAudioInfoByID(int business_id);

    boolean rebackAudioByID(int audio_id);

}
