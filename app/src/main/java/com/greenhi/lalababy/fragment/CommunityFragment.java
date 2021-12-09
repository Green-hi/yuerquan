package com.greenhi.lalababy.fragment;

import static android.app.Activity.RESULT_OK;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.activity.AddCommunityActivity;
import com.greenhi.lalababy.activity.AddDiaryActivity;
import com.greenhi.lalababy.adapter.CommunityRecyclerAdapter;
import com.greenhi.lalababy.item.ItemDataCommunity;
import com.greenhi.lalababy.resultUnit.CommunityResult;
import com.greenhi.lalababy.retrofit.API;
import com.greenhi.lalababy.retrofit.RetrofitManager;
import com.greenhi.lalababy.utils.ScreenUtils;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommunityFragment extends Fragment {

    private static final String TAG = "FYuerQuan2021";
    private API mApi;

    private Context mContext;
    private View rootView;
    private RecyclerView recyclerView;
    private CommunityRecyclerAdapter recycleAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ViewGroup mContentView;

    private List<CommunityResult.DataDTO> comList;

    public static CommunityFragment newInstance() {
        Bundle args = new Bundle();
        CommunityFragment fragment = new CommunityFragment();
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
            rootView = inflater.inflate(R.layout.fragment_community, container, false);
        }
        Log.e("TAG4544", "onCreateView: CommunityFragment");
        initData();
        initView();
        handleRefresh();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView addCommunity = getView().findViewById(R.id.add_community);
        addCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getArguments();
                String phoneNum = (String) bundle.get("phoneNum");
                Log.e(TAG, "CommunityFragment phoneNum--> "+phoneNum );
                Intent intent = new Intent(getActivity(), AddCommunityActivity.class);
                intent.putExtra("phoneNum",phoneNum);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        comList = new ArrayList<>();
        List<Integer> comImgList = new ArrayList<>();
        comImgList.add(R.drawable.com_img1);
        List<Integer> comImgList1 = new ArrayList<>();
        comImgList.add(R.drawable.com_img4);
//        comList.add(new ItemDataCommunity(
//                R.mipmap.login_icon,"深色的金毛","宝宝2年11月","20分钟前","","3","1"
//                ,"大宝中午吃了一个半的烧麦，喝了一瓶奶，下午五点多突然呕吐了，买了神曲给他煮起来喝，喝完马.上吐了，给他一颗健胃 消食片又吐" +
//                "了，七点困了睡前喝了130的奶，过一会又吐了，于是赶紧跑医院来，挂了急诊，做了B超，要留观，加了1000到卡里，验血，打点滴，拍片。打好点滴12点" +
//                "多了，还要去拍片，好折腾。真的烦我老公，上次带儿子去一鸣吃糯米做的东西当场吃完就吐了，再之前一次也是这样，这次又来这样，真的服了，我儿子吃" +
//                "东西又快不爱咀嚼，估计消化不好了。下周二要剖了，希望都顺顺利利的。到时还打算让我大宝和老公睡另外房间，今天对医院的床那是很抗拒的，估计我坐" +
//                "月子他还是要认自己原先的床了!要躺我旁边来了。",null));
//        comList.add(new ItemDataCommunity(
//                R.drawable.head5,"daisy007","孕35周+2天","35分钟前","","0","8",
//                "美丽的天气  美丽的树叶",comImgList));
//        comList.add(new ItemDataCommunity(
//                R.drawable.head1,"伯爵小公举","孕26周","40分钟前","杭州市上城区九堡街道","4","0"
//                ,"我们这边怀孕晚期，亲戚会送大肚肉，我婆婆是-点也没有，我和她没有微信也没有联系，大宝那时候坐月子也没有照顾，就拿了几千块钱" +
//                "压岁钱。然后现在这胎我老公很想孩子跟他姓，我不同意，因为他那边是没有房子，也没有任何祖产，或者地分分的。属于山区。入赘我家不管几个都是跟" +
//                "我的。我估计我婆婆在背后挑唆的。他那边出去入赘的人很多，他家亲戚也有好几个出去入赘，都没有这样的。然后昨天大宝呕吐去医院我说开我的车，他" +
//                "那个车子七座经常运东西比较脏，他非要开他的车子，然后半开玩笑的说最起码他的车子目前是赚钱的。那难道说我在家带孩子现在二胎没有钱赚的意思吗?" +
//                "下周去医院生孩子出入院就开自己的车子，到时候我就说赚钱谁不会，生孩子没有哪个男人可以。",null));
//        comList.add(new ItemDataCommunity(
//                R.drawable.head2,"动人的橘子","宝宝八个月","1小时前","温州市瑞安市陶山镇","0","0"
//                ,"我家宝宝早起咳嗽差不多一个月了，具体多久也记不得了，每次都是早上起来咳几声，其他时间基本没咳，不知道是什么原因，平时都好" +
//                "好的，吃得好睡得香，也不知道什么原因，没带去看医生，跑一趟医院也太麻烦了，是什么慢性病吗？睡觉都没听到咳的。",null));
//        comList.add(new ItemDataCommunity(
//                R.drawable.head3,"小鹿","宝宝7月30天","5小时前","温州市瑞安市锦湖街道","7","3"
//                ,"闺女今天不发烧了，不咳嗽了，就还是流鼻涕，鼻塞，还我头疼，嗓子疼，流鼻涕还没好就发烧，一想想前两天她爸生病她去找她爸说：" +
//                "离爸爸远点爸爸生病了，人家又说：那怎么办？我还得上班你不带谁带？我发现了女人是打不倒的，不管来大姨妈还好，生病发烧也好，只要还能动，" +
//                "就得照顾孩子...",null));
//        comList.add(new ItemDataCommunity(
//                R.drawable.head4,"小美妞","孕39周+2天","一天前","温州市乐清市天成街道","0","4"
//                ,"乐清人民医院生产是要提前做核酸检测吗？医生会让提前住院吗？好紧张啊快足月了，没做核酸检测会不会让你进去？",null));
//        comList.add(new ItemDataCommunity(
//                R.drawable.head7,"我很爱你们","孕27周+3天","两天前","","3","1","夕" +
//                "阳无限好，只是近黄昏",comImgList1));
        mApi = RetrofitManager.getRetrofit().create(API.class);
        Call<CommunityResult> task = mApi.getComAll();
        task.enqueue(new Callback<CommunityResult>() {
            @Override
            public void onResponse(Call<CommunityResult> call, Response<CommunityResult> response) {
                Log.e(TAG, "onResponse--> " + response);
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    CommunityResult result = response.body();
                    Log.e(TAG, "responseBody --> " + result);
                    if (result.getCode() == 100) {
                        Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_SHORT).show();
                        comList = result.getData();
                        Log.e(TAG, "comList--> " + comList);
                        Message message = new Message();
                        message.obj = comList;
                        mHandler.sendMessage(message);
                    } else {
                        Toast.makeText(getActivity(), result.getCode() + " " + result.getMsg(), Toast.LENGTH_SHORT).show();
                        Log.e(TAG, result.getCode() + " " + result.getMsg());
                    }
                } else {
                    Toast.makeText(getActivity(), response.toString(), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, response.toString());
                }
            }

            @Override
            public void onFailure(Call<CommunityResult> call, Throwable t) {
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
                List<CommunityResult.DataDTO> listData = (List<CommunityResult.DataDTO>) msg.obj;
                recycleAdapter = new CommunityRecyclerAdapter(listData);
                recyclerView.setAdapter(recycleAdapter);
            }
        }
    };

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView = rootView.findViewById(R.id.rv_community);
        recyclerView.setLayoutManager(linearLayoutManager);
        recycleAdapter = new CommunityRecyclerAdapter(comList);
        recyclerView.setAdapter(recycleAdapter);
        mSwipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh);
        mContentView = rootView.findViewById(R.id.cv_community);
        ScreenUtils.addTransParentStatusView(getActivity(), mContentView);
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
                List<Integer> comImgList = new ArrayList<>();
                comImgList.add(R.drawable.com_img2);
                comImgList.add(R.drawable.com_img3);
