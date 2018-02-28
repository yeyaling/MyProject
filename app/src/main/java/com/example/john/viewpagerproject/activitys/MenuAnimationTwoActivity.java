package com.example.john.viewpagerproject.activitys;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.example.john.viewpagerproject.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuAnimationTwoActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_3)
    TextView tv3;
    @BindView(R.id.tv_4)
    TextView tv4;
    @BindView(R.id.mRecycleView)
    RecyclerView mRecycleView;

    private ImageView imgPublish;
    private TextView textView1;
    private TextView textView2;

    private boolean isMenuOpen = false;

    private List<TextView> textViews = new ArrayList<>();
    private DelegateAdapter delegateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_animation_two);
        ButterKnife.bind(this);

        imgPublish = (ImageView) findViewById(R.id.img_publish);
        textView1 = (TextView) findViewById(R.id.tv_1);
        textView2 = (TextView) findViewById(R.id.tv_2);

        textViews.add(textView1);
        textViews.add(textView2);
        textViews.add(tv3);
        textViews.add(tv4);

        imgPublish.setOnClickListener(this);
        initVLayout();
    }


    private void initVLayout() {
        // 1.创建VirtualLayoutmanager
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        mRecycleView.setLayoutManager(layoutManager);

        // 2.设置回收复用池大小
        final RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        mRecycleView.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0, 20);

        // 3.设置adapter

        delegateAdapter = new DelegateAdapter(layoutManager, false);
        mRecycleView.setAdapter(delegateAdapter);
        List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
        final StaggeredGridLayoutHelper helper = new StaggeredGridLayoutHelper(2, 20);

        adapters.add(new DelegateAdapter.Adapter<MyViewHolder>() {

            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new MyViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_shopping_gv,
                                parent,
                                false));
            }

            @Override
            public void onBindViewHolder(MyViewHolder holder, final int position) {
               /* holder.ShoppingRvNameTv.setText(listYouLikeProductInfosAll.get(position).getName());
                holder.ShoppingRvPriceTv.setText("¥"+listYouLikeProductInfosAll.get(position).getPrice());
                holder.ShoppingRvOriginalPriceTwo.setText("¥"+listYouLikeProductInfosAll.get(position).getOriginalPrice());
                holder.ShoppingRvOriginalPriceTwo.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                holder.ShoppingRvSalesNumTv.setText("已售"+listYouLikeProductInfosAll.get(position).getSalesVolume()+"笔");
//        FrescoUtils.DisPlaySizeImage(context,myViewHolder.ShoppingRvSdv,250,192, dataList.get(position).getFeatureImage());
                GlideUtils.GlideSizeImage(this,holder.ShoppingRvSdv,250,192, listYouLikeProductInfosAll.get(position).getFeatureImage());*/
            }

            @Override
            public int getItemCount() {
                return 10;
//                return listYouLikeProductInfosAll==null?0:listYouLikeProductInfosAll.size();
            }

            @Override
            public LayoutHelper onCreateLayoutHelper() {
                return helper;
            }
        });

        delegateAdapter.setAdapters(adapters);
    }
    private class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView ShoppingRvSdv;
        private TextView ShoppingRvNameTv;
        private TextView ShoppingRvPriceTv;
        private TextView ShoppingRvOriginalPriceTwo;
        private TextView ShoppingRvSalesNumTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            ShoppingRvSdv = (ImageView) itemView.findViewById(R.id.ShoppingRvSdv);
            ShoppingRvNameTv = (TextView) itemView.findViewById(R.id.ShoppingRvNameTv);
            ShoppingRvPriceTv = (TextView) itemView.findViewById(R.id.ShoppingRvPriceTv);
            ShoppingRvOriginalPriceTwo = (TextView) itemView.findViewById(R.id.ShoppingRvOriginalPriceTwo);
            ShoppingRvSalesNumTv = (TextView) itemView.findViewById(R.id.ShoppingRvSalesNumTv);
        }


    }















    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_publish:

                if (!isMenuOpen) {
                    showOpenAnim(80);
                    imgPublish.setImageResource(R.mipmap.ic_launcher);
                } else {
                    showCloseAnim(80);
                    imgPublish.setImageResource(R.mipmap.ic_launcher_round);
                }
                break;
        }

    }

    //打开扇形菜单的属性动画， dp为半径长度
    private void showOpenAnim(int dp) {
        textView1.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);


        //for循环来开始小图标的出现动画
        for (int i = 0; i < textViews.size(); i++) {
            AnimatorSet set = new AnimatorSet();
            //标题1与x轴正方向角度为20°，标题2为100°，转换为弧度
//            double c = 20*i * Math.PI / 180 * (i * 2 + 1);
            double c = 20 * i * Math.PI / 180;
            double a1 = Math.cos(c);//对应translationX
            double a2 = Math.sin(c);//对应translationY
            double a3 = Math.cos(c);
            double a4 = Math.sin(c);
            double b1 = a1 * dip2px(dp);
            double b2 = a2 * dip2px(dp);
            double b3 = a3 * dip2px(dp);
            double b4 = a4 * dip2px(dp);

            set.playTogether(
                    ObjectAnimator.ofFloat(textViews.get(i), "translationX", (float) (b1 * 0.25), (float) b1),
                    ObjectAnimator.ofFloat(textViews.get(i), "translationY", (float) (b2 * 0.25), (float) b2),
                    ObjectAnimator.ofFloat(textViews.get(i), "translationX", (float) (b3 * 0.25), (float) b3),
                    ObjectAnimator.ofFloat(textViews.get(i), "translationY", (float) (b4 * 0.25), (float) b4),
                    ObjectAnimator.ofFloat(textViews.get(i), "alpha", 0, 1).setDuration(2000)
            );
            set.setInterpolator(new BounceInterpolator());
            set.setDuration(500).setStartDelay(100);
            set.start();

            set.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {

                    //菜单状态置打开
                    isMenuOpen = true;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }

        //转动加号大图标本身45°
        ObjectAnimator rotate = ObjectAnimator.ofFloat(imgPublish, "rotation", 0, 90).setDuration(300);
        rotate.setInterpolator(new BounceInterpolator());
        rotate.start();

    }

    //关闭扇形菜单的属性动画，参数与打开时相反
    private void showCloseAnim(int dp) {


        //for循环来开始小图标的出现动画
        for (int i = 0; i < textViews.size(); i++) {
            AnimatorSet set = new AnimatorSet();
            double a = -Math.cos(20 * Math.PI / 180 * (i * 2 + 1));
            double b = -Math.sin(20 * Math.PI / 180 * (i * 2 + 1));
            double x = a * dip2px(dp);
            double y = b * dip2px(dp);

            set.playTogether(
                    ObjectAnimator.ofFloat(textViews.get(i), "translationX", (float) x, (float) (x * 0.25)),
                    ObjectAnimator.ofFloat(textViews.get(i), "translationY", (float) y, (float) (y * 0.25)),
                    ObjectAnimator.ofFloat(textViews.get(i), "alpha", 1, 0).setDuration(2000)
            );
//      set.setInterpolator(new AccelerateInterpolator());
            set.setDuration(500);
            set.start();

            set.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {

                    textView1.setVisibility(View.GONE);
                    textView2.setVisibility(View.GONE);

                    //菜单状态置关闭
                    isMenuOpen = false;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }


        //转动加号大图标本身45°
        ObjectAnimator rotate = ObjectAnimator.ofFloat(imgPublish, "rotation", 0, 90).setDuration(300);
        rotate.setInterpolator(new BounceInterpolator());
        rotate.start();


    }

    private int dip2px(int value) {
        float density = getResources()
                .getDisplayMetrics().density;
        return (int) (density * value + 0.5f);
    }

}
