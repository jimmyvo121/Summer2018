package crexa_inc.summer2018.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import crexa_inc.summer2018.R;
import crexa_inc.summer2018.adapter.AdvancePageAdapter;
import crexa_inc.summer2018.dialog.Quiz3Dialog;
import crexa_inc.summer2018.fragment.ColorsFragment;

public class CustomDialogActivity extends BaseActivity {


    private int color = 0;
    private Color mColor = new Color();

    @BindView(R.id.custom_Relative_background )
    View view;
    @BindView(R.id.custom_generate_bt)
    Button bt_text;
    @BindView(R.id.custom_textview_1)
    TextView textview1;
    @BindView(R.id.custom_textview_2)
    TextView textview2;

    //int [] history5 = new int[5];
    List<Integer> history5 = new ArrayList<Integer>();

    private int option= 0;


    @OnClick(R.id.custom_generate_bt)
    public void gen(){
        switch(option){
            case 0:
                color = colorRNG.getColorInt();
                background();
                break;
            case 1:
                //color = -1;
                colorRNG.color();
                int red =(colorRNG.colors()*256*256) ;
                colorRNG.color();
                color = -red;
                background();
                break;

            case 2:
                //color = -1;
                view.setBackgroundColor(mColor.rgb(00, colorRNG.colors(), 00));
                break;

            case 3:
                //color = -1;

                view.setBackgroundColor(mColor.rgb(00, 00, colorRNG.colors()));
                break;

        }

    }
//    @OnClick(R.id.add_color)
//    public void add(){
//
//        toastShort("Color added");
//    }
    @OnClick(R.id.custom_add_color)
    public void showDialog()
    {
        Quiz3Dialog.IQuiz3DialogEventListener listener = new Quiz3Dialog.IQuiz3DialogEventListener() {
            @Override
            public void onREDClickListener(String msg)
            {
                 option = 1;
                toastShort(msg);

            }

            @Override
            public void onGREENClickListener(String msg)
            {
                option = 2;

                toastShort(msg);
            }

            @Override
            public void onBLUEClickListener(String msg)
            {
                option = 3;
                toastShort(msg);
            }
        };
        Quiz3Dialog dialog = new Quiz3Dialog(CustomDialogActivity.this, listener);
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_color);
        ButterKnife.bind(this);
    }
    public void background(){
        view.setBackgroundColor(color);
        history5.add(color);
        bt_text.setTextColor(color);
        //toastShort(Integer.toString(color));
        System.out.println(color);
        textview1.setText("#" + Integer.toHexString(color).toUpperCase());
        textview2.setText(Integer.toString(-1*color));
    }

    public void close()
    {
        this.finish();
    }

}
