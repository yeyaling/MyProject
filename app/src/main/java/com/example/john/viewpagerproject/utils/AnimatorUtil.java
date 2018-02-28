package com.example.john.viewpagerproject.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by gavin
 * Created date 17/4/25
 * Created log
 */

public class AnimatorUtil {

    /**
     * 右侧线动画
     * @param view
     */
    public static void startRightHorizontalAnimator(View view) {
        view.setPivotX(0);
        view.setPivotY(0);
        view.invalidate();
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "scaleX",0f, 1f);
        set.play(animator1).with(animator2);
        set.setDuration(1500);
        set.start();
    }

    /**
     * 左侧线动画
     * @param view
     */
    public static void startLeftHorizontalAnimator(View view) {
        int width = view.getWidth();
        view.setPivotX(width);
        view.setPivotY(0);
        view.invalidate();
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "scaleX",0f, 1f);
        set.play(animator1).with(animator2);
        set.setDuration(1500);
        set.start();
    }

    /**
     * 竖线动画
     * @param view
     * @param listener
     */
    public static void startVerticalAnimator(View view, Animator.AnimatorListener listener) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
        animator1.setDuration(1000);
        animator1.addListener(listener);
        animator1.start();
    }

    /**
     * 文字显示
     * @param view
     */
    public static void showTextAnimator(View view) {
        view.setVisibility(View.VISIBLE);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
        animator1.setDuration(500);
        animator1.start();
    }

    /**
     * 图片动画
     * @param view1
     */
    public static void iconAnimator(View view1, View view2) {
        view1.setVisibility(View.VISIBLE);
        view2.setVisibility(View.VISIBLE);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view1, "alpha", 0f, 1f);
        animator1.setDuration(500);

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(view2, "scaleX", 1f, 1.5f);
        animatorX.setRepeatCount(-1);
        animatorX.setDuration(1200);

        ObjectAnimator animatorY = ObjectAnimator.ofFloat(view2, "scaleY", 1f, 1.5f);
        animatorY.setRepeatCount(-1);
        animatorY.setDuration(1200);

        AnimatorSet set = new AnimatorSet();
        set.play(animatorX).with(animatorY).after(animator1);
        set.start();

    }

}
