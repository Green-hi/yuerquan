package com.greenhi.lalababy.retrofit;

import com.greenhi.lalababy.domain.UserBase;
import com.greenhi.lalababy.resultUnit.PostResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {

    @POST("/yuerquan/user-base/add")
    Call<PostResult> addUserBase(@Body UserBase userBase);

}
