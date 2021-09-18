package com.steven.mvp.httpClient;

/**
 * @description: 处理网络监听的回调接口
 * @create: 2021-09-18
 * @author: yanzhiwen
 */
public interface HttpCallback<T> {
    void onSuccess(T t);

    void onFail(int code, String error);
}
