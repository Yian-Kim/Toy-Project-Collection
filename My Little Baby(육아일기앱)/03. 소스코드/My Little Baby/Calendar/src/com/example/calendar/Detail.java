package com.example.calendar;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Detail extends Activity implements OnClickListener { // 일정목록 추가하기
	Button addImage;
	ArrayList<Contact> imageArry = new ArrayList<Contact>();
	ContactImageAdapter imageAdapter;
	private static final int CAMERA_REQUEST = 1;
	private static final int PICK_FROM_GALLERY = 2;
	ListView dataList;
	byte[] imageName;
	int imageId;
	Bitmap theImage;
	DataBaseHandler db;
	MyDBHelper mDBHelper;
	
	int mId;
	String time;
	String today , test, date;
	private Calendar rightNow;
	
	EditText  editTitle, editDate, editTime, editMemo;
//editDate,editTime,
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.detail);
		
		editTitle = (EditText) findViewById(R.id.edittitle);
		editDate = (EditText) findViewById(R.id.editdate);
		editTime = (EditText) findViewById(R.id.edittime);
		editMemo = (EditText) findViewById(R.id.editmemo);

		Intent intent = getIntent();
		//Intent hour = getIntent();

		mId = intent.getIntExtra("ParamID", -1);
		
		today = intent.getStringExtra("ParamDate");
		time = intent.getStringExtra("ParamTime");
		
		mDBHelper = new MyDBHelper(this, "Today.db", null, 1);
		if (mId == -1) {
			editDate.setText(today);
			editTime.setText(time);

		} else {

			SQLiteDatabase db = mDBHelper.getWritableDatabase();

			Cursor cursor = db.rawQuery("SELECT * FROM today WHERE _id='" + mId

			+ "'", null);
			if (cursor.moveToNext()) {
				editTitle.setText(cursor.getString(1));
				editDate.setText(cursor.getString(2));
				editTime.setText(cursor.getString(3));
				editMemo.setText(cursor.getString(4));
				//date = cursor.getString(2);
				
			}
			
			mDBHelper.close();
		}
		
		
		
		
		Button btn1 = (Button) findViewById(R.id.btnsave);
		btn1.setOnClickListener(this);

		Button btn2 = (Button) findViewById(R.id.btndel);
		btn2.setOnClickListener(this);

		Button btn3 = (Button) findViewById(R.id.btncancel);
		btn3.setOnClickListener(this);
		
		Button btn4 = (Button) findViewById(R.id.btnAdd);
		btn4.setOnClickListener(this);
		
		Button btn5 = (Button) findViewById(R.id.btn5);
		btn4.setOnClickListener(this);

		if (mId == -1) {
			btn2.setVisibility(View.GONE);
		}
		
		dataList = (ListView) findViewById(R.id.list);
		/**
		 * create DatabaseHandler object
		 */
		db = new DataBaseHandler(this);
		/**
		 * Reading and getting all records from database
		 */
		List<Contact> contacts = db.getAllContacts();
		for (Contact cn : contacts) {
			String log = "ID:" + cn.getID() + " Name: " + cn.getName()
					+ " ,Image: " + cn.getImage();

			// Writing Contacts to log
			Log.d("Result: ", log);
			// add contacts data in arrayList
			imageArry.add(cn);
		}
		/**
		 * Set Data base Item into listview
		 */
		
		imageAdapter = new ContactImageAdapter(this, R.layout.screen_list,
				imageArry);
		
		dataList.setAdapter(imageAdapter);
		/**
		 * go to next activity for detail image
		 */
		
		imageAdapter.notifyDataSetChanged();
		/*if(imageAdapter.isEmpty()==false){
			
		}
		else{
			imageAdapter.notifyDataSetInvalidated();
		}*/
	
	dataList.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View v,
				final int position, long id) {
			imageName = imageArry.get(position).getImage();
			imageId = imageArry.get(position).getID();
			
			Log.d("Before Send:****", imageName + "-" + imageId);
			// convert byte to bitmap
			ByteArrayInputStream imageStream = new ByteArrayInputStream(
					imageName);
			theImage = BitmapFactory.decodeStream(imageStream);
			Intent intent = new Intent(Detail.this,
					DisplayImageActivity.class);
			intent.putExtra("imagename", theImage);
			intent.putExtra("imageid", imageId);
			startActivity(intent);

		}
	});
	/**
	 * open dialog for choose camera/gallery
	 */

	final String[] option = new String[] { "Take from Camera",
			"Select from Gallery" };
	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
			android.R.layout.select_dialog_item, option);
	AlertDialog.Builder builder = new AlertDialog.Builder(this);

	builder.setTitle("Select Option");
	builder.setAdapter(adapter, new DialogInterface.OnClickListener() {

		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			Log.e("Selected Item", String.valueOf(which));
			if (which == 0) {
				callCamera();
			}
			if (which == 1) {
				callGallery();
			}

		}
	});
	final AlertDialog dialog = builder.create();

	addImage = (Button) findViewById(R.id.btnAdd);

	addImage.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			
			dialog.show();
		}
	});

}

