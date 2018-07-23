package crexa_inc.summer2018.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import crexa_inc.summer2018.R;
public class AdvListAdapter extends BaseAdapter {
    private Context context;
    private final LayoutInflater inflater;
    private List<Integer> list;
    


    public AdvListAdapter(Context context, List<Integer> list){
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
    }
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.color_item, parent, false);
            View view = convertView.findViewById(R.id.color_item_main);
            holder.view = view;
            convertView.setTag(holder);
        }


        holder = (ViewHolder) convertView.getTag();
        holder.view.setBackgroundColor(list.get(position));

        //View color = convertView.findViewById(R.id.color_item_main);



            holder.view.setVisibility(View.VISIBLE);

        return convertView;
    }

    private class ViewHolder
    {
        View view;
        TextView textView;
    }


}
