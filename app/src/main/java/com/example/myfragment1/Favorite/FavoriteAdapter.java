package com.example.myfragment1.Favorite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfragment1.MyBaseAdapter;
import com.example.myfragment1.R;
import com.example.myfragment1.collect.Collect;
import com.example.myfragment1.collect.CollectDAO;

import java.util.ArrayList;

public class FavoriteAdapter extends MyBaseAdapter<Favorite> {
    private FavoriteDAO dao=new FavoriteDAO(context);
    private CollectDAO dao_collect=new CollectDAO(context);
    private Collect collect;
    private ArrayList<Collect> collects;
    public FavoriteAdapter(Context context, ArrayList<Favorite> dataList) {
        super(context, dataList);
    }

    @Override
    protected void rowSelected(Favorite song, int index) {

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.heros_layout,null);
        TextView text=view.findViewById(R.id.tv_hero);
        TextView text2=view.findViewById(R.id.tv_race);
        TextView text3=view.findViewById(R.id.tv_actor);
        ImageView img=view.findViewById(R.id.iv_heros);
        final ImageView img1=view.findViewById(R.id.img_collect);
        final Favorite favorite=dataList.get(i);
        text.setText(favorite.getHeroname());
        text2.setText(favorite.getHerorace());
        text3.setText(favorite.getActor());
        byte[] ab=favorite.getHeropic();
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
            public void onClick(View view) {
                if (favorite.getCollect().equals("false")){
                    img1.setImageResource(R.mipmap.iscollect);
                    favorite.setCollect("true");
                    dao.update(favorite);
                    collect=new Collect();
                    collect.setHeroname(favorite.getHeroname());
                    collect.setHerorace(favorite.getHerorace());
                    collect.setActor(favorite.getActor());
                    collect.setHeropic(favorite.getHeropic());
                    collect.setGetsid(favorite.getSid());
                    dao_collect.insert(collect);
                    Toast.makeText(context,"收藏成功", Toast.LENGTH_LONG).show();
                }else{
                    img1.setImageResource(R.mipmap.notcollect);
                    favorite.setCollect("false");
                    dao.update(favorite);
                    collects=dao_collect.getAllConteacts();
                    for(int i=0;i<collects.size();i++){
                        if(favorite.getHeroname().equals(collects.get(i).getHeroname())){
                            collect=dao_collect.getContactById(collects.get(i).getSid());
                            dao_collect.delete(collect.getSid());
                        }
                    }

                    Toast.makeText(context,"取消收藏", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}