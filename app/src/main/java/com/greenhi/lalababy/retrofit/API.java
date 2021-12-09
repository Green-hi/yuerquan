package com.greenhi.lalababy.retrofit;

import com.greenhi.lalababy.domain.UserBase;
import com.greenhi.lalababy.domain.UserExtend;
import com.greenhi.lalababy.item.ItemDataCommunity;
import com.greenhi.lalababy.item.ItemDataJournal;
import com.greenhi.lalababy.resultUnit.CommunityResult;
import com.greenhi.lalababy.resultUnit.DiaryResult;
import com.greenhi.lalababy.resultUnit.PostResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {

    @POST("/yuerquan/user-base/add")
    Call<PostResult> addUserBase(@Body UserBase userBase);

    @POST("/yuerquan/user-extend/add")
    Call<PostResult> addUserExtend(@Body UserExtend userExtend);

    @FormUrlEncoded
    @POST("/yuerquan/user-base/login")
    Call<PostResult> login(@Field("account") String account, @Field("password") String password);

    @GET("/yuerquan/diary/getAllPaging")
    Call<PostResult> getJournalsPaging(@Query("pageNo") Integer pageNo, @Query("pageSize") Integer pageSize);

    @GET("/yuerquan/community/getAllPaging")
    Call<CommunityResult> getComPaging(@Query("pageNo") Integer pageNo, @Query("pageSize") Integer pageSize);

    @GET("/yuerquan/community/getItemAll")
    Call<CommunityResult> getComAll();

    @POST("/yuerquan/community/add")
    Call<PostResult> postCom(@Body ItemDataCommunity itemDataCommunity);

    @POST("/yuerquan/diary/add")
    Call<PostResult> postDiary(@Body ItemDataJournal itemDataJournal);

    @GET("/yuerquan/diary/getItemAll")
    Call<DiaryResult> getDiaryAll();

}
