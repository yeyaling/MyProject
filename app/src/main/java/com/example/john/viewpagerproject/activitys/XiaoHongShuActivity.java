package com.example.john.viewpagerproject.activitys;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.john.viewpagerproject.utils.AnimatorUtil;
import com.example.john.viewpagerproject.R;

public class XiaoHongShuActivity extends AppCompatActivity {
    private View vVertical1;
    private View vHorizontalLeft1;
    private View vHorizontalLeft2;
    private View vHorizontalLeft3;
    private View vHorizontalRight1;
    private View vHorizontalRight2;
    private View vHorizontalRight3;
    private TextView tvRed;
    private TextView tvWhite;
    private TextView tvBlue;
    private TextView TitleOneTv;
    private Button btn;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView animIv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiao_hong_shu);
        initView();
    }

    private void initView() {
        vVertical1 = (View) findViewById(R.id.v_vertical_1);
        vHorizontalLeft1 = (View) findViewById(R.id.v_horizontal_left_1);
        vHorizontalLeft2 = (View) findViewById(R.id.v_horizontal_left_2);
        vHorizontalLeft3 = (View) findViewById(R.id.v_horizontal_left_3);
        vHorizontalRight1 = (View) findViewById(R.id.v_horizontal_right_1);
        vHorizontalRight2 = (View) findViewById(R.id.v_horizontal_right_2);
        vHorizontalRight3 = (View) findViewById(R.id.v_horizontal_right_3);
        TitleOneTv = (TextView) findViewById(R.id.TitleOneTv);
        tvRed = (TextView) findViewById(R.id.tv_red);
        tvWhite = (TextView) findViewById(R.id.tv_white);
        tvBlue = (TextView) findViewById(R.id.tv_blue);
        btn = (Button) findViewById(R.id.btn);
        iv1 = (ImageView) findViewById(R.id.iv_1);
        iv2 = (ImageView) findViewById(R.id.iv_2);
        animIv = (ImageView) findViewById(R.id.animIv);

        TitleOneTv.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
        TitleOneTv.getPaint().setAntiAlias(true);//抗锯齿
        startAnimator();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Animation animation = AnimationUtils.loadAnimation(XiaoHongShuActivity.this, R.anim.round_anim);
        animIv.setAnimation(animation);
        animation.start();
    }

    private void startAnimator() {
        startLeftHoricontalAnimator(vHorizontalLeft1, vHorizontalLeft2, vHorizontalLeft3);
        startRightHoricontalAnimator(vHorizontalRight1, vHorizontalRight2, vHorizontalRight3);
        AnimatorUtil.startVerticalAnimator(vVertical1, new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //动画结束时调用
                showTextAnimator(tvBlue, tvRed, tvWhite);
                iconAnimator(iv2, iv1);
            }
        });
    }

    /**
     * 左侧线动画
     *
     * @param views
     */
    private void startLeftHoricontalAnimator(View... views) {
        for (View view :
                views) {
            AnimatorUtil.startLeftHorizontalAnimator(view);
        }
    }

    /**
     * 右侧线动画
     *
     * @param views
     */
    private void startRightHoricontalAnimator(View... views) {
        for (View view :
                views) {
            AnimatorUtil.startRightHorizontalAnimator(view);
        }
    }

    /**
     * 文字动画
     *
     * @param views
     */
    private void showTextAnimator(View... views) {
        for (View view :
                views) {
            AnimatorUtil.showTextAnimator(view);
        }
    }

    /**
     * icon动画
     */
    private void iconAnimator(View view1, View view2) {
        AnimatorUtil.iconAnimator(view1, view2);
    }
}
