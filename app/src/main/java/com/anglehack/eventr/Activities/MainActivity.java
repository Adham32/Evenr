package com.anglehack.eventr.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.anglehack.eventr.API.DownloadedData;
import com.anglehack.eventr.Base.Category;
import com.anglehack.eventr.Fragments.FoodFragment;
import com.anglehack.eventr.Fragments.FunFragment;
import com.anglehack.eventr.Fragments.HelpFragment;
import com.anglehack.eventr.Fragments.StatisticFragment;
import com.anglehack.eventr.Interface.MenuFragment;
import com.anglehack.eventr.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MenuFragment> menuItemList;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            changeFragment(item.getItemId());
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = navigation.getMenu();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        for(Category c : DownloadedData.getInstance().getCategories() ){
            switch (c.getId()){
                case 1:
                    menu.add(0, c.getId(), 0, c.getName()).setIcon(R.drawable.icon_live);
                    break;
                case 2:
                    menu.add(0, c.getId(), 0, c.getName()).setIcon(R.drawable.icon_service);
                    break;
                case 3:
                    menu.add(0, c.getId(), 0, c.getName()).setIcon(R.drawable.icon_fun);
                    break;
                case 4:
                    menu.add(0, c.getId(), 0, c.getName()).setIcon(R.drawable.icon_help);
                    break;
            }
            //edit_item.setIcon(R.drawable.edit);
        }
        inital();
        readMenuData();
        changeFragment(1);
    }

    private void inital() {
        menuItemList = new ArrayList<>();
    }

    private void readMenuData() {
        ArrayList<Category> categories = DownloadedData.getInstance().getCategories();
        for(Category c: categories){
            switch (c.getId()){
                case 1:
                    createNewsStatisticFragment();
                    break;
                case 2:
                    createFoodFragment();
                    break;
                case 3:
                    createFunFragment();
                    break;
                case 4:
                    createHelpFragment();
                    break;
                default:
                    Log.d("EiApp","Error in MainActivity / readMenuData - no id category");
                    break;
            }
        }
    }

    private void createFunFragment() {
        FunFragment ff = new FunFragment();
        ff.setActivity(MainActivity.this);
        menuItemList.add(ff);
    }

    private void createHelpFragment() {
        HelpFragment hf = new HelpFragment();
        menuItemList.add(hf);
    }

    private void createFoodFragment() {
        FoodFragment fff = new FoodFragment();
        menuItemList.add(fff);
    }


    private void createNewsStatisticFragment(){
        StatisticFragment sf = new StatisticFragment();
        menuItemList.add(sf);
    }


    private void changeFragment(int i){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_main_act, (Fragment) menuItemList.get(i-1));
        fragmentTransaction.commit();
    }


}
