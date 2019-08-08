package com.example.myfragment1.collect;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.myfragment1.Collect_movies.Collect_movie;

public class Collect extends Collect_movie {
    private int sid;
    private String heroname;
    private String herorace;
    private String actor;
    private byte[] heropic;
    private int getsid;

    public Collect(int sid, String heroname, String herorace, String actor, byte[]heropic){
        this.sid=sid;
        this.heroname=heroname;
        this.herorace=herorace;
        this.actor=actor;
        this.heropic=heropic;
    }

    public Collect() {

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

    public int getGetsid() {
        return getsid;
    }

    public void setGetsid(int getsid) {
        this.getsid = getsid;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public void fromCursor(Cursor cursor){
        sid=cursor.getInt(cursor.getColumnIndex("sid"));
        heroname=cursor.getString(cursor.getColumnIndex("heroname"));
        herorace=cursor.getString(cursor.getColumnIndex("herorace"));
        actor=cursor.getString(cursor.getColumnIndex("actor"));
        heropic=cursor.getBlob(cursor.getColumnIndex("heropic"));
        getsid=cursor.getInt(cursor.getColumnIndex("getsid"));
    }
    public ContentValues toContentValues(){
        ContentValues data=new ContentValues();
        data.put("heroname",this.heroname);
        data.put("herorace",this.herorace);
        data.put("actor",this.actor);
        data.put("heropic",this.heropic);
        data.put("getsid",this.getsid);
        return data;
    }
}

