package com.example.john.viewpagerproject.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import com.example.john.viewpagerproject.R;
import com.example.john.viewpagerproject.utils.CustomRotateAnim;
import com.example.john.viewpagerproject.utils.MenuAnimator;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * android 属性动画Demo，发散式弹出菜单
 */
public class MenuAnimationActivity extends AppCompatActivity {

    @BindView(R.id.iv_icon1)
    ImageView ivIcon1;
    @BindView(R.id.iv_icon2)
    ImageView ivIcon2;
    @BindView(R.id.iv_icon3)
    ImageView ivIcon3;
    @BindView(R.id.iv_icon4)
    ImageView ivIcon4;
    @BindView(R.id.iv_icon5)
    ImageView ivIcon5;
    @BindView(R.id.iv_icon6)
    ImageView ivIcon6;
    @BindView(R.id.loading_logo)
    ImageView loading_logo;
    @BindView(R.id.cancelLoading)
    Button cancelLoading;
    private List<View> textViews = new ArrayList<>();
    private View tempImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_animation);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        textViews.add(ivIcon1);
        textViews.add(ivIcon2);
        textViews.add(ivIcon3);
        textViews.add(ivIcon4);
        showAnimation();
        cancelLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateAnim.cancel();
            }
        });
    }
private CustomRotateAnim rotateAnim;
    /**
     * 设置动画
     */
    private void showAnimation() {
        // 获取自定义动画实例
         rotateAnim = CustomRotateAnim.getCustomRotateAnim();
        // 一次动画执行1秒
        rotateAnim.setDuration(1000);
        // 设置为循环播放
        rotateAnim.setRepeatCount(-1);
        // 设置为匀速
        rotateAnim.setInterpolator(new LinearInterpolator());
        // 开始播放动画
        loading_logo.startAnimation(rotateAnim);
    }

    private boolean isShow = true;
    @OnClick({R.id.iv_icon1, R.id.iv_icon2, R.id.iv_icon3, R.id.iv_icon4, R.id.iv_icon5, R.id.iv_icon6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_icon1:
                tempImageView=MenuAnimator.startAnimation(tempImageView,ivIcon1);
                break;
            case R.id.iv_icon2:
                tempImageView=MenuAnimator.startAnimation(tempImageView,ivIcon2);
                break;
            case R.id.iv_icon3:
                tempImageView=MenuAnimator.startAnimation(tempImageView,ivIcon3);
                break;
            case R.id.iv_icon4:
                tempImageView=MenuAnimator.startAnimation(tempImageView,ivIcon4);
                break;
            case R.id.iv_icon5:
                tempImageView=MenuAnimator.startAnimation(tempImageView,ivIcon5);
                break;
            case R.id.iv_icon6:
                if (isShow){
                    //点击最外层icon，展开icon动画
                    isShow = MenuAnimator.showIcon(this,textViews,isShow);
                }else {
                    isShow = MenuAnimator.showCloseIcon(this,textViews,isShow);
                }
                break;
            default:
                break;
        }
    }

}
