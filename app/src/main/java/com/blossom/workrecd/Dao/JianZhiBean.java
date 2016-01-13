package com.blossom.workrecd.Dao;

/**
 * Created by zxw on 2015/12/16.
 */
public class JianZhiBean {
    public String recruitTitle;//标题
    public String recruitCode;// 编号
    public String  timeType; // 结算类型（10日结  20时结）
    public String  addrCode; //地区编号
    public  String moneyStandard;   //金额
    public String  dateBegin;        //开始时间


    public JianZhiBean() {
    }

    public String getRecruitTitle() {
        return recruitTitle;
    }

    public void setRecruitTitle(String recruitTitle) {
        this.recruitTitle = recruitTitle;
    }

    public String getRecruitCode() {
        return recruitCode;
    }

    public void setRecruitCode(String recruitCode) {
        this.recruitCode = recruitCode;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public String getAddrCode() {
        return addrCode;
    }

    public void setAddrCode(String addrCode) {
        this.addrCode = addrCode;
    }

    public String getMoneyStandard() {
        return moneyStandard;
    }

    public void setMoneyStandard(String moneyStandard) {
        this.moneyStandard = moneyStandard;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    @Override
    public String toString() {
        return "JianZhiBean{" +
                "recruitTitle='" + recruitTitle + '\'' +
                ", recruitCode='" + recruitCode + '\'' +
                ", timeType='" + timeType + '\'' +
                ", addrCode='" + addrCode + '\'' +
                ", moneyStandard='" + moneyStandard + '\'' +
                ", dateBegin='" + dateBegin + '\'' +
                '}';
    }
}


