package com.anglehack.eventr.Base;

/**
 * Created by Adham32 on 10.06.2017.
 */

public class News {

    private String datetime;
    private String description;
    private int kind;
    private int scoreTeam1;
    private int ScoreTeam2;
    private int time;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public void setScoreTeam1(int scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
    }

    public int getScoreTeam2() {
        return ScoreTeam2;
    }

    public void setScoreTeam2(int scoreTeam2) {
        ScoreTeam2 = scoreTeam2;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
