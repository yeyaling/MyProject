package com.example.john.viewpagerproject.activitys;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.john.viewpagerproject.R;

public class AndroidDesignSupportLibraryActivity extends BaseActivity implements View.OnClickListener{
    private Button ShowSnackbarBtn;
    private TextInputLayout textInputLayout;
    private EditText textInputLayoutEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_design_support_library);
        initView();
    }

    private void initView() {
        ShowSnackbarBtn = (Button) findViewById(R.id.ShowSnackbarBtn);
        ShowSnackbarBtn.setOnClickListener(this);

        textInputLayout = (TextInputLayout) findViewById(R.id.textInputLayout);
        textInputLayoutEt = (EditText) findViewById(R.id.textInputLayoutEt);
        textInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length()<6){
                textInputLayout.setError("至少输入6个字！");
                textInputLayout.setErrorEnabled(true);
            }else {
                textInputLayout.setErrorEnabled(false);
            }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ShowSnackbarBtn:
                Snackbar.make(v,"确定取消吗？",Snackbar.LENGTH_LONG).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(AndroidDesignSupportLibraryActivity.this,"已经取消",Toast.LENGTH_LONG).show();
                    }
                })
                 .setCallback(new myOnClick())
                .show();
                break;
        }
    }

    /**
     * 滑动消失回调
     */
    private static final int DISMISS_EVENT_SWIPE = 0;
    /**
     * 点击消失回调
     */
    private static final int DISMISS_EVENT_ACTION = 1;
    /**
     * 超时回调
     */
    private static final int DISMISS_EVENT_TIMEOUT = 2;
    /**
     * 调用dismiss消失回调
     */
    private static final int DISMISS_EVENT_MANUAL = 3;
    /**
     * 再次出现消失Snackbar回调
     */
    private static final int DISMISS_EVENT_CONSECUTIVE = 4;

    private class myOnClick extends Snackbar.Callback {
        @Override
        public void onDismissed(Snackbar snackbar, int event) {
            super.onDismissed(snackbar, event);
            switch (event){
                case DISMISS_EVENT_SWIPE:
                    Log.i("Snackbar::","DISMISS_EVENT_SWIPE");
                    break;
                case DISMISS_EVENT_ACTION:
                    Log.i("Snackbar::","DISMISS_EVENT_ACTION");
                    break;
                case DISMISS_EVENT_TIMEOUT:
                    Log.i("Snackbar::","DISMISS_EVENT_TIMEOUT");
                    break;
                case DISMISS_EVENT_MANUAL:
                    Log.i("Snackbar::","DISMISS_EVENT_MANUAL");
                    break;
                case DISMISS_EVENT_CONSECUTIVE:
                    Log.i("Snackbar::","DISMISS_EVENT_CONSECUTIVE");
                    break;
            }
        }
    }
}
