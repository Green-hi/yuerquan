package com.greenhi.lalababy.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.greenhi.lalababy.R;

public class ImgShowDialog extends BaseDialog{
    private PhotoView photoView;
    private String imgpath;
    private PhotoViewAttacher mAttacher;

    public ImgShowDialog(Context context) {
        super(context);
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_photo_show_layout);
        photoView = (PhotoView) findViewById(R.id.photoview);
        Glide.with(context).load(imgpath).into(photoView);
        mAttacher = new PhotoViewAttacher(photoView);
        mAttacher.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(ImageView view, float x, float y) {

            }
        });
    }
}
