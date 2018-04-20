package com.steven.mvp.httpClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Description:
 * Data：3/27/2018-10:00 AM
 *
 * @author: yanzhiwen
 */
public class RetrofitClient {
    private static final ServiceApi mServiceApi;
    //本地主机的地址
    private static final String BASE_URL = "http://192.168.10.92:8080/OkHttpServer/";

    static {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //创建一个ServiceApi实例对象
        mServiceApi = retrofit.create(ServiceApi.class);
    }

    public static ServiceApi getServiceApi() {
        return mServiceApi;
    }
}
