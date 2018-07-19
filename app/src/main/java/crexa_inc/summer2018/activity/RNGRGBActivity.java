package crexa_inc.summer2018.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import crexa_inc.summer2018.R;

public class RNGRGBActivity extends BaseActivity {


    @BindView(R.id.Relative_background )
    View view;
    @BindView(R.id.generate_bt)
    Button bt_text;
    @BindView(R.id.textview_1)
    TextView textview1;
    @BindView(R.id.textview_2)
    TextView textview2;

    //int [] history5 = new int[5];
    List<Integer> history5 = new ArrayList<Integer>();

    @OnClick(R.id.generate_bt)

    public void gen(){
        int color = colorRNG.getColorInt();
        history5.add(color);
        view.setBackgroundColor(color);
        bt_text.setTextColor(color);
        //toastShort(Integer.toString(color));
        System.out.println(color);
        textview1.setText("#" + Integer.toHexString(color).toUpperCase());
        textview2.setText(Integer.toString(-1*color));


    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rngrgb);
        ButterKnife.bind(this);


    }
    public void color(){

    }

}
