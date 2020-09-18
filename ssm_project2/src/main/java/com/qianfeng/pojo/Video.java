package com.qianfeng.pojo;

import java.util.Date;

public class Video {
    private int video_id;
    private String video_title;
    private String video_src;
    private Date video_date;
    private int business_id;
    private String business_username;
    private String video_flag;
    private Date video_delete_date;

    public String getVideo_flag() {
        return video_flag;
    }

    public void setVideo_flag(String video_flag) {
        this.video_flag = video_flag;
    }

    public Date getVideo_delete_date() {
        return video_delete_date;
    }

    public void setVideo_delete_date(Date video_delete_date) {
        this.video_delete_date = video_delete_date;
    }

    public String getBusiness_username() {
        return business_username;
    }

    public void setBusiness_username(String business_username) {
        this.business_username = business_username;
    }



    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getVideo_src() {
        return video_src;
    }

    public void setVideo_src(String video_src) {
        this.video_src = video_src;
    }

    public Date getVideo_date() {
        return video_date;
    }

    public void setVideo_date(Date video_date) {
        this.video_date = video_date;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }



}
