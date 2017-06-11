package com.anglehack.eventr.Controlers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.anglehack.eventr.Activities.EnterTicker;
import com.anglehack.eventr.Activities.FoodDetails;
import com.anglehack.eventr.Activities.HelpActivity;
import com.anglehack.eventr.Activities.MainActivity;
import com.anglehack.eventr.Activities.GameActivity;

/**
 * Created by Adham32 on 10.06.2017.
 */

public abstract class ActivityControler {

    public static void openMainActivity(AppCompatActivity appCompatActivity){
        Intent i = new Intent(appCompatActivity.getApplicationContext(), MainActivity.class);
        appCompatActivity.startActivity(i);
        appCompatActivity.finish();
    }

    public static void openGameActivity(AppCompatActivity appCompatActivity){
        Intent i = new Intent(appCompatActivity.getApplicationContext(), GameActivity.class);
        appCompatActivity.startActivity(i);
    }

    public static void openHelpActivity(AppCompatActivity appCompatActivity) {
        Intent i = new Intent(appCompatActivity.getApplicationContext(), HelpActivity.class);
        appCompatActivity.startActivity(i);
    }
    public static void openTicketActivity(AppCompatActivity appCompatActivity) {
        Intent i = new Intent(appCompatActivity.getApplicationContext(), EnterTicker.class);
        appCompatActivity.startActivity(i);
        appCompatActivity.finish();
    }

    public static void openFoodDetialsActivity(AppCompatActivity appCompatActivity) {
        Intent i = new Intent(appCompatActivity.getApplicationContext(), FoodDetails.class);
        appCompatActivity.startActivity(i);
    }
}
