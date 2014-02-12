package com.OxiStudios.ThisOrThat;

import com.OxiStudios.ThisOrThat.Screens.loadScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ThisOrThatGame extends Game {
	
	public int TotalScore;
	public TextureHandler textureHandler;
	public Dictionary dictionary;
	public BitmapFont font;
	public TextureAtlas backgrounds;
	
	@Override
	public void create() {
		TotalScore = 0;
		setScreen(new loadScreen(this));
		
		textureHandler = new TextureHandler();
		dictionary = new Dictionary();
		backgrounds = new TextureAtlas(Gdx.files.internal("data/backgrounds/backgrounds.pack"));
		font = new BitmapFont(Gdx.files.internal("data/fonts/ourFont.fnt"), false);
		font.setColor(Color.BLUE);
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
