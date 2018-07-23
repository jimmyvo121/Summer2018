package crexa_inc.summer2018.activity;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import crexa_inc.summer2018.R;
import crexa_inc.summer2018.util.UtilLog;

public class ForGradeActivity extends BaseActivity implements View.OnTouchListener {



    //@OnClick(R.id.acivity_animator_color)
    //public void colorClick(View view)
    @BindView(R.id.activity_gesture_tv)
    TextView tv;
    private GestureDetector gestureDetector;
    private int sumX=0;
    private int sumY=0;
    private Color mColor;
    {
        ObjectAnimator animator =
                ObjectAnimator.ofInt
                        (tv, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        animator.setDuration(8000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_grade);
        ButterKnife.bind(this);
        gestureDetector = new GestureDetector(this,new simpleGestureListener());
        tv.setOnTouchListener(this);
        tv.setFocusable(true);
        tv.setClickable(true);
        tv.setLongClickable(true);
    }

    public class ArgbEvaluator implements TypeEvaluator {
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            int startInt = (Integer) startValue;
            int startA = (startInt >> 24);//0x(A)ff(R)ff(G)ff(B)
            int startR = (startInt >> 16) & 0xff;
            int startG = (startInt >> 8) & 0xff;
            int startB = startInt & 0xff;
            int endInt = (Integer) endValue;
            int endA = (endInt >> 24);
            int endR = (endInt >> 16) & 0xff;
            int endG = (endInt >> 8) & 0xff;
            int endB = endInt & 0xff;
            return (int)((startA + (int)(fraction * (endA - startA))) << 24) |
                    (int)((startR + (int)(fraction * (endR - startR))) << 16) |
                    (int)((startG + (int)(fraction * (endG - startG))) << 8) |
                    (int)((startB + (int)(fraction * (endB - startB))));
        }
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
    private  class simpleGestureListener extends
            GestureDetector.SimpleOnGestureListener{
        /***** onDown->onShowPress->onLongPress*****/
        boolean isToast = false;
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            UtilLog.LogD("Gesture","onSingleTapUp");
            return super.onSingleTapUp(e);
        }
        @Override
        public void onLongPress(MotionEvent e) {
            UtilLog.LogD("Gesture","onLongPress");
            super.onLongPress(e);
        }
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            UtilLog.LogD("Gesture","onScroll");
            UtilLog.LogD("Gesture","distanceY:"+distanceY);
            UtilLog.LogD("Gesture","distanceX:"+distanceX);
            sumX+=distanceX;
            sumY+=distanceY;
            if(!isToast){
                if(sumX<0){
                    if(Math.abs(sumX)>1000){
                        isToast = true;
                        toastShort("You scroll from left to right");
                    }
                }
                if(sumX>0){
                    if(Math.abs(sumX)>1000){
                        isToast = true;
                        toastShort("You scroll from right to left");

                    }
                }

                if(sumY<0){
                    if(Math.abs(sumY)>1000){
                        isToast = true;

                        toastShort("You scroll from top to bottom");
                        tv.setBackgroundColor(mColor.rgb(256*(1000/sumX), 256*(1000/sumX), 256*(1000/sumX)));
                    }
                }
                if(sumY>0){
                    if(Math.abs(sumY)>1000){
                        isToast = true;
                        toastShort("You scroll from bottom to top");
                    }
                }
            }


            return super.onScroll(e1, e2, distanceX, distanceY);
        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            UtilLog.LogD("Gesture","onFling");

            return super.onFling(e1, e2, velocityX, velocityY);
        }
        @Override
        public void onShowPress(MotionEvent e) {
            UtilLog.LogD("Gesture","onShowPress");
            super.onShowPress(e);
        }
        @Override
        public boolean onDown(MotionEvent e) {
            UtilLog.LogD("Gesture","onDown");
            isToast=false;
            sumX=0;
            sumY=0;
            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            UtilLog.LogD("Gesture","onDoubleTap");
            return super.onDoubleTap(e);
        }
        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            UtilLog.LogD("Gesture","onDoubleTapEvent");
            return super.onDoubleTapEvent(e);
        }
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            UtilLog.LogD("Gesture","onSingleTapConfirmed");
            return super.onSingleTapConfirmed(e);
        }
    }
}
