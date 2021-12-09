package com.greenhi.lalababy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.greenhi.lalababy.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class BabyChapterLayout extends LinearLayout {

    private Context mContext;

    private CircleImageView ivBaby;
    private TextView tvBabyName,tvBabyDate,tvBabyWeight;

    public BabyChapterLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_chapter_baby,this);
        ivBaby = findViewById(R.id.iv_baby);
        tvBabyName = findViewById(R.id.tv_baby_name);
        tvBabyDate = findViewById(R.id.tv_baby_date);
        tvBabyWeight = findViewById(R.id.tv_baby_weight);
    }
}
