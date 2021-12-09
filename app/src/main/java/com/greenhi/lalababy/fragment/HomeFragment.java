package com.greenhi.lalababy.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.activity.AddDiaryActivity;

public class HomeFragment extends Fragment {

    private static final String TAG = "FYuerQuan2021";

    private Context mContext;
    private View rootView;

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
//        initData();
//        initView();
        return rootView;
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
