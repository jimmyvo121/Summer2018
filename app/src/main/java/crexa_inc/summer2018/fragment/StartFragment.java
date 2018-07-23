package crexa_inc.summer2018.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import crexa_inc.summer2018.MainActivity;
import crexa_inc.summer2018.R;
import crexa_inc.summer2018.activity.BaseActivity;
import crexa_inc.summer2018.activity.CustomDialogActivity;
import crexa_inc.summer2018.activity.ForGradeActivity;
import crexa_inc.summer2018.activity.HistoryActivity;
import crexa_inc.summer2018.activity.MenuActivity;
import crexa_inc.summer2018.activity.PhotoColorActivity;
import crexa_inc.summer2018.activity.RNGRGBActivity;
import crexa_inc.summer2018.adapter.MainListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {


    public List<String> list = new ArrayList<String>();
    public MainListAdapter adapter;
    private ListView listView;

    private List<Pair<String, Fragment>> fragmentList = new ArrayList<>();

    public StartFragment(){
        list.add("Random Color");
        list.add("CustomColor Activity");
        list.add("History");
        list.add("for grade");
        list.add("Photo selecter");


    }




    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //((MainActivity)getActivity()).startActivity(RNGRGBActivity.class);
        Intent intent = new Intent();
        intent.setClass(getActivity(), MenuActivity.class);
        startActivity(intent);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        listView = view.findViewById(R.id.main_START_listview);
        adapter = new MainListAdapter(getContext(), list);
        listView.setAdapter(adapter);

        View headerView = new View(getActivity());
        listView.addHeaderView(headerView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent = new Intent();

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        //go to activity LaunchMode
                        intent.setClass(getActivity(), RNGRGBActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        ((MainActivity)getActivity()).startActivity(CustomDialogActivity.class);
                        break;

                    case 3:
                        ((MainActivity)getActivity()).startActivity(HistoryActivity.class);
                        break;

                    case 4:
                        ((MainActivity)getActivity()).startActivity(ForGradeActivity.class);
                        break;

                    case 5:
                        ((MainActivity)getActivity()).startActivity(PhotoColorActivity.class);
                        break;

                    default:
                }
            }
        });
        return view;
    }
}
