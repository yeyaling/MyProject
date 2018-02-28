package com.example.john.viewpagerproject.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2016/11/12.
 */
public class AFrameLayout extends FrameLayout {
    public AFrameLayout(Context context) {
        super(context);
    }

    public AFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        return false;
//    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.e(tag, "--onTouchEvent--D");
//        return false;
//    }
}
