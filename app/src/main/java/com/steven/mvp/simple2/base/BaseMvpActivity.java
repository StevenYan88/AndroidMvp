package com.steven.mvp.simple2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.steven.mvp.simple1.BaseView;
import com.steven.mvp.simple2.inject.InjectPresenter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Data：5/10/2018-9:20 AM
 * <p>
 * author: yanzhiwen
 */
public abstract class BaseMvpActivity extends AppCompatActivity implements BaseView {
    // private P mPresenter;
    //一个View 里面肯定有多个Presenter情况，怎么处理，Dagger处理
    private List<BasePresenter> mPresenters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPresenters = new ArrayList<>();
        //1 Activity ? ViewGroupMvpProxy ? Fragment?抽离 工具类抽出去，或者把每个代码copy一份
        //今天你可以抽离目前一部分 注入代码+额外功能+还有一些其他的地方有不一样
        //注入Presenter 通过反射(或者Dagger)
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectPresenter injectPresenter = field.getAnnotation(InjectPresenter.class);
            if (injectPresenter != null) {
                //创建注入
                Class<? extends BasePresenter> presenterClazz = null;
                try {
                    //获取这个类
                    presenterClazz = ( Class<? extends BasePresenter> ) field.getType();
                } catch (Exception e) {
                    // 乱七八糟一些注入
                    throw new RuntimeException("not support inject presenter" + field.getType());
                }
                try {
                    //创建BasePresenter对象
                    BasePresenter basePresenter = presenterClazz.newInstance();
                    //attach
                    basePresenter.attach(this);
                    mPresenters.add(basePresenter);
                    field.setAccessible(true);
                    field.set(this, basePresenter);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        initView();
        initData();
    }


    protected abstract void initView();

    protected abstract void initData();

    public abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑Presenter
        for (BasePresenter presenter : mPresenters) {
            presenter.detach();
        }
    }
}
