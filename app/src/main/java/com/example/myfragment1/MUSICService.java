package com.example.myfragment1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import java.io.IOException;

public class MUSICService extends Service {
    boolean isReady = false;
    private MediaPlayer player;
    int[] music={R.raw.marval,R.raw.spidman,R.raw.ironman3};
    int key;
    public MUSICService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player=MediaPlayer.create(this,music[key]);
        if(player == null) {
            return;
        }
        player.stop();
        player.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                mp.release();
                stopSelf();
                return false;
            }
        });
        try{
            player.prepare();
            isReady=true;

        }catch (IOException e){
            e.printStackTrace();
            isReady=false;

        }
        if(isReady){
            player.setLooping(true);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(isReady && !player.isPlaying()){
            key=intent.getExtras().getInt("key",-1);
            onCreate();
            player.start();
            Toast.makeText(this, "開始播放音樂", Toast.LENGTH_LONG).show();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(player !=null){
            if(player.isPlaying()){
                player.stop();
            }
            player.release();
            Toast.makeText(this, "停止播放音樂", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw null;
    }
}
