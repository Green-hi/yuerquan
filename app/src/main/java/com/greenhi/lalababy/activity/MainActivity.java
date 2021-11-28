package com.greenhi.lalababy.activity;

import static com.greenhi.lalababy.utils.ScreenUtils.getStatusHeight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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
import com.greenhi.lalababy.utils.ScreenUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

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

        ivHome.setSelected(true);
        tvHome.setSelected(true);
        ivCurrent = ivHome;
        tvCurrent = tvHome;
    }

    private void initPager() {
        viewPager = findViewById(R.id.viewPager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance());
        fragments.add(JournalFragment.newInstance("",""));
        fragments.add(CommunityFragment.newInstance());
        fragments.add(MessageFragment.newInstance());
        fragments.add(ProfileFragment.newInstance("我的"));
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager.setAdapter(pagerAdapter);
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
    protected void setStatusBarFullTransparent() {
        if (Build.VERSION.SDK_INT >= 21) {//21表示5.0
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= 19) {//19表示4.4
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //虚拟键盘也透明
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 半透明状态栏
     */
    protected void setHalfTransparent() {

        if (Build.VERSION.SDK_INT >= 21) {//21表示5.0
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        } else if (Build.VERSION.SDK_INT >= 19) {//19表示4.4
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //虚拟键盘也透明
            // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 如果需要内容紧贴着StatusBar
     * 应该在对应的xml布局文件中，设置根布局fitsSystemWindows=true。
     */
    private View contentViewGroup;

    protected void setFitSystemWindow(boolean fitSystemWindow) {
        if (contentViewGroup == null) {
            contentViewGroup = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        }
        contentViewGroup.setFitsSystemWindows(fitSystemWindow);
    }

    /**
     * 为了兼容4.4的抽屉布局->透明状态栏
     */
    protected void setDrawerLayoutFitSystemWindow() {
        if (Build.VERSION.SDK_INT == 19) {//19表示4.4
            int statusBarHeight = getStatusHeight(this);
            if (contentViewGroup == null) {
                contentViewGroup = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
            }
            if (contentViewGroup instanceof DrawerLayout) {
                DrawerLayout drawerLayout = (DrawerLayout) contentViewGroup;
                drawerLayout.setClipToPadding(true);
                drawerLayout.setFitsSystemWindows(false);
                for (int i = 0; i < drawerLayout.getChildCount(); i++) {
                    View child = drawerLayout.getChildAt(i);
                    child.setFitsSystemWindows(false);
                    child.setPadding(0,statusBarHeight, 0, 0);
                }

            }
        }
    }

    public void setStatusBarColor(Activity activity, int colorId) {

    }
}