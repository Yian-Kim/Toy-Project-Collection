package com.example.dbtest2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ViewAct extends AppCompatActivity {
    Context context = this;
    ArrayList<DisplayData> showData;
    ImageAdapter adapter;
    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        showListView();
    }

    private void showListView() {
        Helper myHelper = new Helper(context);
        showData= myHelper.getAllRows(myHelper);
        adapter= new ImageAdapter(context,R.layout.single_row,showData);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
       }
}
