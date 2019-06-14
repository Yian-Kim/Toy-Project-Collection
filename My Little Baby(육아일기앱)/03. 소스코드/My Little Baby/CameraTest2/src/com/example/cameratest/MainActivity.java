package com.example.cameratest;

import android.Manifest;
import android.app.AliasActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AliasActivity {
    final int REQUEST_CODE=123;
    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int hasPermission=
                ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(hasPermission!= PackageManager.PERMISSION_GRANTED)
        {
         if( !ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE))
            {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE);
                return;
            }
        }
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                REQUEST_CODE);
    }
    public void register(View view)
    {
        startActivity(new Intent(this, RegAct.class));
    }
    public void viewAll(View view)
    {
        startActivity(new Intent(this,ViewAct.class));
    }

}
