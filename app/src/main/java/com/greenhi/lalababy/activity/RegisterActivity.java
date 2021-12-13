package com.greenhi.lalababy.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.domain.UserBase;
import com.greenhi.lalababy.domain.UserExtend;
import com.greenhi.lalababy.resultUnit.PostResult;
import com.greenhi.lalababy.retrofit.API;
import com.greenhi.lalababy.retrofit.RetrofitManager;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private API mApi;

    private TextView mTvStatementRegister,mTvPhoneNumber;
    private EditText mEtPhoneNum, mEtCaptcha, mEtPwd, mEtNickname;
    private LinearLayout mLlPhoneNum, mLlFillAccount;
    private ImageView mIvSee, mIvAgree;
    private Button mBtnSendCaptcha, mBtnNext, mBtnSubmit;

    private static String phoneNum,pwd,nickName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mApi = RetrofitManager.getRetrofit().create(API.class);
        initView();
        setListener();
    }

    private void initView() {
        mTvStatementRegister = findViewById(R.id.tv_statement_register);
        mTvPhoneNumber = findViewById(R.id.phoneNumberTV);
        mEtPhoneNum = findViewById(R.id.phoneET);
        mEtCaptcha = findViewById(R.id.captchaET);
        mEtPwd = findViewById(R.id.passwordET);
        mEtNickname = findViewById(R.id.nicknameET);
        mLlPhoneNum = findViewById(R.id.fillPhoneNumber);
        mLlFillAccount = findViewById(R.id.fillAccount);
        mIvSee = findViewById(R.id.mSeeIV);
        mIvAgree = findViewById(R.id.iv_agree_register);
        mBtnSendCaptcha = findViewById(R.id.sendCaptchaBtn);
        mBtnNext = findViewById(R.id.nextBtn);
        mBtnSubmit = findViewById(R.id.submitBtn);
    }

    private void setListener() {
        mTvStatementRegister.setOnClickListener(this);
        mTvPhoneNumber.setOnClickListener(this);
        mEtPhoneNum.setOnClickListener(this);
        mEtCaptcha.setOnClickListener(this);
        mEtPwd.setOnClickListener(this);
        mEtNickname.setOnClickListener(this);
        mLlPhoneNum.setOnClickListener(this);
        mLlFillAccount.setOnClickListener(this);
        mIvSee.setOnClickListener(this);
        mIvAgree.setOnClickListener(this);
        mBtnSendCaptcha.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
        mBtnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.nextBtn:
                mLlPhoneNum.setVisibility(View.GONE);
                mLlFillAccount.setVisibility(View.VISIBLE);
                break;
            case R.id.submitBtn:
                if(mIvAgree.isSelected()){
                    doRegister();
                }else{
                    showToastCenter("请勾选同意相关协议政策");
                }
                break;
            case R.id.iv_agree_register:
                if(mIvAgree.isSelected()){
                    mIvAgree.setSelected(false);
                }else {
                    mIvAgree.setSelected(true);
                }
                break;
            default:
                break;
        }
    }

    private void doRegister() {
        phoneNum = mEtPhoneNum.getText().toString();
        pwd = mEtPwd.getText().toString();
        nickName = mEtNickname.getText().toString();
        UserBase userBase = new UserBase(phoneNum, pwd, nickName);
        Call<PostResult> task1 = mApi.addUserBase(userBase);
        task1.enqueue(new Callback<PostResult>() {
            @Override
            public void onResponse(Call<PostResult> call, Response<PostResult> response) {
                Log.e(TAG, "onResponse--> "+response );
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    PostResult result = response.body();
                    Log.e(TAG, "responseBody --> " + result);
                    if (result.getCode() == 100) {
                        showToast("注册成功");
                        navigateTo(LoginActivity.class);
                    }else {
                        showToast(result.getCode()+" "+result.getMessage());
                    }
                }else {
                    showToast(response.toString());
                }
            }
            @Override
            public void onFailure(Call<PostResult> call, Throwable t) {
                Log.e(TAG, "onFailure --> " + t.toString());
                showToast("连接失败！请检查网络连接");
            }
        });

        new Thread(new Runnable() {   //在另一个线程中上传user_extend数据
            @Override
            public void run() {

                UserExtend userExtend = new UserExtend(phoneNum,nickName,null,null);

                Call<PostResult> task2 = mApi.addUserExtend(userExtend);
                task2.enqueue(new Callback<PostResult>() {
                    @Override
                    public void onResponse(Call<PostResult> call, Response<PostResult> response) {
                        Log.e(TAG, "onResponse--> "+response );
                        if (response.code() == HttpURLConnection.HTTP_OK) {
                            PostResult result = response.body();
                            Log.e(TAG, "add user-extend responseBody --> " + result);
                        }
                    }
                    @Override
                    public void onFailure(Call<PostResult> call, Throwable t) {
                        Log.e(TAG, "onFailure --> " + t.toString());
                    }
                });
            }
        }).start();
    }
}
