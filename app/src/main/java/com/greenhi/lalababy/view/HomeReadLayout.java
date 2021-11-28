package com.greenhi.lalababy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.adapter.HomeArticlesAdapter;
import com.greenhi.lalababy.adapter.HomeToolsAdapter;
import com.greenhi.lalababy.item.ItemDataArticle;
import com.greenhi.lalababy.item.ItemDataTools;

import java.util.ArrayList;
import java.util.List;

public class HomeReadLayout extends LinearLayout {

    private Context mContext;

    private RecyclerView mRv;
    private HomeArticlesAdapter adapter;

    private List<ItemDataArticle> itemDataList;


    public HomeReadLayout(Context context) {
        super(context);
        mContext = context;
    }

    public HomeReadLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initData();
        initView();
    }

    private void initData() {
        itemDataList = new ArrayList<>();
        itemDataList.add(new ItemDataArticle("三十五岁之后生孩子需要注意","随着三孩政策的开放，大龄产妇的人数逐渐上升",R.drawable.baby1));
        itemDataList.add(new ItemDataArticle("这些小病，怀孕前一定要治好","现在很多年轻人的身体都处于亚健康状态，因为",R.drawable.baby2));
        itemDataList.add(new ItemDataArticle("教你甄别六种预测生男生女的真假","每个准妈妈都会好奇宝宝的性别，都在猜想胎儿的性别，",R.drawable.baby3));
        itemDataList.add(new ItemDataArticle("宝宝疫苗到底怎么打？","小南发现大家对于疫苗的问题真的好多，而且涉及到方方面面，",R.drawable.baby4));
        itemDataList.add(new ItemDataArticle("央视提醒：这种小药膏不是万能药","据说，每个人的床头都放着一支红霉素软膏，长了痘痘",R.drawable.baby5));
        itemDataList.add(new ItemDataArticle("什么是小儿疝气？可影响生育","1岁男孩体内感染多条活虫！还这样做饭就是害娃，",R.drawable.baby6));
    }

    private void initView() {
        LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_home_read,this);
        mRv = findViewById(R.id.rv_articles);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        mRv.setLayoutManager(linearLayoutManager);
        adapter = new HomeArticlesAdapter(itemDataList);
        mRv.setAdapter(adapter);
    }
}
