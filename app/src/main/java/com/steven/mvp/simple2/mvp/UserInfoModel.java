package com.steven.mvp.simple2.mvp;

import android.support.annotation.NonNull;

import com.steven.mvp.Constant;
import com.steven.mvp.httpClient.HttpCallback;
import com.steven.mvp.httpClient.RetrofitClient;
import com.steven.mvp.model.BaseResult;
import com.steven.mvp.model.User;
import com.steven.mvp.simple2.base.BaseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Description:
 * Data：5/10/2018-9:20 AM
 *
 * @author: yanzhiwen
 */
public class UserInfoModel extends BaseModel implements UserInfoContract.UserModel {
    @Override
    public void getUserInfo(String userName, final HttpCallback<User> httpCallback) {
        RetrofitClient.getServiceApi().getUser(userName).enqueue(new Callback<BaseResult<User>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResult<User>> call, @NonNull Response<BaseResult<User>> response) {
                BaseResult<User> userBaseResult = response.body();
                if (response.isSuccessful() && userBaseResult != null) {
                    if (userBaseResult.getCode() == Constant.SUCCESS_CODE && userBaseResult.getData() != null) {
                        httpCallback.onSuccess(userBaseResult.getData());
                    } else {
                        httpCallback.onFail(userBaseResult.getCode(), userBaseResult.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResult<User>> call, @NonNull Throwable t) {
                httpCallback.onFail(Constant.SERVER_EXCEPTION, t.getMessage());

            }
        });
    }
}
