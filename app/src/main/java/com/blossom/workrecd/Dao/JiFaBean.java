package com.blossom.workrecd.Dao;

import java.util.List;

/**
 * Created by zxw on 2015/12/21.
 */
public class JiFaBean {
    public int status;
    public List<JFC> data;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<JFC> getData() {
        return data;
    }

    public void setData(List<JFC> data) {
        this.data = data;
    }

    public JiFaBean(int status, List<JFC> data) {
        this.status = status;
        this.data = data;
    }

    @Override
    public String toString() {
        return "JiFaBean{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
