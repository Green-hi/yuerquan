package com.greenhi.lalababy.pojo;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author greenhi
 * @since 2021-12-07
 */
public class Community {

    private Integer id;

    /**
     * 用户手机号
     */
    private String phoneNum;

    /**
     * 地址
     */
    private String address;

    /**
     * 朋友圈内容
     */
    private String content;

    /**
     * 图片地址列表
     */
    private String imgList;

    /**
     * 评论数
     */
    private Integer comments;

    /**
     * 喜欢数
     */
    private Integer likes;

    private Date createTime;

    private Date updateTime;

    private String shareOne;

    private String shareTwo;

    public Community() {
    }

    public Community(Integer id, String phoneNum, String address, String content, String imgList, Integer comments, Integer likes, Date createTime, Date updateTime, String shareOne, String shareTwo) {
        this.id = id;
        this.phoneNum = phoneNum;
        this.address = address;
        this.content = content;
        this.imgList = imgList;
        this.comments = comments;
        this.likes = likes;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.shareOne = shareOne;
        this.shareTwo = shareTwo;
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", phoneNum='" + phoneNum + '\'' +
                ", address='" + address + '\'' +
                ", content='" + content + '\'' +
                ", imgList='" + imgList + '\'' +
                ", comments=" + comments +
                ", likes=" + likes +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", shareOne='" + shareOne + '\'' +
                ", shareTwo='" + shareTwo + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getShareOne() {
        return shareOne;
    }

    public void setShareOne(String shareOne) {
        this.shareOne = shareOne;
    }

    public String getShareTwo() {
        return shareTwo;
    }

    public void setShareTwo(String shareTwo) {
        this.shareTwo = shareTwo;
    }
}
