package com.anglehack.eventr.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.anglehack.eventr.API.ApiConnector;
import com.anglehack.eventr.R;
import com.bumptech.glide.Glide;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        ImageView im = (ImageView) findViewById(R.id.imageView6);
        Glide.with(getApplicationContext()).load(R.drawable.req_help).into(im);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.close_);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setWindowTitle("Help");
            actionBar.setDisplayShowTitleEnabled(true);
        }

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiConnector.getInstance().writeNewPost(HelpActivity.this);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
