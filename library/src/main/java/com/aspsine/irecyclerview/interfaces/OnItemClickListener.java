package com.aspsine.irecyclerview.interfaces;

import android.view.View;

/**
 * Created by yufeng on 2018/2/27-0027.
 *
 */

public interface OnItemClickListener<T> {
    void onItemClick(int position, T t, View v);
}