//                ItemDataCommunity data = new ItemDataCommunity(R.drawable.head6, "草草", "宝宝2年8月27天", "刚刚", "", "2", "1"
//                        , "我的小宝贝帮麻麻吹头发", comImgList);
//                comList.add(0, data);
                Call<CommunityResult> task = mApi.getComAll();
                task.enqueue(new Callback<CommunityResult>() {
                    @Override
                    public void onResponse(Call<CommunityResult> call, Response<CommunityResult> response) {
                        Log.e(TAG, "onResponse--> " + response);
                        if (response.code() == HttpURLConnection.HTTP_OK) {
                            CommunityResult result = response.body();
                            Log.e(TAG, "responseBody --> " + result);
                            if (result.getCode() == 100) {
                                Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_SHORT).show();
                                comList = result.getData();
                                Log.e(TAG, "comList--> " + comList);
                                Message message = new Message();
                                message.obj = comList;
                                mHandler.sendMessage(message);
                            } else {
                                Toast.makeText(getActivity(), result.getCode() + " " + result.getMsg(), Toast.LENGTH_SHORT).show();
                                Log.e(TAG, result.getCode() + " " + result.getMsg());
                            }
                        } else {
                            Toast.makeText(getActivity(), response.toString(), Toast.LENGTH_SHORT).show();
                            Log.e(TAG, response.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<CommunityResult> call, Throwable t) {
                        Log.e(TAG, "onFailure --> " + t.toString());
                        Toast.makeText(getActivity(), "连接失败！请检查网络连接", Toast.LENGTH_SHORT).show();
                    }
                });
                //更新UI
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //这里做两件事，一件是让刷新停止，另一件是更新列表
                        recycleAdapter.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }
}
