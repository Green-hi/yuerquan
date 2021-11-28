package com.greenhi.lalababy.item;

import androidx.annotation.Nullable;

import java.util.List;

public class ItemDataCommunity {

    private int headID;
    private String name;
    private String status;
    private String time;
    private String address;
    private String comment;
    private String like;
    private String comText;
    private List<Integer> imgList;

    public ItemDataCommunity(int headID, String name, String status, String time, String address, String comment, String like,String comText,@Nullable List<Integer> imgList) {
        this.headID = headID;
        this.name = name;
        this.status = status;
        this.time = time;
        this.address = address;
        this.comment = comment;
        this.like = like;
        this.comText = comText;
        this.imgList = imgList;
    }

    public int getHeadID() {
        return headID;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }

    public String getAddress() {
        return address;
    }

    public String getComment() {
        return comment;
    }

    public String getLike() {
        return like;
    }

    public String getComText(){
        return comText;
    }

    public List<Integer> getImgList(){
        return imgList;
    }
}