package com.example.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ExToday extends Activity implements OnItemClickListener,

OnClickListener { // 오늘의 일정 목록 띄우기

	MyDBHelper mDBHelper;

	String today;
	String time;
	private Calendar rightNow;
	
	Cursor cursor;

	SimpleCursorAdapter adapter;

	ListView list;

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.extoday);

		Intent intent = getIntent();
		//Intent hour = getIntent();
		
		today = intent.getStringExtra("Param1");
		time = intent.getStringExtra("Param2");
		
		rightNow = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm"); 
		time = dateFormat.format(rightNow.getTime()); //현재 시간 저장
		
		TextView text = (TextView) findViewById(R.id.texttoday);

		text.setText(today);

		mDBHelper = new MyDBHelper(this, "Today.db", null, 1);

		SQLiteDatabase db = mDBHelper.getWritableDatabase();

		cursor = db.rawQuery(

		"SELECT * FROM today WHERE date = '" + today + "'", null);
		
		adapter = new SimpleCursorAdapter(this,
		android.R.layout.simple_list_item_2, cursor, new String[] {
		"title", "time" }, new int[] { android.R.id.text1,
		android.R.id.text2 });
		
		ListView list = (ListView) findViewById(R.id.list1);

		list.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		
		
		
		
		
		
		
		list.setOnItemClickListener(this);

		mDBHelper.close();

		Button btn = (Button) findViewById(R.id.btnadd);
		btn.setOnClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,

	long id) {

		// TODO Auto-generated method stub

		Intent intent = new Intent(this, Detail.class);
		//Intent hour = new Intent(this, Detail.class);

		cursor.moveToPosition(position);

		intent.putExtra("ParamID", cursor.getInt(0));
		//hour.putExtra("ParamTime", cursor.getInt(1));

		startActivityForResult(intent, 0);
		//startActivityForResult(hour, 1);

	}

	@Override
	public void onClick(View v) {

		// TODO Auto-generated method stub

		Intent intent = new Intent(this, Detail.class);
		//Intent hour = new Intent(this, Detail.class);
		
		intent.putExtra("ParamDate", today);
		intent.putExtra("ParamTime", time);

		startActivityForResult(intent, 1);
		//startActivityForResult(hour, 2);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		// TODO Auto-generated method stub

		// super.onActivityResult(requestCode, resultCode, data);

		switch (requestCode) {

		case 0:

		case 1:

			if (resultCode == RESULT_OK) {

				// adapter.notifyDataSetChanged();

				SQLiteDatabase db = mDBHelper.getWritableDatabase();

				cursor = db.rawQuery("SELECT * FROM today WHERE date = '"

				+ today + "'", null);

				adapter.changeCursor(cursor);

				mDBHelper.close();
			}
			break;
		}
	}
}