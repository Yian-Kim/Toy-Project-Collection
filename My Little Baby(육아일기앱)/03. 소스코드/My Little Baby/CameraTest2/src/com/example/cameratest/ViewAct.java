package com.example.cameratest;

import java.util.ArrayList;

import android.app.AliasActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

public class ViewAct extends AliasActivity {
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
