package com.greenhi.lalababy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.domain.UserBase;
import com.greenhi.lalababy.resultUnit.PostResult;
import com.greenhi.lalababy.retrofit.API;
import com.greenhi.lalababy.retrofit.RetrofitManager;

import retrofit2.Call;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "RegisterActivity2021";
    private API mApi;

    private TextView mTvStatementRegister,mTvPhoneNumber;
    private EditText mEtPhoneNum, mEtCaptcha, mEtPwd, mEtNickname;
    private LinearLayout mLlPhoneNum, mLlFillAccount;
    private ImageView mIvSee, mIvAgree;
    private Button mBtnSendCaptcha, mBtnNext, mBtnSubmit;

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
                    addUserBase();
                    navigateTo(LoginActivity.class);
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

    private void addUserBase() {
        UserBase userBase = new UserBase(mEtPhoneNum.getText().toString()
                , mEtPwd.getText().toString(), mEtNickname.getText().toString());
        Call<PostResult> task = mApi.addUserBase(userBase);
        enqueueTask(task,TAG);
    }
}
