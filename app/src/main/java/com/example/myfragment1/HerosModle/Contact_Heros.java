package com.example.myfragment1.HerosModle;

import android.database.Cursor;

public class Contact_Heros {
    private int sid;
    private String heroname;
    private String herorace;
    private String actor;
    private byte[] heropic;

    public Contact_Heros(String heroname, String herorace, String actor, byte[] heropic) {
        this.heroname = heroname;
        this.herorace = herorace;
        this.actor = actor;
        this.heropic = heropic;
    }
    public Contact_Heros(){

    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getHeroname() {
        return heroname;
    }

    public void setHeroname(String heroname) {
        this.heroname = heroname;
    }

    public String getHerorace() {
        return herorace;
    }

    public void setHerorace(String herorace) {
        this.herorace = herorace;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public byte[] getHeropic() {
        return heropic;
    }

    public void setHeropic(byte[] heropic) {
        this.heropic = heropic;
    }

    @Override
    public String toString() {
        return "Contact_Heros{" +
                "heroname='" + heroname + '\'' +
                ", herorace='" + herorace + '\'' +
                ", actor='" + actor + '\'' +
                '}';
    }

    public void fromCursor(Cursor cursor) {
        sid=cursor.getInt(cursor.getColumnIndex("sid"));
        heroname=cursor.getString(cursor.getColumnIndex("heroname"));
        herorace=cursor.getString(cursor.getColumnIndex("herorace"));
        actor=cursor.getString(cursor.getColumnIndex("actor"));
        heropic=cursor.getBlob(cursor.getColumnIndex("heropic"));

    }
}
