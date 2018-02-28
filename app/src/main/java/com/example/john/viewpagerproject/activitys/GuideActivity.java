package com.example.john.viewpagerproject.activitys;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.john.viewpagerproject.R;
import com.example.john.viewpagerproject.StringInfo;
import com.example.john.viewpagerproject.StringTwoInfo;
import com.example.john.viewpagerproject.databinding.ActivityGuideBinding;

public class GuideActivity extends BaseActivity {
    private StringInfo stringInfo;
    private StringTwoInfo stringTwoInfo;
    private Intent intent;
    private ActivityGuideBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_guide);

        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_guide);
        initView();
        initClick();
    }

    private void initClick() {
        binding.setMClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                intent = new Intent(GuideActivity.this,BigSmallActivity.class);
                intent = new Intent(GuideActivity.this,ViewStubActivity.class);
                startActivity(intent);
            }
        });
        binding.setMClickTwo(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GuideActivity.this,MenuAnimationActivity.class);
                startActivity(intent);
            }
        });
        binding.setMClickFour(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GuideActivity.this,MenuAnimationTwoActivity.class);
                startActivity(intent);
            }
        });
        binding.tvAnimation.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                intent = new Intent(GuideActivity.this,DrawerLayoutaActivity.class);
                intent = new Intent(GuideActivity.this,NavigationActivity.class);
                startActivity(intent);
                return false;
            }
        });
        binding.setMClickSJC(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GuideActivity.this,ShiJueChaActivity.class);
                startActivity(intent);
            }
        });
        binding.setMClickVp(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        binding.setMClickDesignLibrary(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GuideActivity.this,AndroidDesignSupportLibraryActivity.class);
                startActivity(intent);
            }
        });
        binding.setMClickSlideDelete(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GuideActivity.this,SlideDeleteActivity.class);
                startActivity(intent);
            }
        });
        binding.setMClickTuozhuan(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GuideActivity.this,TuoZhuaiActivity.class);
                startActivity(intent);
            }
        });
        binding.setMClickXiaoHongShu(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GuideActivity.this,XiaoHongShuActivity.class);
                startActivity(intent);
            }
        });
        binding.setMClickABCList(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GuideActivity.this,AbcListActivity.class);
                startActivity(intent);
            }
        });
        binding.setMClickVLayout(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GuideActivity.this,VLayoutActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        stringInfo = new StringInfo();
        stringInfo.setTxt(getString(R.string.scroll_listen));
        binding.setTxt(stringInfo);

        stringTwoInfo = new StringTwoInfo();
        stringTwoInfo.setTxtName("侧边栏-长按");
        binding.setTxtTwo(stringTwoInfo);
    }
}
