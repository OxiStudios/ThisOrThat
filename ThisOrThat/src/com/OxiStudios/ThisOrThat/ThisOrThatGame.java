package com.OxiStudios.ThisOrThat;

import com.OxiStudios.ThisOrThat.Game.RandomPhoto;
import com.OxiStudios.ThisOrThat.Screens.loadScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class ThisOrThatGame extends Game {
	
	public int TotalScore;
	public Dictionary dictionary;
	public BitmapFont font;
	
	public RandomPhoto random;
	
	public TextureAtlas mainMenu;
	public TextureAtlas backgrounds;
	public TextureAtlas cat01;
	public TextureAtlas popUp;
	public TextureAtlas getReady;
	
	public int gameScreenCount;
	
	public AssetManager manager;
	public AssetManager manager2;
	public AssetManager manager3;
	public AssetManager manager4;
	
	public Vector2 word_position, point_position, score_position, pic_one_position, pic_two_position, timer_position;
	
	public float SCREEN_WIDTH;
	public float SCREEN_HEIGHT;
	
	public SaveFile savefile;
	
	public float startGameTime;
	public float endGameTime;
	
	@Override
	public void create() {
		Gdx.input.setCatchBackKey(true);
		
		savefile = new SaveFile();
		
		SCREEN_WIDTH  = Gdx.graphics.getWidth();
		SCREEN_HEIGHT = Gdx.graphics.getHeight();
		

		font = new BitmapFont(false);
		font.setColor(Color.BLUE);
		font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		manager  = new AssetManager();
		manager2 = new AssetManager();

		dictionary  = new Dictionary();
		random = new RandomPhoto(this);
		
		setScreen(new loadScreen(this));
		
		word_position = new Vector2(SCREEN_WIDTH/2f, SCREEN_HEIGHT - .225f * SCREEN_HEIGHT);
		point_position = new Vector2(.51f * SCREEN_WIDTH, .427f * SCREEN_HEIGHT);
		score_position = new Vector2(.21f * SCREEN_WIDTH, .955f * SCREEN_HEIGHT);
		pic_two_position = new Vector2();
		pic_one_position = new Vector2();
		timer_position = new Vector2((.930f * SCREEN_WIDTH), .957f * SCREEN_HEIGHT);
		
		gameScreenCount = 0;
		TotalScore = 0;
		popUp       = new TextureAtlas();
		backgrounds = new TextureAtlas();
		cat01       = new TextureAtlas();
		getReady    = new TextureAtlas();
		mainMenu    = new TextureAtlas();
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
