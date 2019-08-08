package com.example.myfragment1.avengerModle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myfragment1.MyBaseAdapter;
import com.example.myfragment1.R;

import java.util.ArrayList;

public class ContactAdapter_avenger extends MyBaseAdapter<Contact_avenger> {

    public ContactAdapter_avenger(Context context, ArrayList<Contact_avenger> dataList) {
        super(context, dataList);
    }

    @Override
    protected void rowSelected(Contact_avenger song, int index) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=inflater.inflate(R.layout.introducionmovie,null);
        }
        TextView text=convertView.findViewById(R.id.movie_name);
        TextView text1=convertView.findViewById(R.id.engtitle);
        TextView text2=convertView.findViewById(R.id.text_length);
        ImageView img=convertView.findViewById(R.id.img_movie);

        final Contact_avenger c=dataList.get(position);

        byte[] ab=c.getMoivepic();
        if(ab!=null){
            Bitmap bm= BitmapFactory.decodeByteArray(ab,0,ab.length);
            img.setImageBitmap(bm);
        }

        text.setText(c.getMoviename());
        text1.setText(c.getEnglishname());
        text2.setText(c.getMovielength());


        return convertView;
    }
}
