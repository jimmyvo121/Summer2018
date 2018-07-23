package crexa_inc.summer2018.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import crexa_inc.summer2018.R;
import crexa_inc.summer2018.activity.BaseActivity;
import crexa_inc.summer2018.activity.colorRNG;


public class TestFragment extends Fragment  {


    private Button generate;
    ViewPager viewPager;
    private TextView textview1;
    private TextView textview2;
    private View Mview;

    private int color = 0;
    //int [] history5 = new int[5];
   // private ArrayList <Integer> contextList = new ArrayList<Integer>();

    public void onViewCreated(View view, @Nullable Bundle savedInstance) {
        generate = getView().findViewById(R.id.generate_bt);
        textview1 = getView().findViewById(R.id.textview_1);
        textview2 = getView().findViewById(R.id.textview_2);
        Mview = getView().findViewById(R.id.Relative_background);



        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = colorRNG.getColorInt();
                //history5.add(color);
                //contextList.add((Integer)color);
                Mview.setBackgroundColor(color);
                generate.setTextColor(color);
                //toastShort(Integer.toString(color));
                System.out.println(color);
                textview1.setText("#" + Integer.toHexString(color).toUpperCase());
                textview2.setText(Integer.toString(-1*color));
            }
        });
    }
//    public ArrayList<Integer> getContent(){
//        return contextList;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_test, viewGroup, false);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
