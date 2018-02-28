package com.example.john.viewpagerproject.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.john.viewpagerproject.R;

/**
 * 状态栏沉浸式
 */
public class ColorFulScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_ful_screen);
//        ViewServer.get(this).addWindow(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
    }

    public void onDestroy() {
        super.onDestroy();
//        ViewServer.get(this).removeWindow(this);
    }

    public void onResume() {
        super.onResume();
//        ViewServer.get(this).setFocusedWindow(this);
    }
}
