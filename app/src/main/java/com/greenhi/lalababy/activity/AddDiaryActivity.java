package com.greenhi.lalababy.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.adviewpager.adutils.AdViewpagerUtil;
import com.greenhi.lalababy.dialog.PickPhotoDialog;
import com.greenhi.lalababy.item.ItemDataJournal;
import com.greenhi.lalababy.pojo.ImgBean;
import com.greenhi.lalababy.resultUnit.PostResult;
import com.greenhi.lalababy.retrofit.API;
import com.greenhi.lalababy.retrofit.RetrofitManager;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDiaryActivity extends BaseActivity implements View.OnClickListener {

    private API mApi;

    private Activity mActivity;

    private LinearLayout llLeft,llRight,llTime,llaAddress;
    private EditText etTitle,etContent;
    private ImageView ivAddDiary;

    private ItemDataJournal itemDataJournal;

    private PickPhotoDialog pickPhotoDialog;
    private ViewPager viewpager;
    private LinearLayout lydots;
    private AdViewpagerUtil adViewpagerUtil;
    private List<ImgBean> imgBeans = new ArrayList<ImgBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diary);
        mApi = RetrofitManager.getRetrofit().create(API.class);
        mActivity = this;
        itemDataJournal = new ItemDataJournal();
        initView();
        addListener();
        photoSetting();
    }

    private void initView() {
        llLeft= findViewById(R.id.layout_left);
        llRight = findViewById(R.id.layout_right);
        llTime = findViewById(R.id.layout_time);
        llaAddress = findViewById(R.id.layout_address);
        etTitle = findViewById(R.id.et_title);
        etContent = findViewById(R.id.et_content);
        ivAddDiary = findViewById(R.id.add_diary_img);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        lydots = (LinearLayout) findViewById(R.id.ly_dots);
    }

    private void addListener() {
        llLeft.setOnClickListener(this);
        llRight.setOnClickListener(this);
        llTime.setOnClickListener(this);
        llaAddress.setOnClickListener(this);
        etTitle.setOnClickListener(this);
        etContent.setOnClickListener(this);
        ivAddDiary.setOnClickListener(this);
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
            case R.id.add_diary_img:
                pickPhoto();
            default:
                break;
        }
    }

    private void pickPhoto() {
        if(adViewpagerUtil != null) {
            adViewpagerUtil.stopLoopViewPager();
        }
        pickPhotoDialog = new PickPhotoDialog(AddDiaryActivity.this, AddDiaryActivity.this);
        Window window = pickPhotoDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.DialogEnter);
        pickPhotoDialog.setCutImg(true, 5);//false:不裁剪（数量5生效） true:裁剪，数量不生效
        pickPhotoDialog.setSelectedImgs(imgBeans);//已选择的图片，选择时标出
        pickPhotoDialog.setOnPhotoResultListener(new PickPhotoDialog.OnPhotoResultListener() {
            @Override
            public void onCameraResult(String path) {//相机拍照图片路径
                imgBeans.clear();
                ImgBean imgBean = new ImgBean();
                imgBean.setPath(path);
                imgBeans.add(imgBean);
                adViewpagerUtil = new AdViewpagerUtil(AddDiaryActivity.this, viewpager, lydots, 8, 4, imgBeans);
                adViewpagerUtil.initVps();
            }

            @Override
            public void onCutPhotoResult(Bitmap bitmap) {
                //图片(相机和相册)裁剪后返回的bitmap
            }

            @Override
            public void onPhotoResult(List<ImgBean> selectedImgs) {//相册多图选择返回图片路径结果集
                if(selectedImgs != null && selectedImgs.size() > 0) {
                    imgBeans.clear();
                    imgBeans.addAll(selectedImgs);
                    adViewpagerUtil = new AdViewpagerUtil(AddDiaryActivity.this, viewpager, lydots, 8, 4, selectedImgs);
                    adViewpagerUtil.initVps();
                }
                else
                {
                    if(adViewpagerUtil != null) {
                        adViewpagerUtil.startLoopViewPager();
                    }
                }
            }
        });
        pickPhotoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if(adViewpagerUtil != null) {
                    adViewpagerUtil.startLoopViewPager();
                }
            }
        });
        pickPhotoDialog.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (pickPhotoDialog != null)
        {
            pickPhotoDialog.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(pickPhotoDialog != null)
        {
            pickPhotoDialog.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void photoSetting() {
        //设置裁剪比例
        CameraActivity.setClipRatio(1, 1);

        // setOutputFormat()  设置图片输出格式
        // setClipRatio()  设置裁剪比例
        // setClipPixel()  设置裁剪像素
        // setScales()  裁剪时是否可以缩放
        // setNoFaceDetections()  是否检测人脸
    }

    //从相机获取图片
    public void getPhotoFromCamera() {
        startActivity(new Intent(this, CameraActivity.class).putExtra(CameraActivity.ExtraType, CameraActivity.CAMERA));
    }

    //从相册获取图片
    public void getPhotoFromAlbum() {
        startActivity(new Intent(this, CameraActivity.class).putExtra(CameraActivity.ExtraType, CameraActivity.PHOTO));
    }

    @Override
    protected void onResume() {
        super.onResume();
        //获得相册、相机返回的结果，并显示
        if (CameraActivity.LISTENING) {
            Log.e("TAG", "返回的Uri结果：" + CameraActivity.IMG_URI);
            Log.e("TAG", "返回的File结果：" + CameraActivity.IMG_File.getPath());
            CameraActivity.LISTENING = false;   //关闭获取结果
            ivAddDiary.setImageURI(CameraActivity.IMG_URI);  //显示图片到控件
        }
    }
}