package com.example.john.viewpagerproject.view;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zhy.magicviewpager.transformer.BasePageTransformer;
import com.zhy.magicviewpager.transformer.NonPageTransformer;

/**
 * Created by john on 2016/11/8.
 */
public class MyRotateDownPageTransformer extends BasePageTransformer
{
    private static final float DEFAULT_MAX_ROTATE = 10.0f;
    private float mMaxRotate = DEFAULT_MAX_ROTATE;

    public MyRotateDownPageTransformer()
    {
    }

    public MyRotateDownPageTransformer(float maxRotate)
    {
        this(maxRotate, NonPageTransformer.INSTANCE);
    }

    public MyRotateDownPageTransformer(ViewPager.PageTransformer pageTransformer)
    {
        this(DEFAULT_MAX_ROTATE, pageTransformer);
    }

    public MyRotateDownPageTransformer(float maxRotate, ViewPager.PageTransformer pageTransformer)
    {
        mPageTransformer = pageTransformer;
        mMaxRotate = maxRotate;
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void pageTransform(View view, float position)
    {
        if (position < -1)
        { // [-Infinity,-1)
            // This page is way off-screen to the left.


//            view.setRotation(mMaxRotate * -2);
//            view.setPivotX(view.getWidth());
//            view.setPivotY(view.getHeight());
            view.setPivotX(view.getWidth() * (DEFAULT_CENTER + DEFAULT_CENTER * (-position)));
            view.setPivotY(view.getHeight());
            view.setRotation(mMaxRotate * position);

        } else if (position <= 1)
        { // [-1,1]

            if (position < 0)//[0，-1]
            {
                view.setPivotX(view.getWidth() * (DEFAULT_CENTER + DEFAULT_CENTER * (-position)));
                view.setPivotY(view.getHeight());
                view.setRotation(mMaxRotate * position);
            } else//[1,0]
            {
                view.setPivotX(view.getWidth() * DEFAULT_CENTER * (1 - position));
                view.setPivotY(view.getHeight());
                view.setRotation(mMaxRotate * position);
            }
        } else
        { // (1,+Infinity]
            // This page is way off-screen to the right.
//            view.setRotation(mMaxRotate*2);
//            view.setPivotX(view.getWidth() * 0);
//            view.setPivotY(view.getHeight());
            view.setPivotX(view.getWidth() * DEFAULT_CENTER * (1 - position));
            view.setPivotY(view.getHeight());
            view.setRotation(mMaxRotate * position);
        }
    }
}