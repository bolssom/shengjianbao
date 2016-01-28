package com.blossom.workrecd.Dao;

/**
 * Created by zxw on 2016/1/28.
 */
public class LoginBean {
   private String  error;
    private String success;
    private String result;
    private UserInfoBean entity;

    public LoginBean() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public UserInfoBean getEntity() {
        return entity;
    }

    public void setEntity(UserInfoBean entity) {
        this.entity = entity;
    }
}
