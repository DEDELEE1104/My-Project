package com.example.myfragment1.avengerModle;

import android.database.Cursor;

public class Contact_avenger {
    private int sid;
    private String moviename;
    private String englishname;
    private String movielength;
    private byte[] moivepic;

    public Contact_avenger(String moviename, String englishname, String movielength, byte[] moivepic) {
        this.moviename = moviename;
        this.englishname = englishname;
        this.movielength = movielength;
        this.moivepic = moivepic;
    }

    public Contact_avenger(){

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

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname;
    }

    public String getMovielength() {
        return movielength;
    }

    public void setMovielength(String movielength) {
        this.movielength = movielength;
    }

    public byte[] getMoivepic() {
        return moivepic;
    }

    public void setMoivepic(byte[] moivepic) {
        this.moivepic = moivepic;
    }

    @Override
    public String toString() {
        return "Contact_avenger{" +
                "moviename='" + moviename + '\'' +
                ", englishname='" + englishname + '\'' +
                ", movielength='" + movielength + '\'' +
                '}';
    }

    public void fromCursor(Cursor cursor) {
        sid=cursor.getInt(cursor.getColumnIndex("sid"));
        moviename=cursor.getString(cursor.getColumnIndex("moviename"));
        englishname=cursor.getString(cursor.getColumnIndex("englishname"));
        movielength=cursor.getString(cursor.getColumnIndex("movielength"));
        moivepic=cursor.getBlob(cursor.getColumnIndex("moviepic"));

    }
}
