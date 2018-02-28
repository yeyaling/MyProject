package com.example.john.viewpagerproject.activitys;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.john.viewpagerproject.R;

public class TuoZhuaiActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private TextView tvOne;
    private TextView tvTwo;
    private TextView tv2;
    private int height;
    int[] locationOne = new int[2];
    int[] locationTwo = new int[2];
    private boolean flg = true;
    private int x;
    private int y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuo_zhuai);
        initViews();
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        tvOne.getLocationInWindow(locationOne);

        tvTwo.getLocationInWindow(locationTwo);
        int x = locationTwo[0];
        int y = locationTwo[1]-getResources().getDimensionPixelSize(height);
    }

    private void initViews() {
        tvOne = (TextView) findViewById(R.id.tvOne);
        tvTwo = (TextView) findViewById(R.id.tvTwo);
        tv2 = (TextView) findViewById(R.id.tv2);

        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        tvOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flg){
                    flg = false;
                    x = locationTwo[0];
                    y = locationTwo[1]-getResources().getDimensionPixelSize(height);
                }else {
                    flg = true;
                    x = locationOne[0];
                    y = locationOne[1]-getResources().getDimensionPixelSize(height);
                }
                ViewPropertyAnimator viewPropertyAnimator;
                viewPropertyAnimator = tvOne.animate().x(x).y(y);
                viewPropertyAnimator.setDuration(1000);
                viewPropertyAnimator.start();
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator =  ObjectAnimator.ofFloat(tv2,"X",0,100);
                objectAnimator.setDuration(1000);
                objectAnimator.start();

            }
        });
    }

}
