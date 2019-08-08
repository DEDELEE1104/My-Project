package com.example.myfragment1.Favorite;

import android.content.ContentValues;
import android.database.Cursor;

public class Favorite {
        private int sid;
        private String heroname,herorace,actor,collect;
        private byte[] heropic;
 public Favorite(int sid, String heroname, String herorace, String actor, byte[]heropic) {
     this.sid = sid;
     this.heroname = heroname;
     this.herorace = herorace;
     this.actor = actor;
     this.heropic = heropic;
 }

    public Favorite() {

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

        public String getCollect() {
            return collect;
        }

        public void setCollect(String collect) {
            this.collect = collect;
        }

        public byte[] getHeropic() {
            return heropic;
        }

        public void setHeropic(byte[] heropic) {
            this.heropic = heropic;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        public void fromCursor(Cursor cursor) {
            sid=cursor.getInt(cursor.getColumnIndex("sid"));
            heroname=cursor.getString(cursor.getColumnIndex("heroname"));
            herorace=cursor.getString(cursor.getColumnIndex("herorace"));
            actor=cursor.getString(cursor.getColumnIndex("actor"));
            heropic=cursor.getBlob(cursor.getColumnIndex("heropic"));
           collect=cursor.getString(cursor.getColumnIndex("collect"));

        }
    public ContentValues toContentValues() {
     ContentValues data=new ContentValues();
     data.put("collect",this.collect);
     return data;
    }
    }
