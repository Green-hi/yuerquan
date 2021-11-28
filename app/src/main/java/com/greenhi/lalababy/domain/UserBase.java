package com.greenhi.lalababy.domain;

public class UserBase {

    private String phoneNum;
    private String password;
    private String nickName;

    public UserBase(String phoneNum, String password, String nickName) {
        this.phoneNum = phoneNum;
        this.password = password;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "UserBase{" +
                "phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
