package com.steven.mvp.simple2.mvp;

import com.steven.mvp.model.BaseResult;
import com.steven.mvp.model.User;
import com.steven.mvp.simple1.BaseView;

import retrofit2.Call;

/**
 * Description:
 * Data：5/10/2018-9:20 AM
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
