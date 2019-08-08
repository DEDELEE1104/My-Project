package com.example.myfragment1.ui.mainpage;

import android.app.AlertDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.myfragment1.MUSICService;
import com.example.myfragment1.R;
import com.example.myfragment1.news;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainPageFragment extends Fragment {
    URL url;
    String name;
    String[] title1,photo,url1;
    String[] muiscname={"The Avengers Theme","SpiderMan Theme","IronMan3 Theme"};
    private Button btn_newmovies;
    private ListView newslist;
    private TextView tv_newday,tv_movietime,tv_newtime;
    private Spinner sp_muisc;
    boolean isStop;
    private ImageButton play,stop;
    private TextView tv_login;
    private MainPageViewModel mViewModel;
    //private LayoutInflater inflater;
   // private LinearLayout linearLayout;
    //private  int[] imgs={R.mipmap.userlogo1,R.mipmap.userlogo2,R.mipmap.userlogo3,R.mipmap.userlogo4,R.mipmap.userlogo5,R.mipmap.userlogo6,R.mipmap.userlogo7,R.mipmap.userlogo8};
    private int[] pic={R.mipmap.spidman2movietitle,R.mipmap.spidman2movietitle2,R.mipmap.spidman2movietitle3};
    private WebView web;
    private ViewFlipper viewFlipper;


    public static MainPageFragment newInstance() {
        return new MainPageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_page_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainPageViewModel.class);

        initView();
        initData();
        initHandle();
        initTime();
        View view=getView();
      /*  linearLayout=view.findViewById(R.id.linearlayout);
        inflater=LayoutInflater.from(getActivity());
        for(int i=0;i<pic.length;i++){
            View view1=inflater.inflate(R.layout.moview_pic_layout,linearLayout,false);
            ImageView img=view1.findViewById(R.id.img_moviepic);
            img.setImageResource(pic[i]);
            linearLayout.addView(view1);*/
        FirebaseAuth mAuth=FirebaseAuth.getInstance();
        FirebaseUser user=mAuth.getCurrentUser();

      if(user.getDisplayName()==null){
          tv_login.setText("帳號："+user.getEmail()+"\n歡迎新用戶加入復仇者聯盟的行列");
      }  else {
          tv_login.setText("帳號："+user.getEmail()+"\n用戶："+user.getDisplayName()+"\n已登入");
      }


    viewFlipper=view.findViewById(R.id.viewflipper);
    for (int v=0;v<pic.length;v++){
        ImageView iv=new ImageView(getActivity());
        iv.setImageResource(pic[v]);
        viewFlipper.addView(iv);
    }
    viewFlipper.setAutoStart(true);
    viewFlipper.setFlipInterval(2000);
    if(viewFlipper.isAutoStart()&& !viewFlipper.isFlipping()){
        viewFlipper.startFlipping();
    }


        }



    private void initTime() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (!isStop){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showDateInfo();
                        }
                    });
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isStop=true;
    }

    private void showDateInfo() {
        Date date = new Date();
        SimpleDateFormat year = new SimpleDateFormat("YYYY");
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat day = new SimpleDateFormat("dd");
        SimpleDateFormat time1 = new SimpleDateFormat("HH");
        Date time = new Date();
        String str = time1.format(time);
        SimpleDateFormat time2 = new SimpleDateFormat("mm");
        String str1 = time2.format(time);
        SimpleDateFormat time3 = new SimpleDateFormat("ss");
        String str2 = time3.format(time);



        String a=year.format(date);
        String b=month.format(date);
        String c=day.format(date);
        int y=Integer.parseInt(a);
        int m=Integer.parseInt(b);
        int d=Integer.parseInt(c);
        int movieyears=2019;
        int moviemonth=7;
        int moviedate=3;
        int totalyears=movieyears-y;
        int totalmonth=moviemonth-m;
        int totaldate=moviedate-d;
        int o = Integer.parseInt(str);
        if (o >= 13) {
            tv_newtime.setText(String.format(" 下午%s點%s分%s秒", o, str1, str2));
        } else {
            tv_newtime.setText(String.format(" 上午%s點%s分%s秒", o, str1, str2));
        }
        if(totalyears==0 || totalmonth==0 || totaldate<=0 ){
            tv_movietime.setText("現正熱映中");

       /* }else if(totalmonth==0){
            tv_movietime.setText(String.format("剩下%d天",totaldate));
        }else {
            tv_movietime.setText(String.format("剩下%d年%d月%d日",totalyears,totalmonth,totaldate));
        }*/
    }



    private void initHandle() {

        final Intent go =new Intent(getActivity(), MUSICService.class);
        sp_muisc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, final long id) {
                switch(position){
                    case  0:
                        play.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                go.putExtra("key",0);
                                getActivity().startService(go);
                            }
                        });
                        stop.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                getActivity().stopService(go);
                            }
                        });
                        break;
                    case 1:
                        play.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                go.putExtra("key",1);
                                getActivity().startService(go);
                            }
                        });
                        stop.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                getActivity().stopService(go);
                            }
                        });
                        break;
                    case 2:
                        play.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                go.putExtra("key",2);
                                getActivity().startService(go);
                            }
                        });
                        stop.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                getActivity().stopService(go);
                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final Intent it=new Intent();
        newslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                it.putExtra("URL", url1[position]);
                it.setClass(getActivity(), news.class);
                startActivity(it);
            }
        });

        btn_newmovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder dialog =new AlertDialog.Builder(getActivity());
                dialog.setView(web);
                dialog.setPositiveButton("離開", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dia, int which) {
                                ((ViewGroup) web.getParent()).removeView(web);
                                dia.dismiss();
                            }
                        }).show();

            }
        });
    }


    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    ArrayList<String> arrayList=new ArrayList<>();
                    url=new URL("https://popbee.com/tag/marvel/");
                    Document doc= Jsoup.parse(url,3000);
                    Elements title=doc.select("a[class]");
                    for(int i=0;i<title.size();i++) {
                        Elements title_select = title.get(i).select("a[class]");
                        if (i == 15 || i == 17 || i == 19 || i == 21 || i == 23 || i == 25) {
                            name = title_select.get(0).text();
                            Log.i("der",name);
                            arrayList.add(name);
                        }
                    }
                    title1=arrayList.toArray(new String[0]);


                    //圖片
                    UpdateUI(title1);
                    ArrayList<String> arrayList2=new ArrayList<>();
                    Elements photo1=doc.select("img[src]");
                    for(int i=0;i<photo1.size();i++){
                        Elements title_select1 = photo1.get(i).select("img[src]");
                        if(i>=13 & i<=19 ) {
                            String name = title_select1.attr("abs:src");
                            Log.i("Der", String.format("抓到:%s", name));
                            arrayList2.add(name);

                        }
                    }
                    photo=arrayList2.toArray(new String[0]);
                    UpdateUI(photo);

                    //網址
                    ArrayList<String> arrayList3=new ArrayList<>();
                    Elements title2=doc.select("a[href]");
                    for(int i=0;i<title2.size();i++) {
                        Elements title_select = title2.get(i).select("a[href]");
                        if(i>=56 & i<=78){
                            if(i%4==0){
                                name = title_select.attr("abs:href");
                                Log.i("Mic",name);
                                arrayList3.add(name);
                            }
                        }

                    }
                    url1=arrayList3.toArray(new String[0]);


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void initView() {

        tv_login=getView().findViewById(R.id.tv_login);
        sp_muisc=getView().findViewById(R.id.sp_muisc);
        play=getView().findViewById(R.id.btn_start);
        stop=getView().findViewById(R.id.btn_stop);
        tv_movietime=getView().findViewById(R.id.tv_movietime);
        tv_newday=getView().findViewById(R.id.tv_newday);
        newslist=getView().findViewById(R.id.newslist);
        tv_newtime=getView().findViewById(R.id.tv_newtime);
        btn_newmovies=getView().findViewById(R.id.btn_newmovies);


        ArrayAdapter idlist=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,muiscname);
        idlist.setDropDownViewResource(android.R.layout.simple_list_item_1);
        sp_muisc.setAdapter(idlist);
        Date date=new Date();
        SimpleDateFormat year=new SimpleDateFormat("YYYY");
        SimpleDateFormat month=new SimpleDateFormat("MM");
        SimpleDateFormat day=new SimpleDateFormat("dd");
        String a=year.format(date);
        String b=month.format(date);
        String c=day.format(date);
        int y=Integer.parseInt(a);
        int m=Integer.parseInt(b);
        int d=Integer.parseInt(c);
        tv_newday.setText(String.format("%s/%s/%s",y,m,d));



        web=new WebView(getActivity());
        WebSettings webSettings0=web.getSettings();
        webSettings0.setJavaScriptEnabled(true);
        webSettings0.setBuiltInZoomControls(true);
        webSettings0.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings0.setAppCacheEnabled(true);
        web.setWebViewClient(new WebViewClient());
        String html0="<iframe width=\"340\" height=\"250\"  src=\"https://www.youtube.com/embed/xq0sQC6ZI9E\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        web.loadData(html0,"text/html","utf-8");

    }

