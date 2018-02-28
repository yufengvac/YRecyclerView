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
import com.aspsine.irecyclerview.interfaces.RefreshTrigger;

/**
 * Created by yufeng on 2018/2/27-0027.
 *
 */

public class RecyclerHeaderView extends FrameLayout implements RefreshTrigger{

    private ImageView imageView;
    private TextView textView;
    private Context context;
    private int mHeight;

    public RecyclerHeaderView(@NonNull Context context) {
        this(context, null);
    }

    public RecyclerHeaderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecyclerHeaderView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        View view = inflate(context, R.layout.layout_irecyclerview_refresh_header, this);
        imageView = (ImageView) view.findViewById(R.id.refresh_header_iv);
        textView = (TextView) view.findViewById(R.id.refresh_header_tv);
    }


    @Override
    public void onStart(boolean automatic, int headerHeight, int finalHeight) {
        mHeight = headerHeight;
    }

    @Override
    public void onMove(boolean finished, boolean automatic, int moved) {
        if (!finished){
            if (moved <= mHeight ){
                textView.setText(context.getString(R.string.refresh_to_load));
            }else {
                textView.setText(context.getString(R.string.refresh_release));
            }
        }
    }

    @Override
    public void onRefresh() {
        textView.setText(context.getString(R.string.refresh_loading));
    }

    @Override
    public void onRelease() {
        textView.setText(context.getString(R.string.refresh_release));
        AnimationDrawable drawable = (AnimationDrawable) imageView.getDrawable();
        drawable.start();
    }

    @Override
    public void onComplete() {
        AnimationDrawable drawable = (AnimationDrawable) imageView.getDrawable();
        drawable.stop();
        drawable.setLevel(1);
        textView.setText(context.getString(R.string.refresh_load_complete));
    }

    @Override
    public void onReset() {
        AnimationDrawable drawable = (AnimationDrawable) imageView.getDrawable();
        drawable.stop();
        drawable.setLevel(1);
        textView.setText(context.getString(R.string.refresh_to_load));
    }
}
