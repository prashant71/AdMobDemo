package com.codaemonsoftwares.admobtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;

public class NativeAdvance extends AppCompatActivity {
    private static final String ADMOB_AD_UNIT_ID = "ca-app-pub-3940256099942544/2247696110";
    private static final String ADMOB_APP_ID = "ca-app-pub-3940256099942544~3347511713";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nativeadvance);

//        MobileAds.initialize(this, ADMOB_APP_ID);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        AdLoader al=new AdLoader.Builder(NativeAdvance.this,ADMOB_AD_UNIT_ID)
         .forAppInstallAd(new NativeAppInstallAd.OnAppInstallAdLoadedListener() {
            @Override
            public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
                FrameLayout fml=(FrameLayout)findViewById(R.id.frame);
                NativeAppInstallAdView nativeAppInstallAdView=(NativeAppInstallAdView)getLayoutInflater().inflate(R.layout.adview_installapp,null);
                displayAppInstallAd(nativeAppInstallAd,nativeAppInstallAdView);
            }
         })
         .forContentAd(new NativeContentAd.OnContentAdLoadedListener() {
            @Override
            public void onContentAdLoaded(NativeContentAd nativeContentAd) {
                FrameLayout fml=(FrameLayout)findViewById(R.id.frame);
                NativeContentAdView nativeContentAdView=(NativeContentAdView) getLayoutInflater().inflate(R.layout.ad_content,null);
                nativeContentAdView.setHeadlineView(nativeContentAdView.findViewById(R.id.contentad_headline));
                nativeContentAdView.setImageView(nativeContentAdView.findViewById(R.id.contentad_image));
                nativeContentAdView.setBodyView(nativeContentAdView.findViewById(R.id.contentad_body));
                nativeContentAdView.setCallToActionView(nativeContentAdView.findViewById(R.id.contentad_call_to_action));
                nativeContentAdView.setLogoView(nativeContentAdView.findViewById(R.id.contentad_logo));
                nativeContentAdView.setAdvertiserView(nativeContentAdView.findViewById(R.id.contentad_advertiser));

                // Some assets are guaranteed to be in every NativeContentAd.
                ((TextView) nativeContentAdView.getHeadlineView()).setText(nativeContentAd.getHeadline());
                ((TextView) nativeContentAdView.getBodyView()).setText(nativeContentAd.getBody());
                ((TextView) nativeContentAdView.getCallToActionView()).setText(nativeContentAd.getCallToAction());
                ((TextView) nativeContentAdView.getAdvertiserView()).setText(nativeContentAd.getAdvertiser());
                ((ImageView) nativeContentAdView.getImageView()).setImageDrawable(nativeContentAd.getImages().get(0).getDrawable());

                nativeContentAdView.setNativeAd(nativeContentAd);
                fml.removeAllViews();
                fml.addView(nativeContentAdView);
            }
         })
        .withAdListener(new AdListener() {
            @Override
             public void onAdFailedToLoad(int errorCode) {
                        // Handle the failure by logging, altering the UI, and so on.
                    }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }
        })
        .withNativeAdOptions(new NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
        .build()).build();
        al.loadAd(new AdRequest.Builder().build());
    }

    private void displayAppInstallAd(NativeAppInstallAd nativeAppInstallAd, NativeAppInstallAdView nativeAppInstallAdView) {
        nativeAppInstallAdView.setHeadlineView(nativeAppInstallAdView.findViewById(R.id.adheader));
        nativeAppInstallAdView.setIconView(nativeAppInstallAdView.findViewById(R.id.adimage));
        nativeAppInstallAdView.setCallToActionView(nativeAppInstallAdView.findViewById(R.id.btn_adinstall));


        ((TextView)nativeAppInstallAdView.getHeadlineView()).setText(nativeAppInstallAd.getHeadline());
        ((ImageView)nativeAppInstallAdView.getIconView()).setImageDrawable(nativeAppInstallAd.getIcon().getDrawable());
        ((Button)nativeAppInstallAdView.getCallToActionView()).setText(nativeAppInstallAd.getCallToAction());

        nativeAppInstallAdView.setNativeAd(nativeAppInstallAd);
    }

}
