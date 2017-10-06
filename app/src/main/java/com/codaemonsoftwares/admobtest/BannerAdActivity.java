package com.codaemonsoftwares.admobtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class BannerAdActivity extends AppCompatActivity {
    String TAG="BannerActivity";
    AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bannerad);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        adView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();//.addTestDevice("B228E8597991C63C826904B57E2C9C05")
        adView.loadAd(adRequest);
        adView.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
                Log.d(TAG,"adClosed");
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                // code to be executed when ad request fails
                Log.d(TAG,"adFailedToLoad");
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdLeftApplication() {
                // code to be executed when user left the app
                Log.d(TAG,"adLeftApplication");
                super.onAdLeftApplication();
            }

            @Override
            public void onAdOpened() {
                // code to be executed when an ad opens on overlay
                Log.d(TAG,"adOpened");
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i("Ads", "onAdLoaded");
                super.onAdLoaded();
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when user click on ad
                Log.i("Ads", "onAdClicked");
                super.onAdClicked();
            }

            @Override
            public void onAdImpression() {
                // Code to be executed when an ad finishes loading.
                Log.i("Ads", "onAdImpression");
                super.onAdImpression();
            }
        });
    }

    @Override
    protected void onPause() {
        if(adView!=null){
            adView.pause();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        if(adView!=null){
            adView.resume();
        }
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        if(adView!=null){
            adView.destroy();
        }
        super.onDestroy();
    }
}
