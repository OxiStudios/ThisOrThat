package com.OxiStudios.ThisOrThat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TextureHandler {
	
	public TextureAtlas cat01;
	
	public TextureHandler() {
		cat01 = new TextureAtlas(Gdx.files.internal("data/photo/cat01.pack"));
	}

}
