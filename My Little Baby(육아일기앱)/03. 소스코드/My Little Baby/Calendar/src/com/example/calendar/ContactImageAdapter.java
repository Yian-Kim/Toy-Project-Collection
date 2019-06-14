package com.example.calendar;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactImageAdapter extends ArrayAdapter<Contact> {
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd",Locale.getDefault());
	String strDate = dateFormat.format(date);

	Context context;
	int layoutResourceId;
	// BcardImage data[] = null;
	ArrayList<Contact> data = new ArrayList<Contact>();

	public ContactImageAdapter(Context context, int layoutResourceId,
			ArrayList<Contact> data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		ImageHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);

			holder = new ImageHolder();
			holder.txtTitle = (TextView) row.findViewById(R.id.txtTitle);
			holder.txtTitle.setBackgroundColor(Color.parseColor("#ffe08c"));
			holder.imgIcon = (ImageView) row.findViewById(R.id.imgIcon);
			row.setTag(holder);
			
		} else {
			holder = (ImageHolder) row.getTag();
		}

		/*if(!(strDate.equals(holder.txtTitle))){
			holder.imgIcon.setVisibility(View.GONE);
			//holder.txtTitle.setVisibility(View.GONE);
			
		}else if(strDate.equals(holder.txtTitle)){
			holder.imgIcon.setVisibility(View.VISIBLE);
			//holder.txtTitle.setVisibility(View.VISIBLE);
		}*/
		
		
		Contact picture = data.get(position);
		holder.txtTitle.setText(picture._name);
		// convert byte to bitmap take from contact class
		
		byte[] outImage = picture._image;
		ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
		Bitmap theImage = BitmapFactory.decodeStream(imageStream);
		holder.imgIcon.setImageBitmap(theImage);
		//convertView.refreshDrawableState();
		return row;
		
	}

	static class ImageHolder {
		ImageView imgIcon;
		TextView txtTitle;
	}
}
