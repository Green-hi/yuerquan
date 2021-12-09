package com.greenhi.lalababy.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.activity.AddDiaryActivity;
import com.greenhi.lalababy.resultUnit.DiaryResult;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private static final String TAG = "FYuerQuan2021";

    private Context mContext;
    private View rootView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ContextThemeWrapper themeWrapper = new ContextThemeWrapper(getActivity(), R.style.ActivityTheme_Full);
//        LayoutInflater localInflater = inflater.cloneInContext(themeWrapper);
//        if(Build.VERSION.SDK_INT >= 21) {
//            View decorView = getActivity().getWindow().getDecorView();
//            //设置全屏和状态栏透明
//            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }
        Log.e("TAG4544", "onCreateView: HomeFragment");
        if(rootView == null){
            rootView = inflater.inflate(R.layout.fragment_home,container,false);
        }
        mSwipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh_home);
//        initData();
//        initView();
        handleRefresh();
        return rootView;
    }

    private void handleRefresh() {
        mSwipeRefreshLayout.setEnabled(true);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //  在这里执行刷新数据的操作
                /**
                 * 这个方法是MainThread是主线程，不可以执行耗时操作。
                 * 一般来说，我们请求数据需要开一个线程去获取
                 */
                //添加数据
                //
                //更新UI
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //这里做两件事，一件是让刷新停止，另一件是更新列表
                        //recycleAdapter.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }

    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayout llAddDiary = getView().findViewById(R.id.layout_add_diary_unique);
        llAddDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getArguments();
                String phoneNum = (String) bundle.get("phoneNum");
                Log.e(TAG, "JournalFragment phoneNum--> "+phoneNum );
                Intent intent = new Intent(getActivity(), AddDiaryActivity.class);
                intent.putExtra("phoneNum",phoneNum);
                startActivity(intent);
            }
        });
    }*/

}
