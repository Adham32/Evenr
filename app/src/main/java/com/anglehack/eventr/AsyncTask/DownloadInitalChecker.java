package com.anglehack.eventr.AsyncTask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

import com.anglehack.eventr.API.ApiConnector;
import com.anglehack.eventr.Controlers.ActivityControler;
import com.anglehack.eventr.Interface.DownloadInitalListener;

/**
 * Created by Adham32 on 10.06.2017.
 */

public class DownloadInitalChecker extends AsyncTask<Void,Void,Void>  implements DownloadInitalListener {

    private final AppCompatActivity appCompatActivity;
    private boolean all;
    private boolean categoriesEnd;


    public DownloadInitalChecker(AppCompatActivity appCompatActivity){
        inital();
        this.appCompatActivity = appCompatActivity;
    }

    private void inital(){
        categoriesEnd = false;
    }

    @Override
    protected Void doInBackground(Void... params) {

        ApiConnector.getInstance().downloadCategory(DownloadInitalChecker.this);
        all = false;
        while(!all){
            checkDownloadProgress();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        ActivityControler.openTicketActivity(appCompatActivity);
    }

    private void checkDownloadProgress() {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean ct = categoriesEnd;
            all = ct;

    }

    @Override
    public void setCategoriesEnd() {
        categoriesEnd = true;
    }
}
