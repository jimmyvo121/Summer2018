package crexa_inc.summer2018.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import crexa_inc.summer2018.R;
import crexa_inc.summer2018.adapter.ViewPagerAdapter;
import crexa_inc.summer2018.fragment.ColorsFragment;
import crexa_inc.summer2018.fragment.CompareColorFragment;
import crexa_inc.summer2018.fragment.HistoryFragment;

public class MenuActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        viewPager = findViewById(R.id.viewpager_viewpager);
        fragmentList.add(new ColorsFragment());
        //fragmentList.add(new HistoryFragment());
        fragmentList.add(new CompareColorFragment());


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);

    }
}
