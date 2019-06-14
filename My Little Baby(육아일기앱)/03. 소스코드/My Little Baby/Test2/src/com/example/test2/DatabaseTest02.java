package com.example.test2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
 
public class DatabaseTest02 extends Activity {
 
    dbHelper helper;
    SQLiteDatabase db;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_test02);
       
        helper = new dbHelper(this);
        db = helper.getWritableDatabase();
       
        //테이블의 모든 레코드를 커서객체로 가져온다.
        Cursor cursor = db.rawQuery("select * from contact",null);
       
        //startManagingCursor(cursor) 문장은 액티비티가 커서 객체를 관리하도록 한다.
        //즉 액티비티의 생액주기와 커서의 생애주기를 일치시키는것이다.
        //void android.app.Activity.startManagingCursor(Cursor c)
        startManagingCursor(cursor);
       
        String[] from = {"name", "tel"};
        int[] to = {android.R.id.text1, android.R.id.text2};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,cursor,from,to);
        //android.R.layout.simple_list_item_2라는 표준 레이아웃을 사용하는 커서 어댑터 객체를 생성한다. 이 표준 레이아웃은 2개의 텍스트뷰를
        //가지고 있으며 첫번째 텍스트뷰(android.R.id.text1)는 "name"필드를 표시하고 두번째 텍스트 부(android.R.id.text2)는 "tel"필드를 표시하도록 연결한다.
       
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
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
       
        //테이블 생성
        db.execSQL("CREATE TABLE contact (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, tel TEXT);");
       
        //테이블에 초기값 삽입(insert)
        for(int i=0; i<20; i++){
            db.execSQL("INSERT INTO contact VALUES(null, 'This is a sample data "+i+"','010-1234-100"+i+"');");
        }      
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS contact");
        onCreate(db);  
    }
   
}

