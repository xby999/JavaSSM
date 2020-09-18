package com.qianfeng.pojo;

import java.util.Date;

public class Deletefile {
    private int delete_id;
    private String delete_title;
    private Date delete_date;
    private int audio_id;
    private int video_id;

    public int getDelete_id() {
        return delete_id;
    }

    public void setDelete_id(int delete_id) {
        this.delete_id = delete_id;
    }

    public String getDelete_title() {
        return delete_title;
    }

    public void setDelete_title(String delete_title) {
        this.delete_title = delete_title;
    }

    public Date getDelete_date() {
        return delete_date;
    }

    public void setDelete_date(Date delete_date) {
        this.delete_date = delete_date;
    }

    public int getAudio_id() {
        return audio_id;
    }

    public void setAudio_id(int audio_id) {
        this.audio_id = audio_id;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }
}
