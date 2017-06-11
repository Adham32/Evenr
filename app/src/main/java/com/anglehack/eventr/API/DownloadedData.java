package com.anglehack.eventr.API;

import com.anglehack.eventr.Base.Category;

import java.util.ArrayList;

/**
 * Created by Adham32 on 10.06.2017.
 */

public class DownloadedData {

    private ArrayList<Category> categories;
    private static final DownloadedData ourInstance = new DownloadedData();

    public static DownloadedData getInstance() {
        return ourInstance;
    }

    private DownloadedData() {
        categories = new ArrayList<>();
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
}
