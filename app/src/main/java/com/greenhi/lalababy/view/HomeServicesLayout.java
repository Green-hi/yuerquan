package com.greenhi.lalababy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.adapter.HomeToolsAdapter;
import com.greenhi.lalababy.item.ItemDataTools;

import java.util.ArrayList;
import java.util.List;

public class HomeServicesLayout extends LinearLayout {

    private Context mContext;

    private RecyclerView mRv;
    private HomeToolsAdapter adapter;

    private List<ItemDataTools> mToolList;


    public HomeServicesLayout(Context context) {
        super(context);
        mContext = context;
    }

    public HomeServicesLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initData();
        initView();
    }

    private void initData() {
        mToolList = new ArrayList<>();
        mToolList.add(new ItemDataTools(R.drawable.icon_taidong_baby,"宝宝成长特点"));
        mToolList.add(new ItemDataTools(R.drawable.icon_xiaole,"亲子游戏"));
        mToolList.add(new ItemDataTools(R.mipmap.icon_home_heightweight,"健康管理"));
        mToolList.add(new ItemDataTools(R.drawable.icon_message_muzi,"养娃小tip"));
    }

    private void initView() {
        LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_home_services,this);
        mRv = findViewById(R.id.rv_tools);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,4);
        mRv.setLayoutManager(gridLayoutManager);
        adapter = new HomeToolsAdapter(mToolList);
        mRv.setAdapter(adapter);
    }
}
