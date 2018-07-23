package crexa_inc.summer2018.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import crexa_inc.summer2018.R;
import crexa_inc.summer2018.adapter.AdvListAdapter;
import crexa_inc.summer2018.adapter.MainViewPagerAdapter;
import crexa_inc.summer2018.fragment.HistoryFragment;

public class HistoryActivity extends AppCompatActivity {

    private ListView listView;
    private List<Integer> list = new ArrayList<Integer>();
    private AdvListAdapter adapter;

    @BindView(R.id.main_view_pager)
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        //ButterKnife.bind(this);
        //initViewPager();

        list.add(2123123);
        list.add(2222222);
        list.add(1100100);
        list.add(2200200);
        list.add(3300300);

        listView = findViewById(R.id.histoty_listview);
        adapter = new AdvListAdapter(this, list);
//        listView.setAdapter(adapter);

    }
    private void initViewPager() {
        ArrayList<View> viewList = new ArrayList<View>();

        //viewList.add(new HistoryFragment(this.context));
        viewPager.setAdapter(new MainViewPagerAdapter(viewList));
    }
}
