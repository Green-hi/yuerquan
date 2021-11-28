package com.greenhi.lalababy.item;

public class ItemDataMessage {

    private int iconImgID;
    private String title;
    private String message;
    private String time;
    private int msgNum;

    public ItemDataMessage(int iconImgID, String title, String message, String time, int msgNum) {
        this.iconImgID = iconImgID;
        this.title = title;
        this.message = message;
        this.time = time;
        this.msgNum = msgNum;
    }

    public int getIconImgID() {
        return iconImgID;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public int getMsgNum() {
        return msgNum;
    }
}