/**
 * On activity result
 */
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	if (resultCode != RESULT_OK)
		return;
	
	/*if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
		Uri selectedImage = data.getData();
		Bitmap photo = (Bitmap) data.getExtras().get("data");
	}*/
		/*
		/**
		* Get Path
		
		Uri selectedImage = data.getData();
		String[] filePathColumn = { MediaStore.Images.Media.DATA };

		Cursor cursor = getContentResolver().query(selectedImage,
		filePathColumn, null, null, null);
		cursor.moveToFirst();

		int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
		String picturePath1 = cursor.getString(columnIndex);
		Log.e("Image View Path1", picturePath1);
		}
		//cursor.close();*/
		
	switch (requestCode) {
	case CAMERA_REQUEST:

		Bundle extras = data.getExtras();

		if (extras != null) {
			Bitmap yourImage = extras.getParcelable("data");
			// convert bitmap to byte
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			yourImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
			byte imageInByte[] = stream.toByteArray();
			Log.e("output before conversion", imageInByte.toString());
			// Inserting Contacts
			Log.d("Insert: ", "Inserting ..");
			db.addContact(new Contact("", imageInByte));
			Intent i = new Intent(Detail.this,
					Detail.class);
			startActivity(i);
			finish();

		}
		break;
	case PICK_FROM_GALLERY:
		Bundle extras2 = data.getExtras();

		if (extras2 != null) {
			Bitmap yourImage = extras2.getParcelable("data");
			// convert bitmap to byte
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			yourImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
			byte imageInByte[] = stream.toByteArray();
			Log.e("output before conversion", imageInByte.toString());
			// Inserting Contacts
			Log.d("Insert: ", "Inserting ..");
			//String test = today;
			
			db.addContact(new Contact(today, imageInByte));
			
			Intent i = new Intent(Detail.this,Detail.class);
			startActivity(i);
			finish();
			
			
		}

		break;
	}
}

/**
 * open camera method
 */
public void callCamera() {
	Intent cameraIntent = new Intent(
			android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	cameraIntent.putExtra("crop", "true");
	/*cameraIntent.putExtra("aspectX", 0);
	cameraIntent.putExtra("aspectY", 0);
	cameraIntent.putExtra("outputX", 200);
	cameraIntent.putExtra("outputY", 150);*/
	startActivityForResult(cameraIntent, CAMERA_REQUEST);

}

/**
 * open gallery method
 */

public void callGallery() {
	Intent intent = new Intent();
	intent.setType("image/*");
	intent.setAction(Intent.ACTION_GET_CONTENT);
	intent.putExtra("crop", "true");
	/*intent.putExtra("aspectX", 0);
	intent.putExtra("aspectY", 0);
	intent.putExtra("outputX", 200);
	intent.putExtra("outputY", 150);*/
	intent.putExtra("return-data", true);
	startActivityForResult(Intent.createChooser(intent, "Complete action using"),PICK_FROM_GALLERY);
}
	
	
	@Override
	public void onClick(View v) {

		// TODO Auto-generated method stub

		SQLiteDatabase db = mDBHelper.getWritableDatabase();

		switch (v.getId()) {

		case R.id.btnsave:

			if (mId != -1) {

				db.execSQL("UPDATE today SET title='"
				+ editTitle.getText().toString() + "',date='"
				+ editDate.getText().toString() + "', time='"
				+ editTime.getText().toString() + "', memo='"
				+ editMemo.getText().toString() + "' WHERE _id='" + mId
				+ "';");

			} else {
				db.execSQL("INSERT INTO today VALUES(null, '"
				+ editTitle.getText().toString() + "', '"
				+ editDate.getText().toString() + "', '"
				+ editTime.getText().toString() + "', '"
				+ editMemo.getText().toString() + "');");

			}

			mDBHelper.close();

			setResult(RESULT_OK);

			break;

		case R.id.btndel:

			if (mId != -1) {

				db.execSQL("DELETE FROM today WHERE _id='" + mId + "';");

				mDBHelper.close();

			}

			setResult(RESULT_OK);

			break;

		case R.id.btncancel:

			setResult(RESULT_CANCELED);
			
			break;
		case R.id.btn5:
			imageAdapter.notifyDataSetChanged();
			break;
		}
		finish();
	}
}
