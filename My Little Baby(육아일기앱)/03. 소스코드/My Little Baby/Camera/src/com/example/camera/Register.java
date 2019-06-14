package com.example.camera;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.app.AliasActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class Register extends AliasActivity {
    byte img[];
    EditText ed1,ed2;
    ImageView imageView;
    String str1,str2,str3=null;
    Bitmap bitmap=null;
    
    @Override    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regact);
        ed1= (EditText) findViewById(R.id.et1);
        ed2= (EditText) findViewById(R.id.et2);
       imageView= (ImageView) findViewById(R.id.iv1);

    }

    public void selectimg(View v){
        Intent iob = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(iob, 0);
}

    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode== Activity.RESULT_OK && data!=null){
           Uri selectedImage = data.getData();
    try        
     {
      bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedImage);
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      bitmap.compress(Bitmap.CompressFormat.PNG,100,bos);
      img = bos.toByteArray();
      imageView.setImageBitmap(bitmap);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
   }
 }
    public void save(View v){
        str1=ed1.getText().toString();
        str2=ed2.getText().toString();
        MyHelper myhlp = new MyHelper(this);
        myhlp.putInfo(myhlp,str1,str2,img);
        Toast.makeText(this,"Record Saved",Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Record Saved", Toast.LENGTH_SHORT).show();
       
    }
}
