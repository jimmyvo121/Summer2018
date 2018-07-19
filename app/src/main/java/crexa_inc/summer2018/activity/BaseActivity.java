package crexa_inc.summer2018.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

import crexa_inc.summer2018.R;
import crexa_inc.summer2018.adapter.ViewPagerAdapter;
import crexa_inc.summer2018.fragment.StartFragment;

public class BaseActivity extends AppCompatActivity {
    public void startActivity(Class<?> cls){
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }
    public void startActivity(Class<?> key, String s){
        Intent intent = new Intent();
        intent.setClass(this, key);
        // intent.putExtra(key,s);
        startActivity(intent);
    }

    public void toastShort(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void toastLong(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_colors);
        viewPager = findViewById(R.id.viewpager_viewpager);
        fragmentList.add(new StartFragment());
        fragmentList.add(new StartFragment());

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);

    }

}
