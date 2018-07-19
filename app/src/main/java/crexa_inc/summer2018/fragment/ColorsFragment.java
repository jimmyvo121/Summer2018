package crexa_inc.summer2018.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;


import crexa_inc.summer2018.activity.RNGRGBActivity;


public class ColorsFragment extends Fragment {




    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //((MainActivity)getActivity()).startActivity(RNGRGBActivity.class);
        Intent intent = new Intent();
        intent.setClass(getActivity(), RNGRGBActivity.class);
        startActivity(intent);
    }


}
