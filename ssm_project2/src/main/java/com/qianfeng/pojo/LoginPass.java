package com.qianfeng.pojo;

public class LoginPass {
    /*
    * 登录密码id
    * 登录密码
    * */
    private int login_pass_id;
    private String login_pass_word;
    private int login_user_id; /*外键*/

    public int getLogin_user_id() {
        return login_user_id;
    }

    public void setLogin_user_id(int login_user_id) {
        this.login_user_id = login_user_id;
    }



    public int getLogin_pass_id() {
        return login_pass_id;
    }

    public void setLogin_pass_id(int login_pass_id) {
        this.login_pass_id = login_pass_id;
    }

    public String getLogin_pass_word() {
        return login_pass_word;
    }

    public void setLogin_pass_word(String login_pass_word) {
        this.login_pass_word = login_pass_word;
    }
}
