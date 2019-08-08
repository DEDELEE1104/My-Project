package com.example.myfragment1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.myfragment1.ui.mainpage.MainPageFragment;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainPageFragment.newInstance())
                    .commitNow();


        }
    }





}
