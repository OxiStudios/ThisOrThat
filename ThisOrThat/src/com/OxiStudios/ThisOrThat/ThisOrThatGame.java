package com.OxiStudios.ThisOrThat;

import com.OxiStudios.ThisOrThat.Screens.MainMenu;
import com.OxiStudios.ThisOrThat.Screens.loadScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class ThisOrThatGame extends Game {
	
	public MainMenu mainMenu;
	
	public int TotalScore;
	public Dictionary dictionary;
	public BitmapFont font;
	public TextureAtlas backgrounds;
	public TextureAtlas cat01;
	
	public AssetManager manager;
	
	public Vector2 word_position, point_position, score_position, pic_one_position, pic_two_position, timer_position;
	
	public float SCREEN_WIDTH;
	public float SCREEN_HEIGHT;
	
	@Override
	public void create() {
		mainMenu = new MainMenu(this);
		
		SCREEN_WIDTH  = Gdx.graphics.getWidth();
		SCREEN_HEIGHT = Gdx.graphics.getHeight();
		
		manager = new AssetManager();
		
		setScreen(new loadScreen(this));
		
		if(SCREEN_WIDTH < 1080) {
			//less than 1080p
			
		}else if(SCREEN_WIDTH == 1080) {
			//1080p screen
		}
		
		TotalScore = 0;
		dictionary = new Dictionary();
		backgrounds = new TextureAtlas();
		cat01       = new TextureAtlas();
		font = new BitmapFont(false);
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
