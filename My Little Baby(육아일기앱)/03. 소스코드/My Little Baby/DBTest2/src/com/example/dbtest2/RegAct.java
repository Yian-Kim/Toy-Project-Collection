package com.example.dbtest2;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class RegAct extends AppCompatActivity {
    EditText f_name,l_name;
    String fname,lname;
    byte myimg[];
    ImageView imageView;
    Bitmap bitmap = null;
    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        f_name = (EditText) findViewById(R.id.et_fname);
        l_name = (EditText) findViewById(R.id.et_lname);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void selectImage(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK,                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode== Activity.RESULT_OK && data !=null) {

            Uri selectedImage = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),                                                     selectedImage);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
                myimg = bos.toByteArray();
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void submit(View view)
    {
        fname = f_name.getText().toString();
        lname = l_name.getText().toString();
        Helper hob = new Helper(this);
        hob.putInfo(hob,fname,lname,myimg);
        finish();
    }
}
