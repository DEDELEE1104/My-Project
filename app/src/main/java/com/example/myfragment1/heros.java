package com.example.myfragment1;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myfragment1.Favorite.Favorite;
import com.example.myfragment1.Favorite.FavoriteAdapter;
import com.example.myfragment1.Favorite.FavoriteDAO;

import java.util.ArrayList;

public class heros extends Fragment {
    private ListView listView;
    //private ContactDAO_Heros dao;
   // private ArrayList<Contact_Heros> dataList;
    private ArrayList<Favorite> dataList2;
    private FavoriteDAO fdao;
    //private Button btn;
    private HerosViewModel mViewModel;

    public static heros newInstance() {
        return new heros();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.heros_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HerosViewModel.class);
        // TODO: Use the ViewModel
        initDB();
        initView();
        initHandle();


    }

    private void initView() {
        View view=getView();
       // btn=view.findViewById(R.id.btn);
        listView=view.findViewById(R.id.lise_news);
        dataList2=fdao.getAllConteacts();
        listView.setAdapter(new FavoriteAdapter(getActivity(),dataList2));
    }

    @Override
    public void onResume() {
        super.onResume();
        dataList2=fdao.getAllConteacts();
        listView.setAdapter(new FavoriteAdapter(getActivity(),dataList2));

    }

    private void initDB() {
        fdao=new FavoriteDAO(getActivity());
    }

    private void initHandle() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it=new Intent();
                it.setClass(getActivity(),heroa1.class);
                it.putExtra("position",position);
                startActivity(it);
            }
        });
       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(getActivity(),heros_favoite.class);
                startActivity(it);
            }
        });*/
    }

}
