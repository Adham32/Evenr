package com.anglehack.eventr.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.anglehack.eventr.API.ApiConnector;
import com.anglehack.eventr.AsyncTask.DownloadInitalChecker;
import com.anglehack.eventr.R;
import com.bumptech.glide.Glide;

public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        downloadFristData();
        ImageView im  = (ImageView) findViewById(R.id.imageView8);
        Glide.with(getApplicationContext()).load(R.drawable.evenr).into(im);

    }

    private void downloadFristData(){
        startAnimationOfDownload();
        DownloadInitalChecker dic = new DownloadInitalChecker(TitleActivity.this);
        dic.execute();
    }

    private void startAnimationOfDownload() {

    }




}
