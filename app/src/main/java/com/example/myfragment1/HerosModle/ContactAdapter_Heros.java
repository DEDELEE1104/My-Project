package com.example.myfragment1.HerosModle;

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

public class ContactAdapter_Heros extends MyBaseAdapter<Contact_Heros> {


    public ContactAdapter_Heros(Context context, ArrayList<Contact_Heros> dataList) {

        super(context,dataList);
    }

    @Override
    protected void rowSelected(Contact_Heros song, int index) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=inflater.inflate(R.layout.heros_layout,null);
        }
        TextView text=convertView.findViewById(R.id.tv_hero);
        TextView text1=convertView.findViewById(R.id.tv_race);
        TextView text2=convertView.findViewById(R.id.tv_actor);
        ImageView img=convertView.findViewById(R.id.iv_heros);

        final Contact_Heros c=dataList.get(position);

        byte[] ab=c.getHeropic();
        if(ab!=null){
            Bitmap bm= BitmapFactory.decodeByteArray(ab,0,ab.length);
            img.setImageBitmap(bm);
        }

        text.setText(c.getHeroname());
        text1.setText(c.getHerorace());
        text2.setText(c.getActor());


        return convertView;
    }
}
