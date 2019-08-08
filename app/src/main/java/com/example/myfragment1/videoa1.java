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

import com.example.myfragment1.ui.video.VideoFragment;

public class videoa1 extends AppCompatActivity {
    private WebView web1,web2,web3,web4,web5,web6,web7,web8,web9,web10,web11,web12,web13,web14,web15;
    private WebView web16,web17,web18,web19,web20,web21,web22,web23;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoa1);
        initView();
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.realtabcontent,new VideoFragment(),null);
        finish();
        return super.onOptionsItemSelected(item);
    }

    private void initView() {

        //鋼鐵人系列
        web1=findViewById(R.id.web_ironman1);
        web2=findViewById(R.id.web_ironman2);
        web3=findViewById(R.id.web_ironman3);
        //ironman1
        WebSettings webSettings1=web1.getSettings();
        webSettings1.setJavaScriptEnabled(true);
        webSettings1.setBuiltInZoomControls(true);
        webSettings1.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings1.setAppCacheEnabled(true);
        web1.setWebViewClient(new WebViewClient());
        String html1="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/F-LOP37YkAw\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web1.loadData(html1,"text/html","utf-8");
        //ironman2
        WebSettings webSettings2=web2.getSettings();
        webSettings2.setJavaScriptEnabled(true);
        webSettings2.setBuiltInZoomControls(true);
        webSettings2.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings2.setAppCacheEnabled(true);
        web2.setWebViewClient(new WebViewClient());
        String html2="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/9Th_8DAYQqI\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web2.loadData(html2,"text/html","utf-8");
        //ironman3
        WebSettings webSettings3=web3.getSettings();
        webSettings3.setJavaScriptEnabled(true);
        webSettings3.setBuiltInZoomControls(true);
        webSettings3.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings3.setAppCacheEnabled(true);
        web3.setWebViewClient(new WebViewClient());
        String html3="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/LSMSmBBHnp0\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web3.loadData(html3,"text/html","utf-8");

        //美國隊長系列
        web4=findViewById(R.id.web_ca1);
        web5=findViewById(R.id.web_ca2);
        web6=findViewById(R.id.web_ca3);
        //CaptainAmrica1
        WebSettings webSettings4=web4.getSettings();
        webSettings4.setJavaScriptEnabled(true);
        webSettings4.setBuiltInZoomControls(true);
        webSettings4.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings4.setAppCacheEnabled(true);
        web4.setWebViewClient(new WebViewClient());
        String html4="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/swvzxZjbbfY\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web4.loadData(html4,"text/html","utf-8");
        //CaptainAmrica2
        WebSettings webSettings5=web5.getSettings();
        webSettings5.setJavaScriptEnabled(true);
        webSettings5.setBuiltInZoomControls(true);
        webSettings5.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings5.setAppCacheEnabled(true);
        web5.setWebViewClient(new WebViewClient());
        String html5="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/IP9j0aXkX6E\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web5.loadData(html5,"text/html","utf-8");
        //CaptainAmrica3
        WebSettings webSettings6=web6.getSettings();
        webSettings6.setJavaScriptEnabled(true);
        webSettings6.setBuiltInZoomControls(true);
        webSettings6.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings6.setAppCacheEnabled(true);
        web6.setWebViewClient(new WebViewClient());
        String html6="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/BkYqzE51jjs\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web6.loadData(html6,"text/html","utf-8");

        //雷神索爾系列
        web7=findViewById(R.id.web_thor1);
        web8=findViewById(R.id.web_thor2);
        web9=findViewById(R.id.web_thor3);
        //Thor1
        WebSettings webSettings7=web7.getSettings();
        webSettings7.setJavaScriptEnabled(true);
        webSettings7.setBuiltInZoomControls(true);
        webSettings7.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings7.setAppCacheEnabled(true);
        web7.setWebViewClient(new WebViewClient());
        String html7="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/RUZAXF7HJlY\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web7.loadData(html7,"text/html","utf-8");
        //Thor2
        WebSettings webSettings8=web8.getSettings();
        webSettings8.setJavaScriptEnabled(true);
        webSettings8.setBuiltInZoomControls(true);
        webSettings8.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings8.setAppCacheEnabled(true);
        web8.setWebViewClient(new WebViewClient());
        String html8="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/aWcVKHzCMns\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web8.loadData(html8,"text/html","utf-8");
        //Thor3
        WebSettings webSettings9=web9.getSettings();
        webSettings9.setJavaScriptEnabled(true);
        webSettings9.setBuiltInZoomControls(true);
        webSettings9.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings9.setAppCacheEnabled(true);
        web9.setWebViewClient(new WebViewClient());
        String html9="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/jjk501KndEw\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web9.loadData(html9,"text/html","utf-8");

        //復仇者聯盟系列
        web10=findViewById(R.id.web_avenger1);
        web11=findViewById(R.id.web_avenger2);
        web12=findViewById(R.id.web_avenger3);
        web13=findViewById(R.id.web_avenger4);
        //Avengers1
        WebSettings webSettings10=web10.getSettings();
        webSettings10.setJavaScriptEnabled(true);
        webSettings10.setBuiltInZoomControls(true);
        webSettings10.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings10.setAppCacheEnabled(true);
        web10.setWebViewClient(new WebViewClient());
        String html10="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/eOrNdBpGMv8\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web10.loadData(html10,"text/html","utf-8");
        //Avengers2
        WebSettings webSettings11=web11.getSettings();
        webSettings11.setJavaScriptEnabled(true);
        webSettings11.setBuiltInZoomControls(true);
        webSettings11.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings11.setAppCacheEnabled(true);
        web11.setWebViewClient(new WebViewClient());
        String html11="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/Y5P2Ahwdc9M\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web11.loadData(html11,"text/html","utf-8");
        //Avengers3
        WebSettings webSettings12=web12.getSettings();
        webSettings12.setJavaScriptEnabled(true);
        webSettings12.setBuiltInZoomControls(true);
        webSettings12.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings12.setAppCacheEnabled(true);
        web12.setWebViewClient(new WebViewClient());
        String html12="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/JlGkuFI-lj0\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web12.loadData(html12,"text/html","utf-8");
        //Avengers4
        WebSettings webSettings13=web13.getSettings();
        webSettings13.setJavaScriptEnabled(true);
        webSettings13.setBuiltInZoomControls(true);
        webSettings13.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings13.setAppCacheEnabled(true);
        web13.setWebViewClient(new WebViewClient());
        String html13="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/ZrB7EdfPBJU\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web13.loadData(html13,"text/html","utf-8");


        //蟻人系列
        web14=findViewById(R.id.web_ant1);
        web15=findViewById(R.id.web_ant2);
        //ant1
        WebSettings webSettings14=web14.getSettings();
        webSettings14.setJavaScriptEnabled(true);
        webSettings14.setBuiltInZoomControls(true);
        webSettings14.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings14.setAppCacheEnabled(true);
        web14.setWebViewClient(new WebViewClient());
        String html14="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/IjlTAPgJh_o\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web14.loadData(html14,"text/html","utf-8");
        //ant2
        WebSettings webSettings15=web15.getSettings();
        webSettings15.setJavaScriptEnabled(true);
        webSettings15.setBuiltInZoomControls(true);
        webSettings15.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings15.setAppCacheEnabled(true);
        web15.setWebViewClient(new WebViewClient());
        String html15="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/xwLrUuRitLs\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web15.loadData(html15,"text/html","utf-8");

        //星際異攻隊
        web16=findViewById(R.id.web_gx1);
        web17=findViewById(R.id.web_gx2);
        //gx1
        WebSettings webSettings16=web16.getSettings();
        webSettings16.setJavaScriptEnabled(true);
        webSettings16.setBuiltInZoomControls(true);
        webSettings16.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings16.setAppCacheEnabled(true);
        web16.setWebViewClient(new WebViewClient());
        String html16="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/HGS1ntWIhb8\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web16.loadData(html16,"text/html","utf-8");
        //gx2
        WebSettings webSettings17=web17.getSettings();
        webSettings17.setJavaScriptEnabled(true);
        webSettings17.setBuiltInZoomControls(true);
        webSettings17.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings17.setAppCacheEnabled(true);
        web17.setWebViewClient(new WebViewClient());
        String html17="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/hdCxRmLXWxM\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web17.loadData(html17,"text/html","utf-8");

        //個人英雄系列
        web18=findViewById(R.id.web_blackp);
        web19=findViewById(R.id.web_spider);
        web20=findViewById(R.id.web_dr_s);
        web21=findViewById(R.id.web_hluk);
        web22=findViewById(R.id.web_cm);
        web23=findViewById(R.id.web_spider2);
        //黑豹
        WebSettings webSettings18=web18.getSettings();
        webSettings18.setJavaScriptEnabled(true);
        webSettings18.setBuiltInZoomControls(true);
        webSettings18.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings18.setAppCacheEnabled(true);
        web18.setWebViewClient(new WebViewClient());
        String html18="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/n9OPh03GnI4\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web18.loadData(html18,"text/html","utf-8");
        //蜘蛛人
        WebSettings webSettings19=web19.getSettings();
        webSettings19.setJavaScriptEnabled(true);
        webSettings19.setBuiltInZoomControls(true);
        webSettings19.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings19.setAppCacheEnabled(true);
        web19.setWebViewClient(new WebViewClient());
        String html19="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/bPXI4sGdVxQ\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web19.loadData(html19,"text/html","utf-8");
        //
        WebSettings webSettings23=web23.getSettings();
        webSettings23.setJavaScriptEnabled(true);
        webSettings23.setBuiltInZoomControls(true);
        webSettings23.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings23.setAppCacheEnabled(true);
        web23.setWebViewClient(new WebViewClient());
        String html23="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/xq0sQC6ZI9E\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web23.loadData(html23,"text/html","utf-8");

        //奇異博士
        WebSettings webSettings20=web20.getSettings();
        webSettings20.setJavaScriptEnabled(true);
        webSettings20.setBuiltInZoomControls(true);
        webSettings20.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings20.setAppCacheEnabled(true);
        web20.setWebViewClient(new WebViewClient());
        String html20="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/KijjEG_DQ34\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web20.loadData(html20,"text/html","utf-8");
        //浩克
        WebSettings webSettings21=web21.getSettings();
        webSettings21.setJavaScriptEnabled(true);
        webSettings21.setBuiltInZoomControls(true);
        webSettings21.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings21.setAppCacheEnabled(true);
        web21.setWebViewClient(new WebViewClient());
        String html21="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/Dtp_bO8H29Y\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web21.loadData(html21,"text/html","utf-8");
        //驚奇隊長
        WebSettings webSettings22=web22.getSettings();
        webSettings22.setJavaScriptEnabled(true);
        webSettings22.setBuiltInZoomControls(true);
        webSettings22.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings22.setAppCacheEnabled(true);
        web22.setWebViewClient(new WebViewClient());
        String html22="<iframe width=\"400\" height=\"250\"  src=\"https://www.youtube.com/embed/cB99gqYHXAM\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web22.loadData(html22,"text/html","utf-8");
    }
}
