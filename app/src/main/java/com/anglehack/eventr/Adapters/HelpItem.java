package com.anglehack.eventr.Adapters;

/**
 * Created by Adham32 on 11.06.2017.
 */

public class HelpItem {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HelpItem(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
