package com.anglehack.eventr.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.anglehack.eventr.Controlers.ActivityControler;
import com.anglehack.eventr.Interface.MenuFragment;
import com.anglehack.eventr.R;
import com.bumptech.glide.Glide;

/**
 * Created by Adham32 on 10.06.2017.
 */

public class FunFragment extends Fragment implements MenuFragment {

    private ImageView start;
    private AppCompatActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fun_fragment, container, false);

        start = (ImageView) v.findViewById(R.id.start_btn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityControler.openGameActivity(activity);
            }
        });


        ImageView ll = (ImageView) v.findViewById(R.id.imageView5);
        Glide.with(getContext()).load(R.drawable.game_bg).into(ll);
        return v;
    }

    public void setActivity(AppCompatActivity activity) {
        this.activity = activity;
    }
}
