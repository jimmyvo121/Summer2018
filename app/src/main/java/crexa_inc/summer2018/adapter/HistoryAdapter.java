package crexa_inc.summer2018.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import crexa_inc.summer2018.R;

public class HistoryAdapter extends BaseAdapter {

    private final ArrayList<Integer> contentList;
    private final Context context;


    public HistoryAdapter(Context context, ArrayList<Integer> contentList) {
        this.contentList = contentList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contentList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder colorItem = null;
        if (convertView != null) {
            colorItem = (ViewHolder) convertView.getTag();
        } else {
            colorItem = new ViewHolder(convertView);
            convertView.setTag(colorItem);
        }

        Integer integer = (Integer) contentList.get(position);
        colorItem.colorName.setText(integer.toString());
        return convertView;
    }


    static class ViewHolder{
        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
        @BindView(R.id.color_item_text)
        TextView colorName;
        @BindView(R.id.color_item_main)
        View background;
    }

}
