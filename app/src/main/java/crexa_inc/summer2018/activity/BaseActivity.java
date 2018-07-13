package crexa_inc.summer2018.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

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


}
