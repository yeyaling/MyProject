package com.example.john.viewpagerproject.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.chaychan.viewlib.NumberRunningTextView;
import com.example.john.viewpagerproject.R;

public class AbcListActivity extends AppCompatActivity {
    private NumberRunningTextView NumberRunningTextViewOne;
    private NumberRunningTextView NumberRunningTextViewTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc_list);
        NumberRunningTextViewOne = (NumberRunningTextView) findViewById(R.id.NumberRunningTextViewOne);
        NumberRunningTextViewTwo = (NumberRunningTextView) findViewById(R.id.NumberRunningTextViewTwo);
        NumberRunningTextViewOne.setContent("99999.99");
        NumberRunningTextViewTwo.setContent("8388608");
        String str ="99999.99";
        Log.i("length==",str.length()+"");
        NumberRunningTextViewOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberRunningTextViewOne.setContent("99999.99");
                NumberRunningTextViewTwo.setText("8388607");
            }
        });
    }
}
