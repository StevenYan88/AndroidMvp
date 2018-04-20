package com.steven.mvp;

import android.support.annotation.NonNull;

import com.steven.mvp.base.BasePresenter;
import com.steven.mvp.model.BaseResult;
import com.steven.mvp.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Description:
 * Data：3/27/2018-9:54 AM
 *
 * @author: yanzhiwen
 */
public class UserInfoPresenter extends BasePresenter<UserInfoContract.UserInfoView, UserInfoModel> implements UserInfoContract.UserInfoPresenter {
    @Override
    public void getUserInfo(String userName) {
        getView().onLoading();
        getModel().getUserInfo(userName).enqueue(new Callback<BaseResult<User>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResult<User>> call, @NonNull Response<BaseResult<User>> response) {
                BaseResult<User> userBaseResult = response.body();
                if (response.isSuccessful() && userBaseResult != null) {
                    if (userBaseResult.getCode() == Constant.SUCCESS_CODE && userBaseResult.getData() != null) {
                        getView().onSuccess(userBaseResult.getData());
                    } else {
                        getView().onError(userBaseResult.getCode(), userBaseResult.getMsg());
                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<BaseResult<User>> call, @NonNull Throwable t) {
                getView().onError(Constant.SERVER_EXCEPTION, t.getMessage());
            }
        });
    }
}
