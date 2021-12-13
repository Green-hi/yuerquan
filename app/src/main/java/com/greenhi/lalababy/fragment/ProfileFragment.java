package com.greenhi.lalababy.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.activity.SetActivity;
import com.greenhi.lalababy.adapter.ProfileRecyclerAdapter;
import com.greenhi.lalababy.item.ItemDataProfile;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    public static final String ARG_TEXT = "param1";

    private Context mContext;
    private String mTextString;
    private View rootView;
    private RecyclerView recyclerView;
    private ProfileRecyclerAdapter recycleAdapter;

    private List<ItemDataProfile> toolList;

    public ProfileFragment(){

    }

    public static ProfileFragment newInstance(String param1) {
        Bundle args = new Bundle();
        ProfileFragment fragment = new ProfileFragment();
        args.putString(ARG_TEXT,param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mTextString = getArguments().getString(ARG_TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(rootView == null){
            rootView = inflater.inflate(R.layout.fragment_profile,container,false);
        }
        Log.e("TAG4544", "onCreateView: ProfileFragment");
        initData();
        initView();
        return rootView;
    }

    private void initView() {
        TextView textView = rootView.findViewById(R.id.textView);
        //textView.setText(mTextString);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_profile);
        recyclerView.setLayoutManager(linearLayoutManager);
        recycleAdapter = new ProfileRecyclerAdapter(toolList, new ProfileRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                setListener(position);
            }
        });
        recyclerView.setAdapter(recycleAdapter);
    }

    private void setListener(int position) {
        switch (position){
            case 0:
                Toast.makeText(mContext,"个人主页",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(mContext,"宝宝设置",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(mContext,"乐豆中心",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(mContext,"我的卡券",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(mContext,"我的收藏",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(mContext,"技术咨询",Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(mContext,"推荐给好友",Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(mContext,"服务条款",Toast.LENGTH_SHORT).show();
                break;
            case 8:
                Intent intent8 = new Intent(mContext, SetActivity.class);
                startActivity(intent8);
                break;
            default:
                break;
        }
    }

    private void initData(){
        toolList = new ArrayList<>();
        toolList.add(new ItemDataProfile(R.mipmap.mine_my,"个人主页","记录我的轨迹",0));
        toolList.add(new ItemDataProfile(R.mipmap.mine_jqset,"宝宝设置","",0));
        toolList.add(new ItemDataProfile(R.mipmap.mine_ledou,"乐豆中心","共有30乐豆",1));
        toolList.add(new ItemDataProfile(R.mipmap.mine_ticket,"我的卡券","",0));
        toolList.add(new ItemDataProfile(R.mipmap.mine_sc,"我的收藏","",1));
        toolList.add(new ItemDataProfile(R.mipmap.mine_kefu,"技术咨询","",0));
        toolList.add(new ItemDataProfile(R.mipmap.mine_tj,"推荐给好友","",0));
        toolList.add(new ItemDataProfile(R.mipmap.mine_xieyi,"服务条款","",0));
        toolList.add(new ItemDataProfile(R.mipmap.mine_set,"系统设置","",1));
    }
}