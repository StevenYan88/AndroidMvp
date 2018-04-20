package com.steven.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Description:
 * Data：3/27/2018-9:20 AM
 *
 * @author: yanzhiwen
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //创建Presenter,交给子类去实现
        mPresenter = createPresenter();
        //让P层去绑定V
        mPresenter.attach(this);
        initView();
        initData();

    }

    protected abstract P createPresenter();

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    public P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }
}
