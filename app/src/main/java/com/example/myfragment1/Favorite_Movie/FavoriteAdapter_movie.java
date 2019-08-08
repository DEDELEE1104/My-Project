package com.example.myfragment1.Favorite_Movie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfragment1.Collect_movies.CollectDAO_movies;
import com.example.myfragment1.Collect_movies.Collect_movie;
import com.example.myfragment1.MyBaseAdapter;
import com.example.myfragment1.R;

import java.util.ArrayList;

public class FavoriteAdapter_movie extends MyBaseAdapter<Favorite_movies> {
    private FavoriteDAO_Movie dao=new FavoriteDAO_Movie(context);
    private CollectDAO_movies dao_collect = new CollectDAO_movies(context);
    private Collect_movie collect;
    private ArrayList<Collect_movie> collect_movies;
    public FavoriteAdapter_movie(Context context, ArrayList<Favorite_movies> dataList) {
        super(context, dataList);
    }

    @Override
    protected void rowSelected(Favorite_movies song, int index) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.introducionmovie,null);
        ImageView img=convertView.findViewById(R.id.img_movie);
        TextView textView = convertView.findViewById(R.id.movie_name);
        TextView textView1=convertView.findViewById(R.id.engtitle);
        TextView textView2=convertView.findViewById(R.id.text_length);
        final ImageView img1=convertView.findViewById(R.id.img_collectmovie);
        final Favorite_movies favorite=dataList.get(position);
        textView.setText(favorite.getMoviename());
        textView1.setText(favorite.getEnglishname());
        textView2.setText(favorite.getMovielength());
        byte[] ab=favorite.getMoviepic();
        if(ab!=null){
            Bitmap bitmap= BitmapFactory.decodeByteArray(ab,0,ab.length);
            img.setImageBitmap(bitmap);
        }
        if (favorite.getCollect().equals("false")){
            img1.setImageResource(R.mipmap.notcollect);
        }else{
            img1.setImageResource(R.mipmap.iscollect);
        }
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(favorite.getCollect().equals("false")){
                    img1.setImageResource(R.mipmap.iscollect);
                    favorite.setCollect("true");
                    dao.update(favorite);
                    collect= new Collect_movie();
                  collect.setMoviename(favorite.getMoviename());
                  collect.setEnglishname(favorite.getEnglishname());
                  collect.setMovielength(favorite.getMovielength());
                  collect.setMoviepic(favorite.getMoviepic());
                  collect.setGetSid(favorite.getSid());
                  dao_collect.insert(collect);
                    Toast.makeText(context,"收藏成功",Toast.LENGTH_LONG).show();
                }else {
                    img1.setImageResource(R.mipmap.notcollect);
                    favorite.setCollect("false");
                    dao.update(favorite);
                    collect_movies=dao_collect.getAllConteacts();
                    for (int i=0;i<collect_movies.size();i++){
                        if(favorite.getMoviename().equals(collect_movies.get(i).getMoviename())){
                            collect=dao_collect.getContactById(collect_movies.get(i).getSid());
                            dao_collect.delete(collect.getSid());
                        }

                    }
                    Toast.makeText(context,"取消收藏",Toast.LENGTH_LONG).show();
                }
            }
        });

        return convertView;
    }
}
