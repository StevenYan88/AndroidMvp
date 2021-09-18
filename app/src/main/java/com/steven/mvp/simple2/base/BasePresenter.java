package com.steven.mvp.simple2.base;

import com.steven.mvp.simple1.BaseView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

/**
 * Description:
 * Data：5/10/2018-9:20 AM
 *
 * @author: yanzhiwen
 */
public class BasePresenter<V extends BaseView, M extends BaseModel> {
    private V mView;
    private M mModel;

    /**
     * 绑定View
     *
     * @param view 需要绑定的视图View层
     */
    public  void attach(final V view) {
        //动态代理
        mView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //在View层显示数据之前用户可能退出了View层的页面，会在Activity的onDestroy()方法中会把mView置为null
                //由于View层都是接口，这里采用了动态代理，如果在View层显示数据之前用户可能退出了View层的页面，返回null的话，onSuccess()方法不会执行
                if (mView == null) {
                    return null;
                }
                //每次调用View层接口的方法，都会执行这里
                return method.invoke(view, args);
            }
        });
        //动态创建Model？怎么创建创建？？？用反射创建
        Type[] params = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
        try {
            //最好是判断下类型
            mModel = (M) ((Class) params[1]).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解绑View
     */
    public void detach() {
        mView = null;
        mModel = null;
    }

    public V getView() {
        return mView;
    }

    public M getModel() {
        return mModel;
    }
}
