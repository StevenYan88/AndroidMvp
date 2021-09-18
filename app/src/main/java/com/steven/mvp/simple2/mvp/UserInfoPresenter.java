package com.steven.mvp.simple2.mvp;

import com.steven.mvp.httpClient.HttpCallback;
import com.steven.mvp.model.User;
import com.steven.mvp.simple2.base.BasePresenter;



/**
 * Description:
 * Data：5/10/2018-9:20 AM
 *
 * @author: yanzhiwen
 */
public class UserInfoPresenter extends BasePresenter<UserInfoContract.UserInfoView, UserInfoModel> implements UserInfoContract.UserInfoPresenter {
    @Override
    public void getUserInfo(String userName) {
        getView().onLoading();
        getModel().getUserInfo(userName, new HttpCallback<User>() {
            @Override
            public void onSuccess(User user) {
                getView().onSuccess(user);

            }

            @Override
            public void onFail(int code, String error) {
                getView().onError(code, error);
            }
        });

    }
}
