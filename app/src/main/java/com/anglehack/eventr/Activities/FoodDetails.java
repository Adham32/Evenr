package com.anglehack.eventr.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.anglehack.eventr.Controlers.ActivityControler;
import com.anglehack.eventr.R;
import com.bumptech.glide.Glide;

public class FoodDetails extends AppCompatActivity {
    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        final ImageView im  = (ImageView) findViewById(R.id.imageView11);
        Glide.with(getApplicationContext()).load(R.drawable.kfc).into(im);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag){
                Glide.with(getApplicationContext()).load(R.drawable.dialog).into(im);
                    flag = true;
                }else{
                    ActivityControler.openMainActivity(FoodDetails.this);
                }
            }
        });

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.close_);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
        }
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
