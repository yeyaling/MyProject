package com.example.john.viewpagerproject.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2017/7/19.
 */

public class MenuAnimator {
    private static ObjectAnimator animator1;
    private  static ObjectAnimator animator2;
    private  static ObjectAnimator animator3;
    private  static ObjectAnimator animator4;

    private static PropertyValuesHolder p1;
    private static PropertyValuesHolder p21;
    private static PropertyValuesHolder p22;
    private static PropertyValuesHolder p31;
    private static PropertyValuesHolder p32;
    private static PropertyValuesHolder p4;
    private static AnimatorSet set = new AnimatorSet();
    private static AnimatorSet setClose = new AnimatorSet();
    private static AnimatorSet animSet;
    private static boolean isShow = true;
    private static Activity activity;
    private static List<Animator> objectAnimators = new ArrayList<>();
    private static View tempImageView;

    public static boolean showCloseIcon(final Activity context, final List<View> viewList,final boolean ifShow) {
        isShow=!ifShow;
        activity = context;
        objectAnimators.clear();
        //动画距离,屏幕宽度的25%
        float distance = getScreenWidth()*0.25f;
        float angle = 90/(viewList.size()-1);
        //相邻ImageView运动角度式22.5度
        float angle1 = (float)(angle*Math.PI/180);
        float angle2 = (float)(angle*2*Math.PI/180);

        //icon1
        p1 = PropertyValuesHolder.ofFloat("TranslationX", distance,0f);
        //icon2
        p21 = PropertyValuesHolder.ofFloat("TranslationX", (float)(distance*Math.cos(angle1)),0f);
        p22 = PropertyValuesHolder.ofFloat("TranslationY",  -(float)(distance*Math.sin(angle1)),0f);
        //icon3
        p31 = PropertyValuesHolder.ofFloat("TranslationX", (float)(distance*Math.cos(angle2)),0f);
        p32 = PropertyValuesHolder.ofFloat("TranslationY", -(float)(distance*Math.sin(angle2)),0f);
        //icon4
        p4 = PropertyValuesHolder.ofFloat("TranslationY", -distance,0f);
        for (int i = 0;i<viewList.size();i++){
            switch (i){
                case 0:
                    animator1 = ObjectAnimator.ofPropertyValuesHolder(viewList.get(i), p1);
                    objectAnimators.add(animator1);
                    break;
                case 1:
                    animator2 = ObjectAnimator.ofPropertyValuesHolder(viewList.get(i), p21, p22);
                    objectAnimators.add(animator2);
                    break;
                case 2:
                    animator3 = ObjectAnimator.ofPropertyValuesHolder(viewList.get(i), p31,p32);
                    objectAnimators.add(animator3);
                    break;
                case 3:
                    animator4 = ObjectAnimator.ofPropertyValuesHolder(viewList.get(i), p4);
                    objectAnimators.add(animator4);
                    break;
                default:
                    break;
            }
        }
        setClose.playTogether(objectAnimators);
        setClose.setDuration(500);
        setClose.start();
        setClose.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                for (int i = 0;i<viewList.size();i++){
                    viewList.get(i).setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        return isShow;
    }

    public static boolean showIcon(final Activity context, final List<View> viewList, final boolean ifShow) {
        isShow=!ifShow;
        activity = context;
        for (int i = 0;i<viewList.size();i++){
            viewList.get(i).setVisibility(View.VISIBLE);
        }
        objectAnimators.clear();
        //动画距离,屏幕宽度的25%
        float distance = getScreenWidth()*0.25f;
        float angle = 90/(viewList.size()-1);
        //相邻ImageView运动角度式22.5度
        float angle1 = (float)(angle*Math.PI/180);
        float angle2 = (float)(angle*2*Math.PI/180);

        //icon1
        p1 = PropertyValuesHolder.ofFloat("TranslationX", 0f, distance);
        //icon2
        p21 = PropertyValuesHolder.ofFloat("TranslationX", 0f, (float)(distance*Math.cos(angle1)));
        p22 = PropertyValuesHolder.ofFloat("TranslationY", 0f, -(float)(distance*Math.sin(angle1)));
        //icon3
        p31 = PropertyValuesHolder.ofFloat("TranslationX", 0f, (float)(distance*Math.cos(angle2)));
        p32 = PropertyValuesHolder.ofFloat("TranslationY", 0f, -(float)(distance*Math.sin(angle2)));
        //icon4
        p4 = PropertyValuesHolder.ofFloat("TranslationY", 0f, -distance);
        for (int i = 0;i<viewList.size();i++){
            switch (i){
                case 0:
                    animator1 = ObjectAnimator.ofPropertyValuesHolder(viewList.get(i), p1);
                    //添加自由落体效果插值器
                    animator1.setInterpolator(new BounceInterpolator());
                    objectAnimators.add(animator1);

                    break;
                case 1:
                    animator2 = ObjectAnimator.ofPropertyValuesHolder(viewList.get(i), p21, p22);
                    animator2.setInterpolator(new BounceInterpolator());
                    objectAnimators.add(animator2);
                    break;
                case 2:
                    animator3 = ObjectAnimator.ofPropertyValuesHolder(viewList.get(i), p31,p32);
                    animator3.setInterpolator(new BounceInterpolator());
                    objectAnimators.add(animator3);
                    break;
                case 3:
                    animator4 = ObjectAnimator.ofPropertyValuesHolder(viewList.get(i), p4);
                    animator4.setInterpolator(new BounceInterpolator());
                    objectAnimators.add(animator4);
                    break;
                default:
                    break;
            }
        }
        set.playTogether(objectAnimators);
        set.setDuration(800);
        set.start();
        return isShow;
    }

    /**
     * 竖屏时获取屏幕宽度，横屏时，获取高度
     * @return
     */
    public static int getScreenWidth(){
        DisplayMetrics outMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        int x = outMetrics.widthPixels;
        int y = outMetrics.heightPixels;
        return x>y?y:x;
    }
    //开始动画
    public static View startAnimation(final View itemViewOld,final View itemView) {
        if (animSet != null && itemViewOld != null) {
            ObjectAnimator anim1 = ObjectAnimator.ofFloat(itemViewOld, "scaleX",
                    1.1f, 1.0f);
            ObjectAnimator anim2 = ObjectAnimator.ofFloat(itemViewOld, "scaleY",
                    1.1f, 1.0f);
            animSet = new AnimatorSet();
            animSet.setDuration(400);
            animSet.setInterpolator(new LinearInterpolator());
            //两个动画同时执行
            animSet.playTogether(anim1, anim2);
            animSet.start();
        }

        tempImageView = itemView;
        final ObjectAnimator anim1 = ObjectAnimator.ofFloat(itemView, "scaleX", 1.0f, 1.1f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(itemView, "scaleY",
                1.0f, 1.1f);
        animSet = new AnimatorSet();
        animSet.setDuration(200);
        animSet.setInterpolator(new LinearInterpolator());
        //两个动画同时执行
        animSet.playTogether(anim1, anim2);
        animSet.start();
        return tempImageView;
    }

   /* //    还原动画
    public static void setAnimationToOld(View itemView) {
        if (animSet != null && tempImageView != null) {
            ObjectAnimator anim1 = ObjectAnimator.ofFloat(itemView, "scaleX",
                    1.1f, 1.0f);
            ObjectAnimator anim2 = ObjectAnimator.ofFloat(itemView, "scaleY",
                    1.1f, 1.0f);
            animSet = new AnimatorSet();
            animSet.setDuration(400);
            animSet.setInterpolator(new LinearInterpolator());
            //两个动画同时执行
            animSet.playTogether(anim1, anim2);
            animSet.start();
        }

    }*/
}
