package crexa_inc.summer2018;


import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import butterknife.OnClick;
import crexa_inc.summer2018.R;
import crexa_inc.summer2018.activity.BaseActivity;
import crexa_inc.summer2018.adapter.ViewPagerAdapter;
import crexa_inc.summer2018.fragment.ColorsFragment;
import crexa_inc.summer2018.fragment.CompareColorFragment;
import crexa_inc.summer2018.fragment.HistoryFragment;
import crexa_inc.summer2018.fragment.StartFragment;
import crexa_inc.summer2018.fragment.TestFragment;

public class MainActivity extends BaseActivity implements  View.OnTouchListener {
    private boolean isOpen = false;


    @BindView(R.id.main_layout)
    View view;
    private GestureDetector gestureDetector;

    @BindView(R.id.gesture_tab)
    TextView tv;
    private ValueAnimator openAnimator;
    private ValueAnimator closeAnimator;

    private ArrayList<Integer> contentList = new ArrayList<Integer>();

    private void initViewPager() {
        ArrayList<View> viewList = new ArrayList<View>();

    }

    final ColorsFragment colorsFragment = new ColorsFragment();
    final StartFragment startFragment = new StartFragment();

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private List<Integer> history5 = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        viewPager = findViewById(R.id.main_view_pager);
        fragmentList.add(new TestFragment());
        //fragmentList.add(new ColorsFragment());
        //fragmentList.add(new HistoryFragment());
        //fragmentList.add(new CompareColorFragment());
        fragmentList.add(new StartFragment());

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);

        setListener();
        gestureDetector = new GestureDetector(this, new GestureListener());
        view.setOnTouchListener(this);
        view.setLongClickable(true);
       // openAnimator = openAnimatorListener();
        //closeAnimator = closeAnimatorListener();
       // initViewPager();

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener{

        private boolean isMove = false;
        private int sumX = 0;
        private boolean isSwap = false;
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            float x = e1.getRawX();
            if (x<100){
                isSwap = true;
            }
            sumX+=distanceX;
            if (!isMove){
                if(sumX<0){
                    if(Math.abs(sumX)>500){
                        if(isSwap){
                            isMove = true;
                            toastShort("left to right");
                            if(!isOpen){
                                openAnimator.start();
                                isOpen=true;
                            }
                        }
                    }
                }
                if(sumX>0){
                    if(Math.abs(sumX)>500){
                        isMove = true;
                        toastShort("right to left");
                        if(isOpen){
                            closeAnimator.start();
                            isOpen=false;
                        }
                    }
                }

            }
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        public ArrayList<Integer> getContent(){
            return contentList;
        }

        @Override
        public boolean onDown(MotionEvent e) {
//            shortToast("onDown");
            isMove = false;
            sumX = 0;
            isSwap = false;
            return super.onDown(e);
        }
    }
//    private ValueAnimator openAnimatorListener(){
//        ValueAnimator animator = ValueAnimator.ofInt(UtilDensity.dip2px(this,-250), 0);
//
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int curValue = (int)animation.getAnimatedValue();
////                tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
//                tv.layout(curValue,tv.getTop(),curValue+tv.getWidth(),tv.getHeight());
//            }
//        });
//        animator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                tv.setVisibility(View.VISIBLE);
//            }
//            @Override
//            public void onAnimationEnd(Animator animation) {
//            }
//            @Override
//            public void onAnimationCancel(Animator animation) {
//            }
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//            }
//        });
//        animator.setDuration(1000);
//        return animator;
//    }
//
//    private ValueAnimator closeAnimatorListener(){
//        ValueAnimator animator = ValueAnimator.ofInt(0, UtilDensity.dip2px(this,-250));
//
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int curValue = (int)animation.getAnimatedValue();
////                tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
//                tv.layout(curValue,tv.getTop(),curValue+tv.getWidth(),tv.getHeight());
//            }
//        });
//        animator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                tv.setVisibility(View.VISIBLE);
//            }
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                tv.setVisibility(View.INVISIBLE);
//            }
//            @Override
//            public void onAnimationCancel(Animator animation) {
//            }
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//            }
//        });
//        animator.setDuration(1000);
//        return animator;
//    }

//    @OnClick(R.id.start_bt)
//    public void start() {
//        getSupportFragmentManager().beginTransaction().replace(R.id.main_view_pager, startFragment).commit();
//    }
    private void setListener() {
        //getSupportFragmentManager().beginTransaction().replace(R.id.main_view, colorsFragment).commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.main_view_pager, startFragment).commit();

    }
}