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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfragment1.Favorite.Favorite;
import com.example.myfragment1.Favorite.FavoriteDAO;
import com.example.myfragment1.collect.Collect;
import com.example.myfragment1.collect.CollectDAO;

import java.util.ArrayList;

public class heros_favoite extends AppCompatActivity {
    private ListView list2;
    private ArrayList<Collect> dataList;
    private CollectDAO dao;
    private Collect collect;

    private FavoriteDAO dao_fav;
    private ArrayList<Favorite> dataList_fav;
    private Favorite favorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heros_favoite);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        initView();
        initHandel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataList=dao.getAllConteacts();
        list2.setAdapter(new CollectAdapter(this,dataList));
    }

    private void initHandel() {


    }

    private void initView() {
        dao=new CollectDAO(this);
        dao_fav=new FavoriteDAO(this);
        dataList=dao.getAllConteacts();
        dataList_fav=dao_fav.getAllConteacts();
        collect=new Collect();
        favorite=new Favorite();
        list2=findViewById(R.id.list2);
        list2.setAdapter(new CollectAdapter(this,dataList));

    }

    public class CollectAdapter extends MyBaseAdapter<Collect> {
        CollectDAO collectDAO=new CollectDAO(context);

        FavoriteDAO favoriteDAO=new FavoriteDAO(context);
        Favorite favorite;
        ArrayList<Favorite> data;


        public CollectAdapter(Context context, ArrayList<Collect> dataList) {
            super(context, dataList);
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            view=inflater.inflate(R.layout.heros2_layout,null);
            TextView text=view.findViewById(R.id.tv_hero2);
            TextView text2=view.findViewById(R.id.tv_race2);
            TextView text3=view.findViewById(R.id.tv_actor2);

            ImageView img=view.findViewById(R.id.iv_heros2);
            ImageView delet=view.findViewById(R.id.btn_delete);
            final Collect collect=dataList.get(i);
            text.setText(collect.getHeroname());
            text2.setText(collect.getHerorace());
            text3.setText(collect.getActor());
            byte[] ab=collect.getHeropic();
            if(ab!=null){
                Bitmap bitmap= BitmapFactory.decodeByteArray(ab,0,ab.length);
                img.setImageBitmap(bitmap);
            }
            delet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    collectDAO.delete(collect.getSid());
                    dataList=collectDAO.getAllConteacts();
                    list2.setAdapter(new CollectAdapter(context,dataList));
                    Toast.makeText(context,"刪除成功",Toast.LENGTH_LONG).show();
                    favorite=new Favorite();
                    favorite=favoriteDAO.getContactById(collect.getGetsid());
                    favorite.setCollect("false");
                    favoriteDAO.update(favorite);

                }
            });
            LinearLayout cell=view.findViewById(R.id.layout_hero);
            cell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rowSelected(collect,i);
                }
            });



            return view;
        }

        @Override
        protected void rowSelected(Collect song, int index) {
            Intent it=new Intent(context,heroa1.class);
            it.putExtra("position",song.getGetsid()-1);
            context.startActivity(it);


        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.realtabcontent,new heros(),null);
        finish();


        return super.onOptionsItemSelected(item);
    }



}
