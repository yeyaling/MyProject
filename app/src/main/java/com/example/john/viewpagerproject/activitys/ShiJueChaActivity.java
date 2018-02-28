package com.example.john.viewpagerproject.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.john.viewpagerproject.R;
import com.example.john.viewpagerproject.view.PullToZoomScrollView;

/**
 * 视觉差滑动效果
 */
public class ShiJueChaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shi_jue_cha);
        PullToZoomScrollView scrollView = (PullToZoomScrollView) findViewById(R.id.scroll_view);
        scrollView.setParallax(true);
        View zoomView = LayoutInflater.from(this).inflate(
                R.layout.imagetitle, null, false);
        View contentView = LayoutInflater.from(this).inflate(
                R.layout.profile_content_view, null, false);
        scrollView.setZoomView(zoomView);
        scrollView.setContentContainerView(contentView);
    }
}
