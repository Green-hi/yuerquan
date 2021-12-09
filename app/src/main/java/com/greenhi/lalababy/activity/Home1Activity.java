package com.greenhi.lalababy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.greenhi.lalababy.R;

public class Home1Activity extends AppCompatActivity {

    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        tvContent = findViewById(R.id.tv_content_home1);
        tvContent.setText("0——1岁幼儿发展特点：\n" +
                "一、0-1岁宝宝发展特点\n" +
                "视觉\n" +
                "线条明显、简单、颜色对比明显(黑白)的东西，可让婴儿的视觉得到更多的刺激，同时促进大脑轴突的成长与连接。\n" +
                "听觉\n" +
                "避免给婴儿听音波太强或太过刺激的音乐，应以音律稳定、节奏明确的音乐为主，如古典音乐或各种演奏曲，如此可建立婴儿的乐感、缓和婴儿的情绪。\n" +
                "味觉\n" +
                "给婴儿的食物应以原味、清淡为主，避免口味太重的食物。\n" +
                "触觉\n" +
                "多给予婴儿触摸及按摩，加强其感觉训练，增加大脑的神经连结及讯息传导，如此可让婴儿的学习能力增强、反应速度增快。此外“爬行”对婴儿感觉统合、肢体平衡及语言发展相当重要，要尽量让他多爬。\n" +
                "二、0-1岁宝宝智力发展的关键期\n" +
                "0-3个月：翻身期\n" +
                "宝宝出生后的头3个月，父母会发现他不喜欢安稳地平躺在床上，他要尝试着变换姿势，从更多的方向来认识世界。父母可经常在不同的方位逗引宝宝，促使宝宝熟练地翻身。可能刚开始宝宝翻过身后抽不出手，父母可给予一定的帮助，慢慢地训练宝宝自己将手放好，灵巧地翻身，自由地选择姿势，为进一步的活动打下基础。\n" +
                "3-6个月：坐立期\n" +
                "经过了俯卧抬头、翻身等动作的训练，宝宝颈部、前臂、腰部等处的肌肉力量逐渐增强，改变姿势的要求也越来越多，此时可试着将宝宝拉坐起来。\n" +
                "6-8个月：爬行期\n" +
                "爬是宝宝的一项重要活动，对他的成长非常有益。有利于锻炼宝宝颈部肌肉、胳膊及腕的力量，对今后用勺子吃饭和写字都有好处，此外，爬行时需要上肢及下肢的共同参与，并要保持动作的协调一致，有利于锻炼宝宝的协调能力，增强动作的灵活性。爬还有益于宝宝的骨骼及神经器官的发育，当宝宝的动作明显不协调时，能及早发现宝宝的健康问题。\n" +
                "出生后6个月是婴儿学习咀嚼和喂干食物的关键年龄，进干食物正个月后，就能伸手抓东西，过了这个关键年龄，婴儿就可能拒绝咀嚼从口中吐出食物。\n" +
                "中生后9个日至1岁是分辨多少，大小的开始。");
    }
}