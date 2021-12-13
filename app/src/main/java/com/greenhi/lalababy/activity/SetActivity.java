package com.greenhi.lalababy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.greenhi.lalababy.R;

public class SetActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        tvLogout=findViewById(R.id.tv_logout);
        tvLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_logout:
                navigateTo(LoginActivity.class);
                break;
            default:
                break;
        }
    }
}