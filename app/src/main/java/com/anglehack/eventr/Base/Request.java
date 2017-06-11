package com.anglehack.eventr.Base;

/**
 * Created by Adham32 on 11.06.2017.
 */

public class Request {
    private String comment;
    private String date;
    private String id;
    private String type;

    public Request(String comment, String date, String id, String type) {
        this.comment = comment;
        this.date = date;
        this.id = id;
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
