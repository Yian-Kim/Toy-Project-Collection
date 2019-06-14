package com.example.camera;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyHelper extends SQLiteOpenHelper {
    private static final String CREATE_QUERY= " create table " + UserInfo.TAB_NAME +
               " ( " + UserInfo.KEY_ID + " integer primary key autoincrement , "

               + UserInfo.F_NAME + " varchar(20), "

               + UserInfo.L_NAME + " varchar(20) , " + UserInfo.PIC + " blob ) ;" ;
    public MyHelper(Context c){
        super(c,UserInfo.DB_NAME,null,UserInfo.DB_VER);
    }

    @Override    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" drop table if exists " + UserInfo.TAB_NAME);
        onCreate(db);
    }
    public void putInfo(MyHelper mob,String fname,String lname, byte[]img){
        SQLiteDatabase sq=mob.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(UserInfo.F_NAME,fname);
        cv.put(UserInfo.L_NAME,lname);
        cv.put(UserInfo.PIC,img);
        sq.insert(UserInfo.TAB_NAME,null,cv);
    }
}
