package crexa_inc.summer2018;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;

import crexa_inc.summer2018.R;
import crexa_inc.summer2018.activity.BaseActivity;
import crexa_inc.summer2018.fragment.ColorsFragment;






public class MainActivity extends BaseActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setListener();

    }

    private void setListener() {
        final ColorsFragment colorsFragment = new ColorsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_view, colorsFragment).commit();

    }
}