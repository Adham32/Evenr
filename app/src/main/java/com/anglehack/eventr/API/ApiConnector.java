package com.anglehack.eventr.API;

import android.util.Log;

import com.anglehack.eventr.Activities.HelpActivity;
import com.anglehack.eventr.AsyncTask.DownloadInitalChecker;
import com.anglehack.eventr.Base.Category;
import com.anglehack.eventr.Base.News;
import com.anglehack.eventr.Base.Request;
import com.anglehack.eventr.Interface.NewsListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Adham32 on 10.06.2017.
 */

public class ApiConnector {
    private static final ApiConnector ourInstance = new ApiConnector();

    public static ApiConnector getInstance() {
        return ourInstance;
    }

    private ApiConnector() {
    }


    public void downloadCategory(final DownloadInitalChecker downloadInitalChecker){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("Category");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Category> categories = new ArrayList<>();
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    Category value = (Category) postSnapshot.getValue(Category.class);
                    categories.add(value);
                }
                if(!categories.isEmpty()){
                    DownloadedData.getInstance().setCategories(categories);
                    downloadInitalChecker.setCategoriesEnd();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("EiD", "Error in  DownloadedData / downloadCategory");
                String message = databaseError.getMessage();
                int code = databaseError.getCode();
            }
        });
    }

    public void downloadNews(final NewsListener newsListener){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("News");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    News news = postSnapshot.getValue(News.class);
                    newsListener.newNewsRecive(news);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("EiD", "Error in  DownloadedData / downloadNews");
                String message = databaseError.getMessage();
                int code = databaseError.getCode();
            }
        });
    }


    public void writeNewPost(HelpActivity helpActivity) {

        String uniqueId = UUID.randomUUID().toString();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("Request");
        String key = databaseReference.child("Request").push().getKey();
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm dd-MM-yyyy");
        String format = df.format(instance.getTime());
        Request post = new Request("Myy arm is broken!!!! I cant evn prperly typeee", format, uniqueId, "health");
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put(uniqueId, post);
        databaseReference.updateChildren(requestMap);
        helpActivity.finish();

    }
}
