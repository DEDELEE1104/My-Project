package com.example.myfragment1.Collect_movies;

import android.content.ContentValues;
import android.database.Cursor;

public class Collect_movie {
    private int sid, getSid;
    private String moviename;
    private byte[] moviepic;
    private String movielength;
    private String englishname;

    public Collect_movie() {

    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getGetSid() {
        return getSid;
    }

    public void setGetSid(int getSid) {
        this.getSid = getSid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public byte[] getMoviepic() {
        return moviepic;
    }

    public void setMoviepic(byte[] moviepic) {
        this.moviepic = moviepic;
    }

    public String getMovielength() {
        return movielength;
    }

    public void setMovielength(String movielength) {
        this.movielength = movielength;
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Collect_movie(int sid, int getSid, String moviename, byte[] moviepic, String movielength, String englishname) {
        this.sid = sid;
        this.getSid = getSid;
        this.moviename = moviename;
        this.moviepic = moviepic;
        this.movielength = movielength;
        this.englishname = englishname;
    }

    public void fromCursor(Cursor cursor) {
        sid = cursor.getInt(cursor.getColumnIndex("sid"));
        moviename = cursor.getString(cursor.getColumnIndex("moviename"));
        moviepic = cursor.getBlob(cursor.getColumnIndex("moviepic"));
        movielength = cursor.getString(cursor.getColumnIndex("movielength"));
        englishname = cursor.getString(cursor.getColumnIndex("englishname"));
        getSid = cursor.getInt(cursor.getColumnIndex("getsid"));
    }

    public ContentValues toContentValues() {
        ContentValues data = new ContentValues();
        data.put("moviename",this.moviename);
        data.put("moviepic",this.moviepic);
        data.put("movielength",this.movielength);
        data.put("englishname",this.englishname);
        data.put("getsid",this.getSid);
        return data;
    }


}