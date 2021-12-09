package com.greenhi.lalababy.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.resultUnit.PostResult;
import com.greenhi.lalababy.retrofit.API;
import com.greenhi.lalababy.retrofit.RetrofitManager;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private API mApi;

    private Button mBtn;
    RelativeLayout mRlAgree;
    private ImageView mIvAgree;
    private TextView mTvStatement,mTVLoginRegister;
    private EditText mEtAccount,mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mApi = RetrofitManager.getRetrofit().create(API.class);
        initView();
        setListener();
    }

    private void initView() {
        mBtn = findViewById(R.id.mLoginBtn);
        mRlAgree = findViewById(R.id.rl_agree);
        mIvAgree = findViewById(R.id.iv_agree);
        mTvStatement = findViewById(R.id.tv_statement);
        mTVLoginRegister = findViewById(R.id.mLoginRegisterTV);
        mEtAccount = findViewById(R.id.mLoginAccountET);
        mEtPassword = findViewById(R.id.mLoginPwdET);
    }

    private void setListener() {
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
                    doLogin();
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

    private void doLogin() {
        String account = String.valueOf(mEtAccount.getText());
        String password = String.valueOf(mEtPassword.getText());
        Call<PostResult> task = mApi.login(account, password);
        task.enqueue(new Callback<PostResult>() {
            @Override
            public void onResponse(Call<PostResult> call, Response<PostResult> response) {
                Log.e(TAG, "onResponse--> "+response );
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    PostResult result = response.body();
                    Log.e(TAG, "responseBody --> " + result);
                    if (result.getCode() == 100) {
                        showToast("登录成功");
                        navigateWithExtra(MainActivity.class,"phoneNum",account);
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
    }
}