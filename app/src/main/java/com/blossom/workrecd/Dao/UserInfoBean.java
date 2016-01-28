package com.blossom.workrecd.Dao;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zxw on 2016/1/28.
 */
public class UserInfoBean {
    private String userCode; 			// 用户编号
    private String userName; 			// 用户名
    private String password; 			// 密码
    private int userSex; 				// 性别
    private int userAge; 				//年龄
    private String userPhoto; 			// 用户头像(商家logo)
    private String realName; 			// 真实姓名
    private String userIdcard; 			// 身份证号
    private Date userBirthday; 			//生日
    private int addrCode; 				// 地区编号
    private String addrDetail; 			// 地址详细
    private String tel;					// 手机号
    private String userPhone;			// 公司固话/个人固话
    private String email; 				// 邮箱
    private int userExperience; 		//累计经验
    private int userIntegration; 		//累计积分
    private int userCredit; 				//累计信用
    private int userVerify; 				//身份证认证（0，未认证；1，已认证）
    private int infoComplete; 		//资料是否完善（0，未完善；1，已完善）
    private String userIntroduce; 		//用户简介
    private String userCoordinate; 		//用户坐标
    private String fromSchool; 			// 所在学校
    private String fromCollege; 		// 所在学院
    private String fromMajor; 			// 所在专业
    private Date schoolTime; 			// 入学时间
    private double userHeight; 			//用户身高（单位cm）
    private double userWeight; 			//用户体重（单位斤）
    private String userStandard; 		//用户三围
    private int businessLicense; 		//许可证认证（0，未认证；1，已认证）
    private BigDecimal depositMoney=new BigDecimal(0.00); 	//保证金

    public UserInfoBean() {
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserIdcard() {
        return userIdcard;
    }

    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public int getAddrCode() {
        return addrCode;
    }

    public void setAddrCode(int addrCode) {
        this.addrCode = addrCode;
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserExperience() {
        return userExperience;
    }

    public void setUserExperience(int userExperience) {
        this.userExperience = userExperience;
    }

    public int getUserIntegration() {
        return userIntegration;
    }

    public void setUserIntegration(int userIntegration) {
        this.userIntegration = userIntegration;
    }

    public int getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(int userCredit) {
        this.userCredit = userCredit;
    }

    public int getUserVerify() {
        return userVerify;
    }

    public void setUserVerify(int userVerify) {
        this.userVerify = userVerify;
    }

    public int getInfoComplete() {
        return infoComplete;
    }

    public void setInfoComplete(int infoComplete) {
        this.infoComplete = infoComplete;
    }

    public String getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce;
    }

    public String getUserCoordinate() {
        return userCoordinate;
    }

    public void setUserCoordinate(String userCoordinate) {
        this.userCoordinate = userCoordinate;
    }

    public String getFromSchool() {
        return fromSchool;
    }

    public void setFromSchool(String fromSchool) {
        this.fromSchool = fromSchool;
    }

    public String getFromCollege() {
        return fromCollege;
    }

    public void setFromCollege(String fromCollege) {
        this.fromCollege = fromCollege;
    }

    public String getFromMajor() {
        return fromMajor;
    }

    public void setFromMajor(String fromMajor) {
        this.fromMajor = fromMajor;
    }

    public Date getSchoolTime() {
        return schoolTime;
    }

    public void setSchoolTime(Date schoolTime) {
        this.schoolTime = schoolTime;
    }

    public double getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(double userHeight) {
        this.userHeight = userHeight;
    }

    public double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(double userWeight) {
        this.userWeight = userWeight;
    }

    public String getUserStandard() {
        return userStandard;
    }

    public void setUserStandard(String userStandard) {
        this.userStandard = userStandard;
    }

    public int getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(int businessLicense) {
        this.businessLicense = businessLicense;
    }

    public BigDecimal getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(BigDecimal depositMoney) {
        this.depositMoney = depositMoney;
    }

    @Override
    public String toString() {
        return "UserInfoBean{" +
                "userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userSex=" + userSex +
                ", userAge=" + userAge +
                ", userPhoto='" + userPhoto + '\'' +
                ", realName='" + realName + '\'' +
                ", userIdcard='" + userIdcard + '\'' +
                ", userBirthday=" + userBirthday +
                ", addrCode=" + addrCode +
                ", addrDetail='" + addrDetail + '\'' +
                ", tel='" + tel + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", email='" + email + '\'' +
                ", userExperience=" + userExperience +
                ", userIntegration=" + userIntegration +
                ", userCredit=" + userCredit +
                ", userVerify=" + userVerify +
                ", infoComplete=" + infoComplete +
                ", userIntroduce='" + userIntroduce + '\'' +
                ", userCoordinate='" + userCoordinate + '\'' +
                ", fromSchool='" + fromSchool + '\'' +
                ", fromCollege='" + fromCollege + '\'' +
                ", fromMajor='" + fromMajor + '\'' +
                ", schoolTime=" + schoolTime +
                ", userHeight=" + userHeight +
                ", userWeight=" + userWeight +
                ", userStandard='" + userStandard + '\'' +
                ", businessLicense=" + businessLicense +
                ", depositMoney=" + depositMoney +
                '}';
    }
}
