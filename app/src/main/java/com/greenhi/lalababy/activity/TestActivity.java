package com.greenhi.lalababy.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.greenhi.lalababy.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);

        // 经过配置之后必须调用代码设置内容才会显示
        ExpandableTextView expand_layout= (ExpandableTextView) findViewById(R.id.expand_layout);
        //setText();传入你需要展示内容的参数
        expand_layout.setText(getString(R.string.test_text));
    }

}
