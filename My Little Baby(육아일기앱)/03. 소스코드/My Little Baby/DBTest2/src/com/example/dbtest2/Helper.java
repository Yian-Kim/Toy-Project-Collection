package com.example.dbtest2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import java.util.ArrayList;

public class Helper extends SQLiteOpenHelper {

    private static final  String CREATE_QUERY = "create table " + TabInfo.TAB_NAME +                    " ( " + TabInfo.KEY_ID + " integer primary key autoincrement, " +
            TabInfo.FNAME + " text not null, " + TabInfo.LNAME + " text not null , "             + TabInfo.DP + " blob );";

   Context ctx;
    public  Helper(Context context)
    {
        super(context,TabInfo.DB_NAME,null,2);
        ctx=context;
    }

    @Override    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TabInfo.TAB_NAME);
        onCreate(db);
    }
    public  void putInfo(Helper mob,String name,String pass,byte [] img)
    {
        SQLiteDatabase SQ= mob.getWritableDatabase();
        ContentValues CV=new ContentValues();
        CV.put(TabInfo.FNAME, name);
        CV.put(TabInfo.LNAME, pass);
        CV.put(TabInfo.DP, img);
        SQ.insert(TabInfo.TAB_NAME, null, CV);
        Toast.makeText(ctx,"1 Row Inserted",Toast.LENGTH_LONG).show();
    }
    public ArrayList<DisplayData> getAllRows(Helper mob)
    {
        ArrayList<DisplayData> data = new ArrayList<DisplayData>();
        SQLiteDatabase SQ = mob.getReadableDatabase();
        String col[] = {TabInfo.FNAME,TabInfo.LNAME,TabInfo.DP};
        Cursor cob = SQ.query(TabInfo.TAB_NAME,col,null,null,null,null,null);
        if(cob!=null)
        {
            cob.moveToFirst();
            do {
                DisplayData displayData = new DisplayData();
                displayData.setDis_fname(cob.getString(0));
                displayData.setDis_lname(cob.getString(1));
                displayData.setDis_img(cob.getBlob(2));
                data.add(displayData);
                }while(cob.moveToNext());
            }
        Toast.makeText(ctx,"Retrieved",Toast.LENGTH_LONG).show();

        return data;
    }
}
