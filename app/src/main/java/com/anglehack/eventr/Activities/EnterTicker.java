package com.anglehack.eventr.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.anglehack.eventr.Controlers.ActivityControler;
import com.anglehack.eventr.R;
import com.bumptech.glide.Glide;

public class EnterTicker extends AppCompatActivity {

    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_ticker);
        flag = false;
        final ImageView im = (ImageView) findViewById(R.id.imageView9);
        Glide.with(getApplicationContext()).load(R.drawable.ticketenter).into(im);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag){
                    Glide.with(getApplicationContext()).load(R.drawable.win).into(im);
                    flag = true;
                }else{
                    ActivityControler.openMainActivity(EnterTicker.this);
                }
            }
        });
    }
}
