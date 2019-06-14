package com.example.calendartest;

import java.util.ArrayList;

//import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CalendarModify extends CTCalendarView {
	private int test1, b1, receive, receive2, result;
	private TextView textView;
	private Intent intent2;

	final String DB_NAME = "testDb01";

	Button button;

	EditText editText;

	ListView listView;

	SQLiteDatabase db;

	ArrayList<String> items = new ArrayList<String>();

	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delete); // 메인액티비티 onCreate

		init();

	}

	public void init() {

		button = (Button) findViewById(R.id.Button_addList);

		editText = (EditText) findViewById(R.id.EditText);

		listView = (ListView) findViewById(R.id.ListView);

		setTitle("인텐트 넘어감~");
		intent2 = getIntent();
		textView = (TextView) findViewById(R.id.textView1);
		/*
		 * setTitle("인텐트 넘어감~"); intent2 = getIntent();
		 * text=(TextView)findViewById(R.id.textView1);
		 * x=intent2.getIntExtra("a",123456); if(x==1){ //intent1 = getIntent();
		 * b1=intent2.getIntExtra("bb1을 받음", 5); text.setText(b1+"");
		 * 
		 * }
		 */
		receive2 = intent2.getIntExtra("date", 1);

		// receive2에는 날짜가 들어감
		// result=intent2.getIntExtra("date", 123);
		textView.setText(receive2 + " ");
		// Toast.makeText(CalendarModify.this, textView.getText(),
		// Toast.LENGTH_LONG).show();

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				TextView tv = (TextView) v;

				String text = tv.getText().toString();

				db.delete(DB_NAME, "title='" + text + "'", null);

				updateDb();

			}

		});

		adapter = new ArrayAdapter<String>(getApplicationContext(),

		android.R.layout.simple_list_item_1, items);

		listView.setAdapter(adapter);

		db = new DatabaseHelper(this).getWritableDatabase();

		updateDb();

		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				String text = editText.getText().toString();

				if (text.length() == 0) {

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

