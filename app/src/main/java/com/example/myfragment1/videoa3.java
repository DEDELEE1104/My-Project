package com.example.myfragment1;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class videoa3 extends AppCompatActivity {
    private WebView music1,music2,music3,music4,music5,music6,music7;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.realtabcontent,new movie(),null);
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoa3);
        initview();
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initview() {
        music1=findViewById(R.id.web_music1);
        music2=findViewById(R.id.web_music2);
        music3=findViewById(R.id.web_music3);
        music4=findViewById(R.id.web_music4);
        music5=findViewById(R.id.web_music5);
        music6=findViewById(R.id.web_music6);
        music7=findViewById(R.id.web_music7);
//復仇者系列
        WebSettings webSettings1=music1.getSettings();
        webSettings1.setJavaScriptEnabled(true);
        webSettings1.setBuiltInZoomControls(true);
        webSettings1.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings1.setAppCacheEnabled(true);
        music1.setWebViewClient(new WebViewClient());
        String html1="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/N8DyyKUJWSA\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        music1.loadData(html1,"text/html","utf-8");

        WebSettings webSettings2=music2.getSettings();
        webSettings2.setJavaScriptEnabled(true);
        webSettings2.setBuiltInZoomControls(true);
        webSettings2.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings2.setAppCacheEnabled(true);
        music2.setWebViewClient(new WebViewClient());
        String html2="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/7d_dzNw8Ceo\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        music2.loadData(html2,"text/html","utf-8");


        WebSettings webSettings3=music3.getSettings();
        webSettings3.setJavaScriptEnabled(true);
        webSettings3.setBuiltInZoomControls(true);
        webSettings3.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings3.setAppCacheEnabled(true);
        music3.setWebViewClient(new WebViewClient());
        String html3="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/KIhX1OAI5XM\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        music3.loadData(html3,"text/html","utf-8");

        WebSettings webSettings4=music4.getSettings();
        webSettings4.setJavaScriptEnabled(true);
        webSettings4.setBuiltInZoomControls(true);
        webSettings4.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings4.setAppCacheEnabled(true);
        music4.setWebViewClient(new WebViewClient());
        String html4="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/cIzTOsD5iWE\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        music4.loadData(html4,"text/html","utf-8");

        //鋼鐵人系列
        WebSettings webSettings5=music5.getSettings();
        webSettings5.setJavaScriptEnabled(true);
        webSettings5.setBuiltInZoomControls(true);
        webSettings5.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings5.setAppCacheEnabled(true);
        music5.setWebViewClient(new WebViewClient());
        String html5="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/YlsQ6hjSZ8A\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        music5.loadData(html5,"text/html","utf-8");

        WebSettings webSettings6=music6.getSettings();
        webSettings6.setJavaScriptEnabled(true);
        webSettings6.setBuiltInZoomControls(true);
        webSettings6.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings6.setAppCacheEnabled(true);
        music6.setWebViewClient(new WebViewClient());
        String html6="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/L26CcuGBtjM\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        music6.loadData(html6,"text/html","utf-8");

        WebSettings webSettings7=music7.getSettings();
        webSettings7.setJavaScriptEnabled(true);
        webSettings7.setBuiltInZoomControls(true);
        webSettings7.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings7.setAppCacheEnabled(true);
        music7.setWebViewClient(new WebViewClient());
        String html7="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/07cvKD59bK0\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        music7.loadData(html7,"text/html","utf-8");
    }
}
