package com.example.dbinput;
import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;




public class MainActivity extends Activity {

    final String DB_NAME = "testDb01";




    Button button;

    EditText editText;

    ListView listView;

    SQLiteDatabase db;

    ArrayList<String> items = new ArrayList<String>();

    ArrayAdapter<String> adapter;




    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        

        button = (Button) findViewById(R.id.Button_addList);

        editText = (EditText) findViewById(R.id.EditText);

        listView = (ListView) findViewById(R.id.ListView);




        adapter = new ArrayAdapter<String>(getApplicationContext(),

                android.R.layout.simple_list_item_1, items);

        listView.setAdapter(adapter);

        

        db = new DatabaseHelper(this).getWritableDatabase();

        updateDb();




        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                String text = editText.getText().toString();

                if(text.length()==0){

                    return;

                }

                ContentValues cv = new ContentValues();

                cv.put("title", text);

                db.insert(DB_NAME, "null", cv);




                updateDb();

            }

        });

    }




    public void updateDb() {

       items.clear();

        String[] columns = { "title" };

        Cursor c = db.query(DB_NAME, columns, null, null, null, null, null);

        if (c.getCount() <= 0) {

          adapter.notifyDataSetChanged();

            return;

        }

       

        c.moveToFirst();

        while (!c.isAfterLast()) {

            String name = c.getString(0);

            items.add(name);

            c.moveToNext();

        }

        adapter.notifyDataSetChanged();

        c.close();

    }




    private class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {

            super(context, DB_NAME, null, 1);

        }




        @Override

        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE " + DB_NAME

                    + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT)");

        }




        @Override

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {




        }

    }

}


