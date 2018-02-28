package com.aspsine.irecyclerview.interfaces;

/**
 * Created by yufeng on 2018/2/27-0027.
 *
 */

public interface LoadMoreTrigger {
    void onReset();
    void onLoadFailed(String msg);
    void onNoMoreData();
}
