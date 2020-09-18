package com.qianfeng.dao;

import com.qianfeng.pojo.Audio;

import java.util.List;
import java.util.Map;

public interface AudioDao {

    //============管理员模块===============start=============
    List<Audio> selectallaudioinfo();

    List<Audio> selectbyusernameanddate(Map<String,Object> map);

    /**管理员查看删除的音频**/
    List<Audio> selectDeleteAudioInfo();

    int adminrebackAudioByID(int audio_id);
    //============管理员模块===============end============

    //============用户模块===============start=============
    /**
     * 上传音频功能
     * @param audio
     * @return
     */
    int insertAudio(Audio audio);

    List<Audio> selectAudioInfoByID(int business_id);

    /**
     * 删除音频
     * @param business_id
     * @return
     */
    int deleteAudioByID(int business_id);

    /**
     * 显示已删除音频的信息
     * @param business_id
     * @return
     */
    List<Audio> selectDeleteAudioInfoByID(int business_id);

    /**
     * 还原音频
     * @param audio_id
     * @return
     */
    int rebackAudioByID(int audio_id);
}
