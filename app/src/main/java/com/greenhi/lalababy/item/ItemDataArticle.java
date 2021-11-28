package com.greenhi.lalababy.item;

public class ItemDataArticle {

    private String title1;
    private String title2;
    private int iconID;

    public ItemDataArticle(String title1, String title2, int iconID) {
        this.title1 = title1;
        this.title2 = title2;
        this.iconID = iconID;
    }

    public String getTitle1() {
        return title1;
    }

    public String getTitle2() {
        return title2;
    }

    public int getIconID() {
        return iconID;
    }
}
