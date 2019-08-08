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

import com.example.myfragment1.Favorite_Movie.FavoriteAdapter_movie;
import com.example.myfragment1.Favorite_Movie.FavoriteDAO_Movie;
import com.example.myfragment1.Favorite_Movie.Favorite_movies;

import java.util.ArrayList;

public class movie extends Fragment {
    private ListView list_movies;
   // private ContactDAO_avenger dao;
   // private ArrayList<Contact_avenger> dataList;
    private ArrayList<Favorite_movies> favList;
    private FavoriteDAO_Movie fdao_movie;
    private MovieViewModel mViewModel;
   // private Button btn;

    public static movie newInstance() {
        return new movie();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.movie_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        // TODO: Use the ViewModel
        initDB();
        initView();
        initHandle();

    }

    private void initHandle() {
        list_movies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it=new Intent();
                it.setClass(getActivity(),moviea1.class);
                it.putExtra("position",position);
                startActivity(it);
            }
        });
       /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(getActivity(),movie_favorite.class);
                startActivity(it);
            }
        });*/
    }

    private void initView() {
        View view =getView();
        //btn=view.findViewById(R.id.btn);
        list_movies=view.findViewById(R.id.list_movies);
       favList=fdao_movie.getAllConteacts();
        list_movies.setAdapter(new FavoriteAdapter_movie(getActivity(),favList));

    }

    private void initDB() {
        fdao_movie=new FavoriteDAO_Movie(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        favList=fdao_movie.getAllConteacts();
        list_movies.setAdapter(new FavoriteAdapter_movie(getActivity(),favList));
    }
}
