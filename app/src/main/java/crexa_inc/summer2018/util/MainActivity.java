package crexa_inc.summer2018.util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;
import crexa_inc.summer2018.R;
import crexa_inc.summer2018.activity.BaseActivity;
import crexa_inc.summer2018.activity.RNGRGBActivity;

public class MainActivity extends BaseActivity {


    View view;

    @OnClick(R.id.start_bt)
    public void start(View view) {
        Intent intent = new Intent();
        intent.setClass();
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    private void setListener() {
        final ColorsFragment demoFragment = new ColorsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_layout, demoFragment).commit();

    }
}