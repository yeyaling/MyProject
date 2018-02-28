package com.example.john.viewpagerproject.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewStub;
import android.widget.TextView;

import com.example.john.viewpagerproject.R;

/**
 * Created by john on 2017/8/9.
 */

public class ViewStubActivity extends BaseActivity{
    private String type;
    private ViewStub viewStubOne;
    private ViewStub viewStubTwo;
    private TextView titleTv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstub_layout);
        initView();
    }

    private void initView() {
        type ="1";
        if (type.equals("1")){
            viewStubOne();
        }else {
            viewStubTwo();
        }
    }

    private void viewStubOne() {
        viewStubOne = (ViewStub) findViewById(R.id.viewStubOne);
        viewStubOne.inflate();
        titleTv = (TextView) findViewById(R.id.titleTv);
        titleTv.setText("lalalalalall");
    }
    private void viewStubTwo() {
        viewStubTwo = (ViewStub) findViewById(R.id.viewStubTwo);
        viewStubTwo.inflate();
    }
}
