package com.example.myfragment1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfragment1.Collect_movies.CollectDAO_movies;
import com.example.myfragment1.Collect_movies.Collect_movie;
import com.example.myfragment1.Favorite_Movie.FavoriteDAO_Movie;
import com.example.myfragment1.Favorite_Movie.Favorite_movies;

import java.util.ArrayList;

public class movie_favorite extends AppCompatActivity {
private ListView listView3;
private ArrayList<Collect_movie> collect_list;
private CollectDAO_movies dao_collect;
private Collect_movie collect_movie;

private FavoriteDAO_Movie dao_fav;
    private ArrayList<Favorite_movies> datalist_fav;
    private Favorite_movies favorite_movies;

    @Override
    protected void onResume() {
        super.onResume();
       collect_list=dao_collect.getAllConteacts();
       listView3.setAdapter(new CollectAdapter_movie(movie_favorite.this,collect_list));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_favorite);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        initView();
        initHandel();
    }

    private void initHandel() {
        listView3.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                collect_movie=collect_list.get(position);
                dao_collect.delete(collect_movie.getSid());
                collect_list=dao_collect.getAllConteacts();
                listView3.setAdapter(new CollectAdapter_movie(movie_favorite.this,collect_list));
                favorite_movies=dao_fav.getContactById(collect_movie.getSid());
                favorite_movies.setCollect("false");
                dao_fav.update(favorite_movies);
                Toast.makeText(movie_favorite.this,"刪除成功",Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    private void initView() {
        dao_collect=new CollectDAO_movies(this);
        dao_fav=new FavoriteDAO_Movie(this);
        collect_list=dao_collect.getAllConteacts();
        datalist_fav=dao_fav.getAllConteacts();
        collect_movie=new Collect_movie();
        favorite_movies=new Favorite_movies();
        listView3=findViewById(R.id.list3);
        listView3.setAdapter(new CollectAdapter_movie(this,collect_list));
    }




    public class CollectAdapter_movie extends MyBaseAdapter<Collect_movie> {
            CollectDAO_movies collectDAO_movies=new CollectDAO_movies(context);
            FavoriteDAO_Movie favoriteDAO_movie=new FavoriteDAO_Movie(context);
            Favorite_movies favorite_movies;


        public CollectAdapter_movie(Context context, ArrayList<Collect_movie> dataList) {
            super(context, dataList);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView=inflater.inflate(R.layout.movies2,null);
            ImageView img=convertView.findViewById(R.id.img_movie2);
            TextView textView = convertView.findViewById(R.id.movie_name2);
            TextView textView1=convertView.findViewById(R.id.engtitle2);
            TextView textView2=convertView.findViewById(R.id.text_length2);
            ImageView delet2=convertView.findViewById(R.id.btn_delete2);
            final Collect_movie collect=dataList.get(position);
            textView.setText(collect.getMoviename());
            textView1.setText(collect.getEnglishname());

            textView2.setText(collect.getMovielength());
            byte[] ab=collect.getMoviepic();
            if(ab != null){
                Bitmap bitmap= BitmapFactory.decodeByteArray(ab,0,ab.length);

                img.setImageBitmap(bitmap);
            }
            delet2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    collectDAO_movies.delete(collect.getSid());
                    dataList=dao_collect.getAllConteacts();
                    listView3.setAdapter(new CollectAdapter_movie(context,dataList));
                    favorite_movies=new Favorite_movies();
                    favorite_movies=favoriteDAO_movie.getContactById(collect.getGetSid());
                    favorite_movies.setCollect("false");
                    favoriteDAO_movie.update(favorite_movies);
                    Toast.makeText(context,"刪除成功",Toast.LENGTH_LONG).show();
                }
            });
            LinearLayout cell=convertView.findViewById(R.id.layout_movie);
            cell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rowSelected(collect,position);
                }
            });

            return convertView;
        }

        @Override
        protected void rowSelected(Collect_movie song, int index) {
            Intent it=new Intent(context,moviea1.class);
            it.putExtra("position",song.getGetSid()-1);
            context.startActivity(it);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.realtabcontent,new movie(),null);
        finish();
        return super.onOptionsItemSelected(item);
    }
}
