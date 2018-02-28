package com.aspsine.irecyclerview.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.irecyclerview.R;
import com.aspsine.irecyclerview.interfaces.LoadMoreTrigger;

/**
 * Created by yufeng on 2018/2/27-0027.
 *
 */

public class RecyclerFooterView extends FrameLayout implements LoadMoreTrigger{

    private ImageView imageView;
    private TextView textView;
    private Context mContext;
    public RecyclerFooterView(@NonNull Context context) {
        this(context, null);
    }

    public RecyclerFooterView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecyclerFooterView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        View view = inflate(context, R.layout.layout_irecyclerview_load_more_footer,this);
        imageView = (ImageView) view.findViewById(R.id.load_more_footer_iv);
        textView = (TextView) view.findViewById(R.id.load_more_footer_tv);
        AnimationDrawable drawable = (AnimationDrawable) imageView.getDrawable();
        drawable.start();
    }

    @Override
    public void onReset() {
        textView.setText(mContext.getString(R.string.load_more_loading));
        AnimationDrawable drawable = (AnimationDrawable) imageView.getDrawable();
        drawable.start();
        imageView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoadFailed(String msg) {
        textView.setText(msg);
        AnimationDrawable drawable = (AnimationDrawable) imageView.getDrawable();
        drawable.stop();
        imageView.setVisibility(View.GONE);
    }

    @Override
    public void onNoMoreData() {
        textView.setText(mContext.getString(R.string.load_more_load_no_data));
        AnimationDrawable drawable = (AnimationDrawable) imageView.getDrawable();
        drawable.stop();
        imageView.setVisibility(View.GONE);
    }
}
