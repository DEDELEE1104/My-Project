package com.example.myfragment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class news extends AppCompatActivity {
private WebView web_news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
web_news=findViewById(R.id.web_news);
        Intent it =getIntent();
        Bundle bundle=it.getExtras();
        String url=bundle.getString("URL");
        web_news.loadUrl(url);
    }
}
