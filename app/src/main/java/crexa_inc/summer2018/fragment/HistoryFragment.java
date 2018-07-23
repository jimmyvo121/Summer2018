package crexa_inc.summer2018.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import crexa_inc.summer2018.MainActivity;
import crexa_inc.summer2018.R;
import crexa_inc.summer2018.activity.HistoryActivity;
import crexa_inc.summer2018.activity.MenuActivity;
import crexa_inc.summer2018.adapter.HistoryAdapter;
import crexa_inc.summer2018.adapter.MainViewPagerAdapter;


public class HistoryFragment extends TestFragment {

    private View view;
    private MainActivity mContent;

    @BindView(R.id.histoty_listview)
    ListView listView;
    private HistoryAdapter adapter;
    private List<Integer> list = new ArrayList<Integer>();


    ViewPager viewPager;


//    public HistoryFragment(Context context){
//        super(context);
//        this.mContent = (MainActivity)context;
//        LayoutInflater inflater = LayoutInflater.from(context);
//        view = inflater.inflate(R.layout.fragment_history, this);
//        ButterKnife.bind(this,view);
//
//
//
//
//    }
//    private void initViewPager() {
//        ArrayList<View> viewList = new ArrayList<View>();
//        viewList.add(new HistoryFragment.(this));
//        viewPager.setAdapter(new MainViewPagerAdapter(viewList));
//    }
//    private void initListView() {
//        adapter = new HistoryAdapter(mContext,mContext.getContent());
//
//        listView.setAdapter(adapter);
//    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent();
        intent.setClass(getActivity(), HistoryActivity.class);
        startActivity(intent);

    }
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
//        View view = inflater.inflate(R.layout.fragment_history, viewGroup, false);
//
//        return view;
//    }
}



