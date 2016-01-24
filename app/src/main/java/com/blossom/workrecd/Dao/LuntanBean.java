package com.blossom.workrecd.Dao;

import java.util.List;

/**
 * Created by zxw on 2016/1/23.
 */
public class LuntanBean {
    public int totalRecord;
    public List<UserBean> data;
    String map;

    public LuntanBean(int totalRecord, List<UserBean> data, String map) {
        this.totalRecord = totalRecord;
        this.data = data;
        this.map = map;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<UserBean> getData() {
        return data;
    }

    public void setData(List<UserBean> data) {
        this.data = data;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
