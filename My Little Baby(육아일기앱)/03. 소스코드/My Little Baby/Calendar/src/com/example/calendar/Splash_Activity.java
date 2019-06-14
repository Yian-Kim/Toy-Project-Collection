package com.example.calendar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class Splash_Activity extends Activity{

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setTitle("¿∞æ∆¿œ±‚~¢æ");
        
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                finish();
            }
        };
        
        handler.sendEmptyMessageDelayed(0, 3000);
        
    } //end onCreate Method
    
}
