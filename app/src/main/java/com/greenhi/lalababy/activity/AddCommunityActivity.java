package com.greenhi.lalababy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.item.ItemDataCommunity;
import com.greenhi.lalababy.resultUnit.PostResult;
import com.greenhi.lalababy.retrofit.API;
import com.greenhi.lalababy.retrofit.RetrofitManager;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCommunityActivity extends BaseActivity implements View.OnClickListener {

    private API mApi;

    private Activity mActivity;

    private LinearLayout llBack,llRelease;
    private EditText etContent;

    private ItemDataCommunity itemDataCommunity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_community);
        mApi = RetrofitManager.getRetrofit().create(API.class);
        mActivity = this;
        itemDataCommunity = new ItemDataCommunity();
        initView();
        addListener();
    }

    private void initView() {
        llBack = findViewById(R.id.community_back);
        llRelease = findViewById(R.id.community_release);
        etContent = findViewById(R.id.et_content_community);
    }

    private void addListener() {
        llBack.setOnClickListener(this);
        llRelease.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.community_back:
                this.finish();
                break;
            case R.id.community_release:
                String content = etContent.getText().toString();
                if(content==null||content.trim().isEmpty()){
                    showToast("请输入朋友圈内容");
                }else {
                    String phoneNum = getIntent().getStringExtra("phoneNum");
                    Log.e(TAG, "AddCommunityActivity phoneNum--> "+phoneNum );
                    itemDataCommunity.setPhoneNum(phoneNum);
                    itemDataCommunity.setAddress("温州市五马街36号");
                    itemDataCommunity.setContent(content);
                    Call<PostResult> task = mApi.postCom(itemDataCommunity);
                    task.enqueue(new Callback<PostResult>() {
                        @Override
                        public void onResponse(Call<PostResult> call, Response<PostResult> response) {
                            Log.e(TAG, "onResponse--> "+response );
                            if (response.code() == HttpURLConnection.HTTP_OK) {
                                PostResult result = response.body();
                                Log.e(TAG, "responseBody --> " + result);
                                if (result.getCode() == 100) {
                                    showToast("朋友圈数据上传成功");
                                    mActivity.finish();
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
                    this.finish();
                }
                break;
            default:
                break;
        }
    }
}