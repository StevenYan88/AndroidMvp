package com.steven.mvp.httpClient;

import com.steven.mvp.model.BaseResult;
import com.steven.mvp.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Description:
 * Data：3/27/2018-10:02 AM
 *
 * @author: yanzhiwen
 */
public interface ServiceApi {
    @POST("LoginServlet")
    @FormUrlEncoded
    Call<BaseResult<User>> getUser(@Field("userName") String userName);
}
