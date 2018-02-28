package com.yufeng.yrecyclerview.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.aspsine.irecyclerview.interfaces.RefreshTrigger;

/**
 * Created by yufeng on 2018/2/27-0027.
 *
 */

public class HeaderView extends FrameLayout implements RefreshTrigger{

    public HeaderView(@NonNull Context context) {
        this(context, null);
    }

    public HeaderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeaderView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onStart(boolean automatic, int headerHeight, int finalHeight) {

    }

    @Override
    public void onMove(boolean finished, boolean automatic, int moved) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onRelease() {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onReset() {

    }
}
