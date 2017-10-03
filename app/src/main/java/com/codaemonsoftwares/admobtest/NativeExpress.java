package com.codaemonsoftwares.admobtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;

public class NativeExpress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nativeexpress);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NativeExpressAdView nativeExpressadview=(NativeExpressAdView)findViewById(R.id.adView_nativeexpress);
        //To load Native Express Ad created by Dev
        nativeExpressadview.loadAd(new AdRequest.Builder().build());//.addTestDevice("B228E8597991C63C826904B57E2C9C05").

        //Video Option in NativeExpress Ad
        nativeExpressadview.setVideoOptions(new VideoOptions.Builder()
                .setStartMuted(true)
                .build());

        VideoController vc=nativeExpressadview.getVideoController();
        if(vc.hasVideoContent()){
            Log.i("Video Controller","True");
        }else Log.i("Video Controller","False");

        vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            @Override
            public void onVideoStart() {
                Log.i("Video Controller","Video Started");
                super.onVideoStart();
            }

            @Override
            public void onVideoPlay() {
                Log.i("Video Controller","Video Playing");
                super.onVideoPlay();
            }

            @Override
            public void onVideoPause() {
                Log.i("Video Controller","Video Paused");
                super.onVideoPause();
            }

            @Override
            public void onVideoEnd() {
                // Here apps can take action knowing video playback is finished
                // It's always a good idea to wait for playback to complete before
                // replacing or refreshing a native ad, for example.
                Log.i("Video Controller","Video End");
                super.onVideoEnd();
            }

            @Override
            public void onVideoMute(boolean b) {
                Log.i("Video Controller","Video Muted");
                super.onVideoMute(b);
            }
        });
    }

}
