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

public class videoa2 extends AppCompatActivity {
    private WebView webreview1,webreview2,webreview3,webreview4;
    private WebView Easteregg1,Easteregg2,Easteregg3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoa2);
        initView();
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.realtabcontent,new movie(),null);
        finish();
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        //影評
        webreview1=findViewById(R.id.review1);
        webreview2=findViewById(R.id.review2);
        webreview3=findViewById(R.id.review3);
        webreview4=findViewById(R.id.review4);

        WebSettings webSettings1=webreview1.getSettings();
        webSettings1.setJavaScriptEnabled(true);
        webSettings1.setBuiltInZoomControls(true);
        webSettings1.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings1.setAppCacheEnabled(true);
        webreview1.setWebViewClient(new WebViewClient());
        String html1="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/T4OL93Rxi0k\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        webreview1.loadData(html1,"text/html","utf-8");

        WebSettings webSettings2=webreview2.getSettings();
        webSettings2.setJavaScriptEnabled(true);
        webSettings2.setBuiltInZoomControls(true);
        webSettings2.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings2.setAppCacheEnabled(true);
        webreview2.setWebViewClient(new WebViewClient());
        String html2="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/_rtpqgrw2CI\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        webreview2.loadData(html2,"text/html","utf-8");

        WebSettings webSettings3=webreview3.getSettings();
        webSettings3.setJavaScriptEnabled(true);
        webSettings3.setBuiltInZoomControls(true);
        webSettings3.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings3.setAppCacheEnabled(true);
        webreview3.setWebViewClient(new WebViewClient());
        String html3="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/pRBP4ID1lAY\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        webreview3.loadData(html3,"text/html","utf-8");

        WebSettings webSettings4=webreview4.getSettings();
        webSettings4.setJavaScriptEnabled(true);
        webSettings4.setBuiltInZoomControls(true);
        webSettings4.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings4.setAppCacheEnabled(true);
        webreview4.setWebViewClient(new WebViewClient());
        String html4="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/DHyMiD-rP7w\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        webreview4.loadData(html4,"text/html","utf-8");

        //彩蛋
        Easteregg1=findViewById(R.id.easteregg1);
        Easteregg2=findViewById(R.id.easteregg2);
        Easteregg3=findViewById(R.id.easteregg3);

        WebSettings webSettings5=Easteregg1.getSettings();
        webSettings5.setJavaScriptEnabled(true);
        webSettings5.setBuiltInZoomControls(true);
        webSettings5.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings5.setAppCacheEnabled(true);
        Easteregg1.setWebViewClient(new WebViewClient());
        String html5="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/DE7VSo_QZ1Y\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        Easteregg1.loadData(html5,"text/html","utf-8");

        WebSettings webSettings6=Easteregg2.getSettings();
        webSettings6.setJavaScriptEnabled(true);
        webSettings6.setBuiltInZoomControls(true);
        webSettings6.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings6.setAppCacheEnabled(true);
        Easteregg2.setWebViewClient(new WebViewClient());
        String html6="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/EFBOiPxT1Gs\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        Easteregg2.loadData(html6,"text/html","utf-8");

        WebSettings webSettings7=Easteregg3.getSettings();
        webSettings7.setJavaScriptEnabled(true);
        webSettings7.setBuiltInZoomControls(true);
        webSettings7.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings7.setAppCacheEnabled(true);
        Easteregg3.setWebViewClient(new WebViewClient());
        String html7="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/D_a7PjuTCAE\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        Easteregg3.loadData(html7,"text/html","utf-8");

    }
}
