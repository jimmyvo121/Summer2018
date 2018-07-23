package crexa_inc.summer2018.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import crexa_inc.summer2018.R;

public class CustomColorActivity extends BaseActivity {



    private int color = 0;

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
        color = colorRNG.getColorInt();
        history5.add(color);
        view.setBackgroundColor(color);
        bt_text.setTextColor(color);
        //toastShort(Integer.toString(color));
        System.out.println(color);
        textview1.setText("#" + Integer.toHexString(color).toUpperCase());
        textview2.setText(Integer.toString(-1*color));


    }


    @OnClick(R.id.add_color)
    public void add(){

        toastShort("Color added");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_color);
    }
}
