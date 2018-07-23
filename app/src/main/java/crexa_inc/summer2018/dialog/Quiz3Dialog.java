package crexa_inc.summer2018.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.RadioGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import crexa_inc.summer2018.R;

public class Quiz3Dialog extends Dialog
{
    private int checkedId;

    @OnClick(R.id.dialog_radio_ok)
    public void onClick()
    {
        switch (checkedId)
        {
            case R.id.dialog_radio_REB:
                listener.onREDClickListener("RED");
                dismiss();
                break;
            case R.id.dialog_radio_GREEN:
                listener.onGREENClickListener("GREEN");
                dismiss();
                break;
            case R.id.dialog_radio_BLUE:
                listener.onBLUEClickListener("BLUE");
                dismiss();
                break;
            default:
        }
    }

    @OnClick(R.id.dialog_radio_cancel)
    public void cancel()
    {
        dismiss();
    }

    //Define variable of the listener
    private IQuiz3DialogEventListener listener;

    //Define interface: Listener
    public interface IQuiz3DialogEventListener
    {
        void onREDClickListener(String msg);
        void onGREENClickListener(String msg);
        void onBLUEClickListener(String msg);
    }

    public Quiz3Dialog(@NonNull Context context, IQuiz3DialogEventListener listener)
    {
        super(context, R.style.dialog);
        //receive the listener from outside
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_radio);
        ButterKnife.bind(this);

        RadioGroup radioGroup = findViewById(R.id.dialog_radio_radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                Quiz3Dialog.this.checkedId = checkedId;
//
            }
        });
    }
}
