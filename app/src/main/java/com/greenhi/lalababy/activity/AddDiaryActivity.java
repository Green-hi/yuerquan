package com.greenhi.lalababy.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.item.ItemDataJournal;
import com.greenhi.lalababy.resultUnit.PostResult;
import com.greenhi.lalababy.retrofit.API;
import com.greenhi.lalababy.retrofit.RetrofitManager;

import java.net.HttpURLConnection;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDiaryActivity extends BaseActivity implements View.OnClickListener {

    private API mApi;

    private Activity mActivity;

    private LinearLayout llLeft,llRight,llTime,llaAddress;
    private EditText etTitle,etContent;

    private ItemDataJournal itemDataJournal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diary);
        mApi = RetrofitManager.getRetrofit().create(API.class);
        mActivity = this;
        itemDataJournal = new ItemDataJournal();
        initView();
        addListener();
    }

    private void initView() {
        llLeft= findViewById(R.id.layout_left);
        llRight = findViewById(R.id.layout_right);
        llTime = findViewById(R.id.layout_time);
        llaAddress = findViewById(R.id.layout_address);
        etTitle = findViewById(R.id.et_title);
        etContent = findViewById(R.id.et_content);
    }

    private void addListener() {
        llLeft.setOnClickListener(this);
        llRight.setOnClickListener(this);
        llTime.setOnClickListener(this);
        llaAddress.setOnClickListener(this);
        etTitle.setOnClickListener(this);
        etContent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.layout_left:
                this.finish();
                break;
            case R.id.layout_right:
                String title = etTitle.getText().toString();
                String content = etContent.getText().toString();
                if(title==null||title.trim().isEmpty()||content==null||content.trim().isEmpty()){
                    showToast("请完善日记内容");
                }else {
                    String phoneNum = getIntent().getStringExtra("phoneNum");
                    Log.e(TAG, "AddDiaryActivity phoneNum--> "+phoneNum );
                    itemDataJournal.setPhoneNum(phoneNum);
                    Calendar calendar = Calendar.getInstance();
                    itemDataJournal.setDay(calendar.get(Calendar.DAY_OF_MONTH)+"");
                    itemDataJournal.setYear(calendar.get(Calendar.YEAR)+"/"+calendar.get(Calendar.MONTH));
                    itemDataJournal.setAge("3月28天");
                    itemDataJournal.setTitle(title);
                    itemDataJournal.setContent(content);
                    Call<PostResult> task = mApi.postDiary(itemDataJournal);
                    task.enqueue(new Callback<PostResult>() {
                        @Override
                        public void onResponse(Call<PostResult> call, Response<PostResult> response) {
                            Log.e(TAG, "onResponse--> "+response );
                            if (response.code() == HttpURLConnection.HTTP_OK) {
                                PostResult result = response.body();
                                Log.e(TAG, "responseBody --> " + result);
                                if (result.getCode() == 100) {
                                    showToast("日记数据上传成功");
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
                }
//                Intent intent = new Intent(this,MainActivity.class);
//                intent.putExtra("fragment_flag", 1);
                //this.finish();
                break;
            default:
                break;
        }
    }
}