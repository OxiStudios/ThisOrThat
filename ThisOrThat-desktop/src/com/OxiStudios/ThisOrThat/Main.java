package com.OxiStudios.ThisOrThat;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "ThisOrThat";
		cfg.useGL20 = true;
		cfg.width = 1080/3;
		cfg.height = 1920/3;
		
		new LwjglApplication(new ThisOrThatGame(), cfg);
	}
}
