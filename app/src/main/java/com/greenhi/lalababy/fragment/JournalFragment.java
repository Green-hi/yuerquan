package com.greenhi.lalababy.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.activity.AddDiaryActivity;
import com.greenhi.lalababy.adapter.JournalRecyclerAdapter;
import com.greenhi.lalababy.item.ItemDataJournal;
import com.greenhi.lalababy.resultUnit.DiaryResult;
import com.greenhi.lalababy.retrofit.API;
import com.greenhi.lalababy.retrofit.RetrofitManager;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JournalFragment extends Fragment {
    private static final String TAG = "FYuerQuan2021";
    private API mApi;

    private Context mContext;
    private View rootView;
    private RecyclerView recyclerView;
    private JournalRecyclerAdapter recycleAdapter;
    private ViewGroup mContentView;

    private static List<DiaryResult.DataDTO> journals;

    public static JournalFragment newInstance() {
        Bundle args = new Bundle();
        JournalFragment fragment = new JournalFragment();
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
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_joural, container, false);
        }
        Log.e("TAG4544", "onCreateView: JournalFragment");
        initData();
        initView();
        return rootView;
    }

    @Override
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
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView = rootView.findViewById(R.id.rv_journal);
        recyclerView.setLayoutManager(linearLayoutManager);
        recycleAdapter = new JournalRecyclerAdapter(journals);
        recyclerView.setAdapter(recycleAdapter);
        mContentView = rootView.findViewById(R.id.cv_community);
    }

    private void initData() {
        mApi = RetrofitManager.getRetrofit().create(API.class);
        journals = new ArrayList<DiaryResult.DataDTO>();

//        journals.add(new ItemDataJournal("09","2021/3","3月9天","百日纪念","宝宝今天终于百日啦！妈妈爱你！"));
//        journals.add(new ItemDataJournal("09","2021/3","3月9天","百日纪念","宝宝今天终于百日啦！妈妈爱你！"));
//        journals.add(new ItemDataJournal("09","2021/3","3月9天","百日纪念","宝宝今天终于百日啦！妈妈爱你！"));
//        journals.add(new ItemDataJournal("09","2021/3","3月9天","百日纪念","宝宝今天终于百日啦！妈妈爱你！"));
//        journals.add(new ItemDataJournal("09","2021/3","3月9天","百日纪念","宝宝今天终于百日啦！妈妈爱你！"));
//        journals.add(new ItemDataJournal("09","2021/3","3月9天","百日纪念","宝宝今天终于百日啦！妈妈爱你！"));

        Call<DiaryResult> task = mApi.getDiaryAll();
        task.enqueue(new Callback<DiaryResult>() {
            @Override
            public void onResponse(Call<DiaryResult> call, Response<DiaryResult> response) {
                Log.e(TAG, "onResponse--> " + response);
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    DiaryResult result = response.body();
                    Log.e(TAG, "responseBody --> " + result);
                    if (result.getCode() == 100) {
                        Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_SHORT).show();
                        journals = result.getData();
                        Log.i(TAG, "journals: " + journals.get(1).toString());
                        Message message = new Message();
                        message.obj=journals;
                        mHandler.sendMessage(message);
                    } else {
                        Toast.makeText(getActivity(), result.getCode() + " " + result.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DiaryResult> call, Throwable t) {
                Log.e(TAG, "onFailure --> " + t.toString());
                Toast.makeText(getActivity(), "连接失败！请检查网络连接", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                List<DiaryResult.DataDTO> listData = (List<DiaryResult.DataDTO>) msg.obj;
                recycleAdapter = new JournalRecyclerAdapter(listData);
                recyclerView.setAdapter(recycleAdapter);
            }
        }
    };
}