package com.anglehack.eventr.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.anglehack.eventr.Adapters.HelpAdapter;
import com.anglehack.eventr.Adapters.HelpItem;
import com.anglehack.eventr.Controlers.ActivityControler;
import com.anglehack.eventr.Interface.MenuFragment;
import com.anglehack.eventr.R;

import java.util.ArrayList;

/**
 * Created by Adham32 on 10.06.2017.
 */

public class HelpFragment extends Fragment implements MenuFragment{

    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.help_fragment, container, false);

        ArrayList<HelpItem> his = new ArrayList<>();
        HelpItem hi = new HelpItem(1,"Health");
        HelpItem hi2 = new HelpItem(2,"Security");
        HelpItem hi3 = new HelpItem(3,"Technical");
        his.add(hi);
        his.add(hi2);
        his.add(hi3);

        GridView gridview = (GridView) v.findViewById(R.id.grid);
        gridview.setAdapter(new HelpAdapter(this.getContext(), his));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                ActivityControler.openHelpActivity((AppCompatActivity) getActivity());
            }
        });

        return v;
    }

}
