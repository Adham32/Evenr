package com.anglehack.eventr.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anglehack.eventr.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Adham32 on 11.06.2017.
 */

public class HelpAdapter extends BaseAdapter {


    private final ArrayList<HelpItem> items;
    private Context mContext;

    public HelpAdapter(Context mContext, ArrayList<HelpItem> items) {
        this.mContext = mContext;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.item_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.textView15);
            ImageView imageView = (ImageView)grid.findViewById(R.id.imageView7);
            textView.setText(items.get(position).getName());

            switch (items.get(position).getId()){
                case 1:
                    Glide.with(mContext).load(R.drawable.icon_help_health).into(imageView);
                    break;
                case 2:
                    Glide.with(mContext).load(R.drawable.icon_help_security).into(imageView);
                    break;
                case 3:
                    Glide.with(mContext).load(R.drawable.icon_help_technical).into(imageView);
                    break;
            }
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
