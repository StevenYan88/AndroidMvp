package com.steven.mvp;

import com.steven.mvp.httpClient.RetrofitClient;
import com.steven.mvp.base.BaseModel;
import com.steven.mvp.model.BaseResult;
import com.steven.mvp.model.User;

import retrofit2.Call;

/**
 * Description:
 * Data：3/27/2018-9:58 AM
 *
 * @author: yanzhiwen
 */
public class UserInfoModel extends BaseModel implements UserInfoContract.UserModel {
    @Override
    public Call<BaseResult<User>> getUserInfo(String userName) {
        return RetrofitClient.getServiceApi().getUser(userName);
    }
}
