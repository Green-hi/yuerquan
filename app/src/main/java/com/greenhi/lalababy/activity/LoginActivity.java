package com.greenhi.lalababy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import com.greenhi.lalababy.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtn;
    RelativeLayout mRlAgree;
    private ImageView mIvAgree;
    private TextView mTvStatement,mTVLoginRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mBtn = findViewById(R.id.mLoginBtn);
        mRlAgree = findViewById(R.id.rl_agree);
        mIvAgree = findViewById(R.id.iv_agree);
        mTvStatement = findViewById(R.id.tv_statement);
        mTVLoginRegister = findViewById(R.id.mLoginRegisterTV);
        mBtn.setOnClickListener(this);
        mIvAgree.setOnClickListener(this);
        mTvStatement.setOnClickListener(this);
        mTVLoginRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mLoginBtn:
                if(mIvAgree.isSelected()){
                    navigateTo(MainActivity.class);
                }else{
                    showToastCenter("请勾选同意相关协议政策");
                }
                break;
            case R.id.iv_agree:
                if(mIvAgree.isSelected()){
                    mIvAgree.setSelected(false);
                    mRlAgree.setBackground(ResourcesCompat
                                .getDrawable(getResources(),R.drawable.bg_login_agree,null));
                }else {
                    mIvAgree.setSelected(true);
                    mRlAgree.setBackground(null);
                }
            case R.id.tv_statement:

                //navigateTo();
                break;
            case R.id.mLoginRegisterTV:
                navigateTo(RegisterActivity.class);
            default:
                break;
        }
    }
}