package com.steven.mvp.simple1.mvp;

import com.steven.mvp.httpClient.RetrofitClient;
import com.steven.mvp.model.BaseResult;
import com.steven.mvp.model.User;
import com.steven.mvp.simple1.base.BaseModel;

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
