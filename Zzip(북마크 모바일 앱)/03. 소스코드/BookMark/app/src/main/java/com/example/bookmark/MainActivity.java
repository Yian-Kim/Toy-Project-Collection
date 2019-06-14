package com.example.csp.bookmark;

import java.util.ArrayList;
import android.app.Activity;
import android.widget.Toast;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView;
//db 관련 헤더들
import android.database.Cursor;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;




public class MainActivity extends Activity {

    public  ArrayList<String> list=null;
    public  ArrayAdapter<String> adapter=null;
    public  ListView lv;
    Button btn;
    //db 관련

    private DBManager mDBManager;
    private SQLiteDatabase db;





    String sharedText=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intentUri = getIntent();
        String action = intentUri.getAction();
        String type = intentUri.getType();
        list = new ArrayList<String>();
        btn = (Button)findViewById(R.id.button);
        mDBManager =new DBManager(getApplicationContext());


        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, list);

        lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener(new ListViewItemClickListener());
        lv.setAdapter(adapter);

        selectAll();

      //  db = mDBManager.getWritableDatabase();
       // selectAll();

        if (Intent.ACTION_SEND.equals(action) && type != null) { // 공유된 상태 확인
            if ("text/plain".equals(type)) {
                sharedText = intentUri.getStringExtra(Intent.EXTRA_TEXT);    // 가져온 인텐트의 텍스트 정보
                new AlertDialog.Builder(this)
                        .setTitle("WISHROOM")
                        .setMessage(sharedText )
                        .setPositiveButton(android.R.string.ok, null)
                        .setCancelable(false)
                        .create()
                        .show();


            }
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // int temp = handler.selectNum();

                insert("URL ", sharedText);

                Toast.makeText(getApplicationContext(),sharedText, Toast.LENGTH_SHORT).show();



                adapter.clear();

                selectAll();




                  close();

            }
        });









    }

    private class ListViewItemClickListener implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
                String[] temp = adapter.getItem(position).split(" ");
           Toast.makeText(getApplicationContext(),temp[2], Toast.LENGTH_SHORT).show();

            Uri uri = Uri.parse(temp[2]);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }
    }

    public void close() {
        db.close();
    }
    //저장


    public void insert (String tag , String url ){
        String query  ="insert into myUrl values('" + tag + "', '" + url + "');";

        db = mDBManager.getWritableDatabase();
        db.execSQL(query);

        Toast.makeText(getApplicationContext(),"insert 완료", Toast.LENGTH_SHORT).show();

    }


    //가저오기
    public void selectAll(){
        db =mDBManager.getReadableDatabase();
        String sql = "select * from myUrl";
        Cursor results = db.rawQuery(sql, null);

        results.moveToFirst();

        while(results.moveToNext()){
            String tag = results.getString(0);
            String  url = results.getString(1);



            adapter.add(tag+" "+url);


        }

        results.close();
    }


}

class DBManager extends SQLiteOpenHelper {
    private final static String TB_NAME = "myUrl";
    public static final String DB_NAME = "myUrl.db";
    public static final int DB_VERSION = 1;
    String quary ;

    //constructor
    public DBManager(Context context) {
        super(context, DB_NAME, null,DB_VERSION);

        quary = "CREATE TABLE "+ TB_NAME  + "(" + "tag TEXT"
                + "," + "url TEXT"
                + ");";


    }


    //테이블을 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(quary);

    }
    //업그레이드
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}