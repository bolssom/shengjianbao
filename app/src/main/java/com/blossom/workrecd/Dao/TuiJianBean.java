package com.blossom.workrecd.Dao;

import java.util.List;

/**
 * Created by zxw on 2016/1/13.
 */
public class TuiJianBean {
    public int totalRecord;
    public List<JianZhiBean> data;
    String map;

    public TuiJianBean(int totalRecord, List<JianZhiBean> data, String map) {
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

    public List<JianZhiBean> getData() {
        return data;
    }

    public void setData(List<JianZhiBean> data) {
        this.data = data;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
