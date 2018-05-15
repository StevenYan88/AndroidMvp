package com.steven.mvp.simple1.mvp;

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
    //View层
    public interface UserInfoView extends BaseView {
        void onLoading();

        void onSuccess(User user);

        void onError(int code, String errorMessage);

    }

    //Presenter层
    interface UserInfoPresenter {
        void getUserInfo(String userName);
    }

    //Model层，外部只需关心Model返回的数据,无需关心内部细节
    interface UserModel {
        Call<BaseResult<User>> getUserInfo(String userName);
    }
}
