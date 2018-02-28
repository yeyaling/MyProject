package com.example.john.viewpagerproject.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.john.viewpagerproject.ActivityCollectior;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by john on 2017/3/13.
 */

public class BaseActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollectior.addActivity(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollectior.removeActivity(this);
    }
}
