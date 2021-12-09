package com.greenhi.lalababy.item;

import androidx.annotation.Nullable;

import java.util.List;

public class ItemDataCommunity {

    private String phoneNum;
    private String head;
    private String name;
    private String status;
    private String time;
    private String address;
    private int comments=0;
    private int likes=0;
    private String content;
    private String imgList;

    public ItemDataCommunity() {
    }

    public ItemDataCommunity(@Nullable String phoneNum,String head, String name, String status, String time, String address, int comments, int likes, String content, String imgList) {
        this.phoneNum = phoneNum;
        this.head = head;
        this.name = name;
        this.status = status;
        this.time = time;
        this.address = address;
        this.comments = comments;
        this.likes = likes;
        this.content = content;
        this.imgList = imgList;
    }

    @Override
    public String toString() {
        return "ItemDataCommunity{" +
                "phoneNum='" + phoneNum + '\'' +
                ", head='" + head + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                ", address='" + address + '\'' +
                ", comments='" + comments + '\'' +
                ", likes='" + likes + '\'' +
                ", content='" + content + '\'' +
                ", imgList='" + imgList + '\'' +
                '}';
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgList() {
        return imgList;
    }

    public void setImgList(String imgList) {
        this.imgList = imgList;
    }
}