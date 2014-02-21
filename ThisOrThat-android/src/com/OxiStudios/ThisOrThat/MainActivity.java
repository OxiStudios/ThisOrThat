package com.OxiStudios.ThisOrThat;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AndroidApplication {
	
	/* Your ad unit id. Replace with your actual ad unit id. */
	  private static final String AD_UNIT_ID = "ca-app-pub-1670641965912653/7908134720";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        
        // Create the layout
        RelativeLayout layout = new RelativeLayout(this);

        // Do the stuff that initialize() would do for you
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        // Create the libgdx View
        View gameView = initializeForView(new ThisOrThatGame(), false);

        // Create and setup the AdMob view
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(AD_UNIT_ID);

        // Add the libgdx view
        layout.addView(gameView);
        
        AdRequest adRequest = new AdRequest.Builder().build();
        
        adView.loadAd(adRequest);

        // Add the AdMob view
        RelativeLayout.LayoutParams adParams = 
            new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, 
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        layout.addView(adView, adParams);

        // Hook it all up
        setContentView(layout);
        
        
//        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
//        cfg.useGL20 = false;
//        cfg.useAccelerometer = true;
//        
//        initialize(new ThisOrThatGame(), cfg);
    }
}