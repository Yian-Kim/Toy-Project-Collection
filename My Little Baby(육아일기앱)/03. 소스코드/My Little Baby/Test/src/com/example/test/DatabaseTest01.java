package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
 
public class DatabaseTest01 extends Activity {
 
    dbHelper helper;
    SQLiteDatabase db;
    EditText edit_name, edit_tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        helper = new dbHelper(this);
        try {
            db = helper.getWritableDatabase();
            //데이터베이스 객체를 얻기 위하여 getWritableDatabse()를 호출
           
        } catch (SQLiteException e) {
            db = helper.getReadableDatabase();
        }
       
        edit_name = (EditText) findViewById(R.id.name);
        edit_tel = (EditText) findViewById(R.id.tel);
       
       
        //버튼에 대한 클릭 처리기를 작성.
       
        //추가 버튼.
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
           
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString();
                String tel = edit_tel.getText().toString();
               
                db.execSQL("INSERT INTO contact VALUES(null, '"+name+"','"+tel+"');");
               
            }
        });
       
        //검색 버튼
        findViewById(R.id.query).setOnClickListener(new View.OnClickListener() {
           
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString();
                Cursor cursor;
                cursor = db.rawQuery("SELECT name, tel FROM contact where name='"+name+"';" , null);
               
                while(cursor.moveToNext()){
                    String tel = cursor.getString(1);
                    edit_tel.setText(tel);
                }
            }
        });
       
    }
 
 
 
}
 
class dbHelper extends SQLiteOpenHelper{
   
   
    private static final String DATABASE_NAME = "mycontacts.db";
    private static final int DATABASE_VERSION =1;
   
   
    /*
     *먼저 SQLiteOpenHelper클래스를 상속받은 dbHelper클래스가 정의 되어 있다. 데이터베이스 파일 이름은 "mycontacts.db"가되고,
     *데이터베이스 버전은 1로 되어있다. 만약 데이터베이스가 요청되었는데 데이터베이스가 없으면 onCreate()를 호출하여 데이터베이스
     *파일을 생성해준다.
     */
   
    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
           
    }
   
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contact (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, tel TEXT);");
       
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS contact");
        onCreate(db);  
    }
   
   
   
}

