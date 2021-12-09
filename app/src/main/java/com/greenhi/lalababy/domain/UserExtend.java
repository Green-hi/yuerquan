package com.greenhi.lalababy.domain;

import androidx.annotation.Nullable;

import java.util.Date;

public class UserExtend {
    /**
     * 手机号
     */
    private String phoneNum;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String icon;

    /**
     * 宝宝年龄
     */
    private Date babyBirthday;

    public UserExtend() {
    }

    public UserExtend(String phoneNum, String nickName, @Nullable String icon, @Nullable Date babyBirthday) {
        this.phoneNum = phoneNum;
        this.nickName = nickName;
        this.icon = icon;
        this.babyBirthday = babyBirthday;
    }

    @Override
    public String toString() {
        return "UserExtend{" +
                "phoneNum='" + phoneNum + '\'' +
                ", nickName='" + nickName + '\'' +
                ", icon='" + icon + '\'' +
                ", babyBirthday=" + babyBirthday +
                '}';
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getBabyBirthday() {
        return babyBirthday;
    }

    public void setBabyBirthday(Date babyBirthday) {
        this.babyBirthday = babyBirthday;
    }
}
