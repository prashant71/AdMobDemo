package com.codaemonsoftwares.admobtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        // My AdMobTest AdMob App ID : ca-app-pub-9102405954755269~8780423362
        MobileAds.initialize(this, getString(R.string.app_id_prod));

        //this code hide the app in device
       /* PackageManager p = getPackageManager();
        ComponentName componentName = new ComponentName(this,MainActivity.class); // activity which is first time open in manifiest file which is declare as <category android:name="android.intent.category.LAUNCHER" />
        p.setComponentEnabledSetting(componentName,PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
*/

        //Demo of Banner Ad
        Button btn_bannerAd = (Button) findViewById(R.id.button_banner);
        btn_bannerAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BannerAdActivity.class));
            }
        });

        //For Interstitial Ad Demo
        Button btn_interstitialAd = (Button) findViewById(R.id.button_interstitial);
        btn_interstitialAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InterstitialAdActivity.class));
            }
        });


        Button btn_nativeExpressAd = (Button) findViewById(R.id.button_navtieExpress);
        btn_nativeExpressAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NativeExpress.class));
            }
        });


        Button btn_nativeAdvanceAd = (Button) findViewById(R.id.button_nativeAdvance);
        btn_nativeAdvanceAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NativeAdvance.class));
            }
        });
    }
}
