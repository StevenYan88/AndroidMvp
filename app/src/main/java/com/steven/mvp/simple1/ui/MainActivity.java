package com.steven.mvp.simple1.ui;

import android.widget.TextView;

import com.steven.mvp.R;
import com.steven.mvp.simple1.base.BaseMvpActivity;
import com.steven.mvp.model.User;
import com.steven.mvp.simple1.mvp.UserInfoContract;
import com.steven.mvp.simple1.mvp.UserInfoPresenter;

/**
 * View层-视图层
 */
public class MainActivity extends BaseMvpActivity<UserInfoPresenter>
        implements UserInfoContract.UserInfoView {
    private TextView mTextView;

    /**
     * 创建Presenter
     *
     * @return Presenter
     */
    @Override
    protected UserInfoPresenter createPresenter() {
        return new UserInfoPresenter();
    }

    /**
     * 返回Activity的布局Id
     *
     * @return
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化View
     */
    @Override
    protected void initView() {
        mTextView = findViewById(R.id.tv);

    }

    /**
     * 在这里去请求数据
     */
    @Override
    protected void initData() {
        getPresenter().getUserInfo("Steven");
    }

    /**
     * 显示一个加载的进度条
     */
    @Override
    public void onLoading() {

    }

    /**
     * 请求数据成功回调该方法
     *
     * @param user
     */
    @Override
    public void onSuccess(User user) {
        mTextView.setText("Hello：" + user.getUserName());
    }

    /**
     * 请求数据失败回调该方法
     */
    @Override
    public void onError(int code, String errorMessage) {

    }
}
