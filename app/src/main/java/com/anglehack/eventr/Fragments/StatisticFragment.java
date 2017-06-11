package com.anglehack.eventr.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anglehack.eventr.API.ApiConnector;
import com.anglehack.eventr.Adapters.NewsAdapter;
import com.anglehack.eventr.Base.News;
import com.anglehack.eventr.Interface.MenuFragment;
import com.anglehack.eventr.Interface.NewsListener;
import com.anglehack.eventr.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Adham32 on 10.06.2017.
 */

public class StatisticFragment extends Fragment implements MenuFragment, NewsListener {

    private NewsAdapter newsAdapter;
    private RecyclerView rv;
    private  TextView score;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.statistic_fragment , container, false);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        rv = (RecyclerView) v.findViewById(R.id.recyclerView);
        rv.setLayoutManager(layoutManager);
        newsAdapter = createAdapter(createNews());
        rv.setAdapter(newsAdapter);
        ApiConnector.getInstance().downloadNews(StatisticFragment.this);

        ImageView ll = (ImageView) v.findViewById(R.id.imageView);
        Glide.with(getContext()).load(R.drawable.flag_brasil).into(ll);

        ImageView l2l = (ImageView) v.findViewById(R.id.imageView2);
        Glide.with(getContext()).load(R.drawable.flag_spain).into(l2l);

        score = (TextView) v.findViewById(R.id.textView6);

        return v;
    }

    public ArrayList<News> createNews(){
        ArrayList<News> toReturn = new ArrayList<>();
        /*for( int i = 0; i<10 ; i++){
            toReturn.add(new News());
        }*/
        return toReturn;
    }

    public NewsAdapter createAdapter(ArrayList<News> newses){
        return new NewsAdapter(newses, getContext());
    }

    @Override
    public void newNewsRecive(News news) {
        if(newsAdapter != null){
            newsAdapter.addNews(news);
            setNewsMainInfo(news);
           /* Vibrator v = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(300);*/
        }
    }

    @Override
    public void setNewsMainInfo(News news) {
        String s = news.getScoreTeam1() + " - " + news.getScoreTeam2();
        score.setText(s);
    }
}
