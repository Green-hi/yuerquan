package com.greenhi.lalababy.item;

public class ItemDataProfile {

    private int iconImgID;
    private String title1;
    private String title2;
    private int viewVisible;

    public ItemDataProfile(int iconImgID, String title1, String title2, int viewVisible) {
        this.iconImgID = iconImgID;
        this.title1 = title1;
        this.title2 = title2;
        this.viewVisible = viewVisible;  //0 gone   1 visible  2 invisible
    }

    public int getIconImgID() {
        return iconImgID;
    }

    public String getTitle1() {
        return title1;
    }

    public String getTitle2() {
        return title2;
    }

    public int getViewVisible(){return  viewVisible;}
}
