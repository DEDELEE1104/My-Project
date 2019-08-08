package com.example.myfragment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myfragment1.ui.video.VideoFragment;

public class video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, VideoFragment.newInstance())
                    .commitNow();
        }
    }
}
