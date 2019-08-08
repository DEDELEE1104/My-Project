package com.example.myfragment1.Favorite_Movie;

import android.content.ContentValues;
import android.database.Cursor;

public class Favorite_movies {
    private int sid;
    private String moviename;
    private byte[] moviepic;
    private String movielength;
    private String englishname;
    private String collect;

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public Favorite_movies(int sid, String moviename, byte[] moviepic, String movielength, String englishname) {
        this.sid = sid;
        this.moviename = moviename;
        this.moviepic = moviepic;
        this.movielength = movielength;
        this.englishname = englishname;
    }
    public Favorite_movies(){

    }


    @Override
    public String toString() {
        return super.toString();
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    public void fromCursor(Cursor cursor){
        sid=cursor.getInt(cursor.getColumnIndex("sid"));
        moviename=cursor.getString(cursor.getColumnIndex("moviename"));
        moviepic=cursor.getBlob(cursor.getColumnIndex("moviepic"));
        movielength=cursor.getString(cursor.getColumnIndex("movielength"));
        englishname=cursor.getString(cursor.getColumnIndex("englishname"));
        collect=cursor.getString(cursor.getColumnIndex("collect"));
    }
    public ContentValues toContentValues(){
        ContentValues data=new ContentValues();
        data.put("collect",this.collect);
        return data;
    }
}
