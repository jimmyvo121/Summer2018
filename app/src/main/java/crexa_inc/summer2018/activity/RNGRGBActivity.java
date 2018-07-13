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
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import crexa_inc.summer2018.R;

public class RNGRGBActivity extends AppCompatActivity {


    @BindView(R.id.main_view )
    View view;


    ViewPager viewPager;

    TextView tv1 = (TextView) findViewById(R.id.textview_1);

    tv1.setOnClickListener(new View.OnClickListener() {

        @Override

        public void onClick(View view) {

            Random random = new Random();
            RelativeLayout.setBackgroundColor(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(10);
        }
    });
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rngrgb);
        colorRNG.colorDarks();





    }

}
