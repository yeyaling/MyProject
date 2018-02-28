package com.example.john.viewpagerproject.activitys;

import android.animation.AnimatorSet;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.john.viewpagerproject.R;
import com.example.john.viewpagerproject.view.ObservableScrollView;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * 根据scrollview滑动title改变
 */
public class BigSmallActivity extends BaseActivity  implements ObservableScrollView.ScrollViewListener {
    private ObservableScrollView HomeFragmentScrollView;
    private LinearLayout HomeFragmentInputSearchLl;
    private AnimatorSet animSet;
    private RelativeLayout titleBagRl;
    private LinearLayout HomeFragmentInputSearchLl2;
    private ImageView iv;
    private int imageHeight;
    private int imageWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_small);
        HomeFragmentScrollView= (ObservableScrollView) findViewById(R.id.HomeFragmentScrollView);
        HomeFragmentInputSearchLl= (LinearLayout) findViewById(R.id.HomeFragmentInputSearchLl);
        HomeFragmentInputSearchLl2= (LinearLayout) findViewById(R.id.HomeFragmentInputSearchLl2);
        titleBagRl= (RelativeLayout) findViewById(R.id.titleBagRl);
        iv= (ImageView) findViewById(R.id.iv);
//        HomeFragmentScrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
//            @Override
//            public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
//                float distance = y;
//                Log.i("distance","y======="+y);
//                if (y>410){
//                    ObjectAnimator anim1 = ObjectAnimator.ofFloat(HomeFragmentInputSearchLl, "scaleX", 1.0f, 1.1f);
//                    ObjectAnimator anim2 = ObjectAnimator.ofFloat(titleBagRl, "scaleY", 1.0f, 1.1f);
//                    animSet = new AnimatorSet();
//                    animSet.setDuration(200);
//                    animSet.setInterpolator(new LinearInterpolator());
//                    //两个动画同时执行
//                    animSet.playTogether(anim1, anim2);
//                    animSet.start();
//                }
//
//
//
//
//            }
//        });
        // 获取顶部图片高度后，设置滚动监听
        ViewTreeObserver vto = iv.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                iv.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);
                imageHeight = iv.getHeight();
                imageWidth = iv.getWidth();
                Log.i("TAG","宽度=="+imageWidth);
                HomeFragmentScrollView.setScrollViewListener(BigSmallActivity.this);
            }
        });

    }
    private void searchAnimation(){
//        ObjectAnimator anim1 = ObjectAnimator.ofFloat(HomeFragmentInputSearchLl, "scaleX", 1.0f, 0.8f);
//        anim1.setDuration(200);
//        anim1.start();



    }
    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        Log.i("TAG", "y--->" + y);
        if (y <= 0) {
            titleBagRl.setBackgroundColor(Color.argb((int) 0, 254, 146, 211));//AGB由相关工具获得，或者美工提供
            HomeFragmentInputSearchLl2.setBackgroundColor(Color.argb((int) 0, 255, 255,255));//AGB由相关工具获得，或者美工提供

        } else if (y > 0 && y <= imageHeight) {
            float scale = (float) y / imageHeight;
            float alpha = (255 * scale);
            // 只是layout背景透明(仿知乎滑动效果)
            titleBagRl.setBackgroundColor(Color.argb((int) alpha, 254, 146, 211));
            HomeFragmentInputSearchLl2.setBackgroundColor(Color.argb((int) alpha, 255, 255,255));


          /*  FrameLayout.LayoutParams params= (FrameLayout.LayoutParams) HomeFragmentInputSearchLl.getLayoutParams();
//获取当前控件的布局对象
            params.width=imageWidth-y/3;//设置当前控件布局的高度
            Log.i("TAG","宽度=="+(imageWidth-y/3));
            HomeFragmentInputSearchLl.setLayoutParams(params);//将设置好的布局参数应用到控件中*/

        } else {
            titleBagRl.setBackgroundColor(Color.argb((int) 255, 254, 146, 211));
            HomeFragmentInputSearchLl2.setBackgroundColor(Color.argb((int) 255, 255, 255,255));
//            HomeFragmentInputSearchLl2.setVisibility(View.VISIBLE);
        }
/*        if (y>410){
            FrameLayout.LayoutParams params= (FrameLayout.LayoutParams) HomeFragmentInputSearchLl.getLayoutParams();
//获取当前控件的布局对象
            params.width=imageWidth-y/3;//设置当前控件布局的高度
            Log.i("TAG","宽度=="+(imageWidth-y/3));
            HomeFragmentInputSearchLl.setLayoutParams(params);//将设置好的布局参数应用到控件中
        }*/
        if (y>410){

        }
    }
}
