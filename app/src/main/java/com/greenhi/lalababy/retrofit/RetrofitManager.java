package com.greenhi.lalababy.retrofit;

import okhttp3.HttpUrl;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.0.2.2:8880")   //在模拟器上用10.0.2.2访问你的电脑本机
            .build();

    public static Retrofit getRetrofit(){
        return retrofit;
    }
}
