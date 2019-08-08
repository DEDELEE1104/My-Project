package com.example.myfragment1.avengerModle;

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

public class ContactDAO_avenger {
    private static final String DB_NAME="avenger.db";
    public static final String TAG="SQLITE";
    private Context ctx;

    public ContactDAO_avenger(Context ctx) {
        this.ctx = ctx;
        //複製DB
        File dbFile=ctx.getDatabasePath(DB_NAME);
        if(!dbFile.exists()){
            File parentDir=new File(dbFile.getParent());
            if(!parentDir.exists()){
                parentDir.mkdir();
            }
            InputStream is=null;
            OutputStream os=null;
            try{
                is=ctx.getAssets().open(DB_NAME);
                os=new FileOutputStream(dbFile);
                byte[] buffer=new byte[1024];
                int read=is.read(buffer);
                while(read>0){
                    os.write(buffer,0,read);
                    read=is.read(buffer);
                }

            }catch (Exception e){
                Log.e("TAG",e.getMessage());
            }finally {
                if(is!=null){
                    try{
                        is.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                if(os!=null){
                    try{
                        os.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //讀
    private SQLiteDatabase getReadableDatabase(){
        File dbFile=ctx.getDatabasePath(DB_NAME);
        return SQLiteDatabase.openDatabase(dbFile.getPath(),null,SQLiteDatabase.OPEN_READONLY);
    }
    //寫
    private SQLiteDatabase getWriteableDatabase(){
        File dbFile=ctx.getDatabasePath(DB_NAME);
        return SQLiteDatabase.openDatabase(dbFile.getPath(),null,SQLiteDatabase.OPEN_READWRITE);
    }
    //查詢全部
    public ArrayList<Contact_avenger> getAllContacts(){
        ArrayList<Contact_avenger> ret=new ArrayList<Contact_avenger>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM avenger",null);
        if(cursor.moveToFirst()){
            do{
                Contact_avenger data=new Contact_avenger();
                data.fromCursor(cursor);
                ret.add(data);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return ret;
    }

    //關鍵字查詢
    public ArrayList<Contact_avenger> getContactByName(String name){
        ArrayList<Contact_avenger> ret=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String sql=String.format("SELECT * FROM avenger WHERE moviename like '%%%s%%'",name);
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                Contact_avenger data=new Contact_avenger();
                data.fromCursor(cursor);
                ret.add(data);
            }while(cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return ret;
    }




}
