package com.example.myfragment1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.myfragment1.ui.mainpage.MainPageFragment;
import com.example.myfragment1.ui.video.VideoFragment;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
        FragmentTabHost tabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);

        tabHost.setup(this, getSupportFragmentManager(),R.id.realtabcontent);

        tabHost.addTab(tabHost.newTabSpec("主頁").setIndicator("主頁"),MainPageFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec("英雄介紹").setIndicator("英雄介紹"), heros.class, null);
        tabHost.addTab(tabHost.newTabSpec("電影介紹").setIndicator("電影介紹"),movie.class,null);
        tabHost.addTab(tabHost.newTabSpec("相關影片").setIndicator("相關影片"), VideoFragment.class,null);

        TabWidget tabWidget = tabHost.getTabWidget();
        for (int i =0; i < tabWidget.getChildCount(); i++) {
            //修改Tabhost高度和宽度
            tabWidget.getChildAt(i).getLayoutParams().height = 150;
            tabWidget.getChildAt(i).getLayoutParams().width = 100;
            //修改显示字体大小
            TextView tv = (TextView) tabWidget.getChildAt(i).findViewById(android.R.id.title);
            tv.setTextSize(16);
            tv.setTextColor(this.getResources().getColorStateList(android.R.color.white));



        }

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_menu1:
                mAuth=FirebaseAuth.getInstance();
                mAuth.signOut();
                Intent it =new Intent(MainActivity.this,Login.class);
                startActivity(it);
                finish();
                return true;
            case R.id.action_menu2:
                Intent ihero=new Intent(MainActivity.this,heros_favoite.class);
                startActivity(ihero);
                return true;
            case R.id.action_menu3:
                Intent imovie=new Intent(MainActivity.this,movie_favorite.class);
                startActivity(imovie);
                return true;
            case R.id.action_menu4:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("關於我們");
                        builder.setIcon(R.mipmap.iconca);
                        builder.setMessage("本程式是以恆逸學生專題所製作\n"+"資料來源均為網路\n"+"絕無營利行為\n"+
                                "若內容有侵害您的著作權，請來信以下信箱，我將儘速移除相關內容，謝謝。\n"+"信箱：derday1104@gmail.com");
                        builder.setPositiveButton("關閉視窗", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