//    public WebView getWebView(){
//        WebView web =new WebView(getActivity());
//        WebSettings webSettings0=web.getSettings();
//        webSettings0.setJavaScriptEnabled(true);
//        webSettings0.setBuiltInZoomControls(true);
//        webSettings0.setJavaScriptCanOpenWindowsAutomatically(true);
//        webSettings0.setAppCacheEnabled(true);
//        web.setWebViewClient(new WebViewClient());
//        String html0="<iframe width=\"330\" height=\"250\"  src=\"https://www.youtube.com/embed/xq0sQC6ZI9E\"  frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
//        web.loadData(html0,"text/html","utf-8");
//        return web;
    //}


    private void UpdateUI(String[] title1){
        getActivity().runOnUiThread(new Runnable(){
            @Override
            public void run() {
                MyAdapter adapter=new MyAdapter(getActivity());
                newslist.setAdapter(adapter);
            }

        });
    }
    class MyAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        public MyAdapter(Context c) {
            inflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            return title1.length;
        }

        @Override
        public Object getItem(int position) {
            return title1[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView=inflater.inflate(R.layout.news_test_layout,null);
            TextView text=convertView.findViewById(R.id.text_news);

            text.setText(title1[position]);

            final View finalConvertView = convertView;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final Bitmap mBitmap=getBitmapFromURL1(photo[position]);

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ImageView img= finalConvertView.findViewById(R.id.text_newsimg);
                            img.setImageBitmap(mBitmap);
                        }
                    });
                }
            }).start();
            return convertView;
        }
    }

    private static Bitmap getBitmapFromURL1(String imageUrl) {
        try
        {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
