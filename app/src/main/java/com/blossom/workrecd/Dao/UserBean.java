package com.blossom.workrecd.Dao;

/**
 * Created by zxw on 2016/1/23.
 */
public class UserBean {
    String userName;  //用户名
    String sex;      // 性别0女  1男
    String fromSchool; // 毕业学校
    String dateAdd;    //发布时间
    String userCode;    //用户编号
    String articleContent;  //内容
    String praiseNum;       //点赞数量
    String shareNum;        //分享数量
    String evaluateNum;    // 评论数量
    String code;          //编号
    String logo;        //头像

    public UserBean() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFromSchool() {
        return fromSchool;
    }

    public void setFromSchool(String fromSchool) {
        this.fromSchool = fromSchool;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(String praiseNum) {
        this.praiseNum = praiseNum;
    }

    public String getShareNum() {
        return shareNum;
    }

    public void setShareNum(String shareNum) {
        this.shareNum = shareNum;
    }

    public String getEvaluateNum() {
        return evaluateNum;
    }

    public void setEvaluateNum(String evaluateNum) {
        this.evaluateNum = evaluateNum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "username='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", fromSchool='" + fromSchool + '\'' +
                ", dateAdd='" + dateAdd + '\'' +
                ", userCode='" + userCode + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", praiseNum='" + praiseNum + '\'' +
                ", shareNum='" + shareNum + '\'' +
                ", evaluateNum='" + evaluateNum + '\'' +
                ", code='" + code + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
