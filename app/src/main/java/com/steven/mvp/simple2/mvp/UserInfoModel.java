package com.steven.mvp.simple2.mvp;

import com.steven.mvp.httpClient.RetrofitClient;
import com.steven.mvp.model.BaseResult;
import com.steven.mvp.model.User;
import com.steven.mvp.simple2.base.BaseModel;

import retrofit2.Call;

/**
 * Description:
 * Data：5/10/2018-9:20 AM
 *
 * @author: yanzhiwen
 */
public class UserInfoModel extends BaseModel implements UserInfoContract.UserModel {
    @Override
    public Call<BaseResult<User>> getUserInfo(String userName) {
        return RetrofitClient.getServiceApi().getUser(userName);
    }
}
