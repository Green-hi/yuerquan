package com.greenhi.lalababy.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.adapter.MyFragmentPagerAdapter;
import com.greenhi.lalababy.fragment.CommunityFragment;
import com.greenhi.lalababy.fragment.HomeFragment;
import com.greenhi.lalababy.fragment.JournalFragment;
import com.greenhi.lalababy.fragment.MessageFragment;
import com.greenhi.lalababy.fragment.ProfileFragment;
import com.greenhi.lalababy.item.ItemDataJournal;
import com.greenhi.lalababy.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = "YuerQuan2021";

    private ArrayList<Fragment> fragments;

    ViewPager2 viewPager;
    LinearLayout llHome,llJournal,llSquare,llMessage,llProfile;
    ImageView ivHome,ivJournal,ivSquare,ivMessage,ivProfile,ivCurrent;
    TextView tvHome,tvJournal,tvSquare,tvMessage,tvProfile,tvCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置全屏和状态栏透明
        ScreenUtils.transparencyBar(this);
        //改变状态栏文字颜色
        ScreenUtils.setAndroidNativeLightStatusBar(this,true);
        setContentView(R.layout.activity_main);
        initPager();
        initView();
        setListener();
    }

    private void setListener() {
        llHome.setOnClickListener(this);
        llJournal.setOnClickListener(this);
        llSquare.setOnClickListener(this);
        llMessage.setOnClickListener(this);
        llProfile.setOnClickListener(this);
    }

    private void initView() {
        llHome = findViewById(R.id.tab_home);
        llJournal = findViewById(R.id.tab_journal);
        llSquare = findViewById(R.id.tab_square);
        llMessage = findViewById(R.id.tab_message);
        llProfile = findViewById(R.id.tab_profile);
        ivHome = findViewById(R.id.tab_iv_home);
        ivJournal = findViewById(R.id.tab_iv_journal);
        ivSquare = findViewById(R.id.tab_iv_square);
        ivMessage = findViewById(R.id.tab_iv_message);
        ivProfile = findViewById(R.id.tab_iv_profile);
        tvHome = findViewById(R.id.text_home);
        tvJournal = findViewById(R.id.text_journal);
        tvSquare = findViewById(R.id.text_square);
        tvMessage = findViewById(R.id.text_message);
        tvProfile = findViewById(R.id.text_profile);

        ivJournal.setSelected(true);
        tvJournal.setSelected(true);
        ivCurrent = ivJournal;
        tvCurrent = tvJournal;
    }

    private void initPager() {
        viewPager = findViewById(R.id.viewPager);
        fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance());
        String phoneNum = getIntent().getStringExtra("phoneNum");
        Log.e(TAG, "MainActivity phoneNum--> "+phoneNum );
        Bundle bundle = new Bundle();
        bundle.putString("phoneNum",phoneNum);
        JournalFragment journalFragment = JournalFragment.newInstance();
        journalFragment.setArguments(bundle);
        fragments.add(journalFragment);
        CommunityFragment communityFragment = CommunityFragment.newInstance();
        communityFragment.setArguments(bundle);
        fragments.add(communityFragment);
        fragments.add(MessageFragment.newInstance());
        fragments.add(ProfileFragment.newInstance("我的"));
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { //正在滚动
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        viewPager.setCurrentItem(viewPager.getCurrentItem(),true);
    }

    @Override
    public void onClick(View view) {
        changeTab(view.getId());
    }

    private void changeTab(int position) {
        ivCurrent.setSelected(false);
        tvCurrent.setSelected(false);
        switch (position){
            case R.id.tab_home:
                viewPager.setCurrentItem(0);
            case 0:
                ivHome.setSelected(true);
                tvHome.setSelected(true);
                ivCurrent = ivHome;
                tvCurrent = tvHome;
                break;
            case R.id.tab_journal:
                viewPager.setCurrentItem(1);
            case 1:
                ivJournal.setSelected(true);
                tvJournal.setSelected(true);
                ivCurrent = ivJournal;
                tvCurrent = tvJournal;
                break;
            case R.id.tab_square:
                viewPager.setCurrentItem(2);
            case 2:
                ivSquare.setSelected(true);
                tvSquare.setSelected(true);
                tvCurrent = tvSquare;
                ivCurrent = ivSquare;
                break;
            case R.id.tab_message:
                viewPager.setCurrentItem(3);
            case 3:
                ivMessage.setSelected(true);
                tvMessage.setSelected(true);
                ivCurrent = ivMessage;
                tvCurrent = tvMessage;
                break;
            case R.id.tab_profile:
                viewPager.setCurrentItem(4);
            case 4:
                tvProfile.setSelected(true);
                ivProfile.setSelected(true);
                tvCurrent = tvProfile;
                ivCurrent = ivProfile;
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: MainActivity");
        /*int fragmentFlag = getIntent().getIntExtra("fragment_flag",2);
        Log.i(TAG, "fragmentFlag: "+fragmentFlag);
        changeTab(fragmentFlag);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (fragmentFlag){
            case 1:
                transaction.replace(R.id.viewPager, fragments.get(1));
                break;
            case 2:
                //transaction.replace(R.id.fl_radio_show, mFragments[1]);
                break;
            case 3:
                //transaction.replace(R.id.fl_radio_show, mFragments[2]);
                break;
            default:
                break;
        }
        transaction.commit();*/

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: MainActivity");
    }
}