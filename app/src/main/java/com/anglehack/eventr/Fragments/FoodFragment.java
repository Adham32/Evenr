package com.anglehack.eventr.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.anglehack.eventr.Controlers.ActivityControler;
import com.anglehack.eventr.Interface.MenuFragment;
import com.anglehack.eventr.R;
import com.bumptech.glide.Glide;

/**
 * Created by Adham32 on 10.06.2017.
 */

public class FoodFragment extends Fragment implements MenuFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.food_fragment, container, false);
        ImageView im = (ImageView) v.findViewById(R.id.imageView10);
        Glide.with(getContext()).load(R.drawable.shop_list).into(im);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityControler.openFoodDetialsActivity((AppCompatActivity) getActivity());
            }
        });
        return v;
    }


}
