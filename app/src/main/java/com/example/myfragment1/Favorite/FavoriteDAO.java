package com.example.myfragment1.Favorite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class FavoriteDAO {
    private static final String DB_NAME="heros.db";
    public static final String TAG="SQLITE";
    private Context ctx;

    public FavoriteDAO(Context ctx) {
        this.ctx = ctx;
        //複製DB
        File dbFile=ctx.getDatabasePath(DB_NAME);
        if(!dbFile.exists()){
            File parentDir = new File(dbFile.getParent());
            if(!parentDir.exists()){
                parentDir.mkdir();
            }
            InputStream is=null;
            OutputStream os=null;
            try{
                is=ctx.getAssets().open(DB_NAME);
                os=new FileOutputStream(dbFile);
                byte[] buffer = new byte[1024];
                int read=is.read(buffer);
                while(read>0){
                    os.write(buffer,0,read);
                    read=is.read(buffer);
                }
            }catch(Exception e){
                Log.e("TAG",e.getMessage());
            }finally{
                if(is!=null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(os!=null){
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    private SQLiteDatabase getReadableDatatbase(){
        File dbFile=ctx.getDatabasePath(DB_NAME);
        return SQLiteDatabase.openDatabase(dbFile.getPath(),null, SQLiteDatabase.OPEN_READONLY);
    }
    private SQLiteDatabase getWriteableDatabase(){
        File dbFile=ctx.getDatabasePath(DB_NAME);
        return  SQLiteDatabase.openDatabase(dbFile.getPath(),null, SQLiteDatabase.OPEN_READWRITE);
    }
    public ArrayList<Favorite> getAllConteacts(){
        ArrayList<Favorite> ret=new ArrayList<Favorite>();
        SQLiteDatabase db=getReadableDatatbase();
        Cursor cursor=db.rawQuery("SELECT * FROM hero",null);
        if(cursor.moveToFirst()){
            do{
                Favorite data = new Favorite();
                data.fromCursor(cursor);
                ret.add(data);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return ret;
    }
    public ArrayList<Favorite> getContactByName(String mtname){
        ArrayList<Favorite> ret=new ArrayList<Favorite>();
        SQLiteDatabase db= getReadableDatatbase();
        String sql= String.format("SELECT * FROM hero WHERE name like '%%%s%%'",mtname);
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                Favorite data = new Favorite();
                data.fromCursor(cursor);
                ret.add(data);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return ret;
    }
    //單筆查詢
    public Favorite getContactById(int sid){
        Favorite ret=null;
        SQLiteDatabase db=getReadableDatatbase();
        String sql= String.format("SELECT * FROM hero WHERE sid=%d",sid);
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            ret=new Favorite();
            ret.fromCursor(cursor);
        }
        cursor.close();
        db.close();
        return ret;
    }
    public void delete(int sid){
        SQLiteDatabase db=getWriteableDatabase();
        try{
            db.delete("hero","sid=?",new String[]{""+sid});
        }catch (Exception e){
            Log.e(TAG,e.getMessage());
        }
        db.close();
    }
    //新增資料
    public void insert(Favorite data){
        SQLiteDatabase db=getWriteableDatabase();
        try{
            db.insert("hero",null,data.toContentValues());
        }catch(Exception e){
            Log.e(TAG,e.getMessage());
        }
        db.close();
    }

    public void update(Favorite data){
        SQLiteDatabase db=getWriteableDatabase();
        try{
            db.update("hero",data.toContentValues(),"sid=?",new String[]{""+data.getSid()});
        }catch (Exception e){
            Log.e(TAG,e.getMessage());
        }
        db.close();
    }


}
