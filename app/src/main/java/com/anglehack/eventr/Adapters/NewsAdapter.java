package com.anglehack.eventr.Adapters;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.anglehack.eventr.Base.News;
import com.anglehack.eventr.R;
import com.bumptech.glide.Glide;
import com.github.vipulasri.timelineview.TimelineView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Adham32 on 10.06.2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.TimeLineViewHolder> {

    private final Context context;
    private ArrayList<News> newsArray;
    private int time;

    public NewsAdapter(ArrayList<News> newsArray, Context context){
        this.newsArray = newsArray;
        time = 40;
        this.context = context;
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_news, null);

        return new TimeLineViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {
        News n = newsArray.get(position);

            holder.timeTV.setText(n.getTime() + "minute ago");
            if(n.getTime() < 5){
                setFadeAnimation(holder.itemView);
                holder.timeTV.setText("Just now");
            }

        switch (n.getKind()){
            case 1:
                //gola
                Glide.with(context).load(R.drawable.ball).into(holder.im);
                break;
            case 2:
                //sub
                Glide.with(context).load(R.drawable.arrows).into(holder.im);
                break;
            case 3:
                //yellow
                Glide.with(context).load(R.drawable.yellow_card).into(holder.im);
                break;

        }

        holder.descTV.setText(n.getDescription());
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position, getItemCount());
    }

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500);
        view.startAnimation(anim);
    }

    public void addNews(News n){
        n.setTime(time-=5);
        newsArray.add(0,n);

        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return newsArray.size();
    }


    public class TimeLineViewHolder extends RecyclerView.ViewHolder {

        public TimelineView mTimelineView;
        private TextView timeTV, descTV;
        private ImageView im ;

        public TimeLineViewHolder(View itemView, int viewType) {
            super(itemView);
            mTimelineView = (TimelineView) itemView.findViewById(R.id.time_marker);
            mTimelineView.initLine(viewType);
            timeTV = (TextView) itemView.findViewById(R.id.time_tv_it);
            descTV = (TextView) itemView.findViewById(R.id.desc_tv_it);
            im = (ImageView) itemView.findViewById(R.id.imageView13);
        }



    }
}
