package com.greenhi.lalababy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.adapter.MessageRecyclerAdapter;
import com.greenhi.lalababy.item.ItemDataMessage;
import com.greenhi.lalababy.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {

    private Context mContext;
    private View rootView;
    private RecyclerView recyclerView;
    private MessageRecyclerAdapter recycleAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ViewGroup mContentView;

    private List<ItemDataMessage> msgList;

    public MessageFragment(){

    }

    public static MessageFragment newInstance() {

        Bundle args = new Bundle();
        MessageFragment fragment = new MessageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(rootView == null){
            rootView = inflater.inflate(R.layout.fragment_message,container,false);
        }
        Log.e("TAG4544", "onCreateView: MessageFragment");
        initData();
        initView();
        handleRefresh();
        return rootView;
    }

    private void initData() {
        msgList = new ArrayList<>();
        msgList.add(new ItemDataMessage(R.drawable.new_xiaole,
                "小乐智能机器人","Hi，欢迎你，我是小乐，输入关键词...","1月前",1));
        msgList.add(new ItemDataMessage(R.drawable.icon_message_muzi,
                "母子健康资讯","妇科知识科普","1月前",1));
        msgList.add(new ItemDataMessage(R.drawable.icon_message_shequ,
                "社区消息","小蓝回复了你","1年前",1));
        msgList.add(new ItemDataMessage(R.drawable.icon_message_wenda,
                "问答消息","您有一条医生通知","1年前",1));
        msgList.add(new ItemDataMessage(R.drawable.icon_message_xitong,
                "通知消息","妇科知识科普","1年前",1));
        msgList.add(new ItemDataMessage(R.drawable.icon_msg_info,
                "健康咨询","","7月前",1));
        msgList.add(new ItemDataMessage(R.drawable.icon_muzi_pyq,
                "B超解读","你发起了一次提问","9月前",1));
        msgList.add(new ItemDataMessage(R.drawable.icon_message_xitong,
                "产检提醒","","",1));
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_message);
        recyclerView.setLayoutManager(linearLayoutManager);
        recycleAdapter = new MessageRecyclerAdapter(msgList);
        recyclerView.setAdapter(recycleAdapter);
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh);
        mContentView = rootView.findViewById(R.id.cv_message);
        ScreenUtils.addTransParentStatusView(getActivity(),mContentView);
    }

    private void handleRefresh() {
        //mSwipeRefreshLayout.setColorSchemeResources(R.color.pink,R.color.purple_200,R.color.white);
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
                ItemDataMessage data = new ItemDataMessage(R.drawable.icon_message_shequ,
                        "社区消息","KiKi@了你","刚刚",1);
                msgList.add(0,data);
                //更新UI
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //这里做两件事，一件是让刷新停止，另一件是更新列表
                        recycleAdapter.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                },1000);
            }
        });
    }


}
