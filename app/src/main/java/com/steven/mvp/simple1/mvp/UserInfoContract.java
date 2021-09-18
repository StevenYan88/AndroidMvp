package com.steven.mvp.simple1.mvp;

import com.steven.mvp.httpClient.HttpCallback;
import com.steven.mvp.simple1.BaseView;
import com.steven.mvp.model.BaseResult;
import com.steven.mvp.model.User;

import retrofit2.Call;

/**
 * Description:
 * Data：3/27/2018-9:19 AM
 *
 * @author: yanzhiwen
 */
public class UserInfoContract {
    //View层：视图层即Activity/Fragment
    public interface UserInfoView extends BaseView {
        void onLoading();

        void onSuccess(User user);

        void onError(int code, String errorMessage);

    }

    //Presenter层：处理业务逻辑
    interface UserInfoPresenter {
      void getUserInfo(String userName);
    }

    //Model层，处理数据层，比如请求网络，操作数据库等，外部只需关心Model返回的数据,无需关心内部细节
    interface UserModel {
       void getUserInfo(String userName,HttpCallback<User> httpCallback);
    }
}
