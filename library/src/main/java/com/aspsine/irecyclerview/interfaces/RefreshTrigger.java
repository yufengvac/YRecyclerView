package com.aspsine.irecyclerview.interfaces;

/**
 * Created by yufeng on 2018年2月27日16:39:40
 */
public interface RefreshTrigger {

    void onStart(boolean automatic, int headerHeight, int finalHeight);

    void onMove(boolean finished, boolean automatic, int moved);

    void onRefresh();

    void onRelease();

    void onComplete();

    void onReset();
}
