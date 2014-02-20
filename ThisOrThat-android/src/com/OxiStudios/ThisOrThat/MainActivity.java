package com.OxiStudios.ThisOrThat;

import android.os.Bundle;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = false;
        cfg.useAccelerometer = true;
        
        initialize(new ThisOrThatGame(), cfg);
    }
}