package com.OxiStudios.ThisOrThat;

import com.OxiStudios.ThisOrThat.Screens.loadScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class ThisOrThatGame extends Game {
	
	public int TotalScore;
	public Dictionary dictionary;
	public BitmapFont font;
	
	public TextureAtlas mainMenu;
	public TextureAtlas backgrounds;
	public TextureAtlas cat01;
	public TextureAtlas popUp;
	public TextureAtlas getReady;
	
	public int gameScreenCount;
	
	public AssetManager manager;
	
	public Vector2 word_position, point_position, score_position, pic_one_position, pic_two_position, timer_position;
	
	public float SCREEN_WIDTH;
	public float SCREEN_HEIGHT;
	
	public SaveFile savefile;
	
	@Override
	public void create() {
		savefile = new SaveFile();
		
		SCREEN_WIDTH  = Gdx.graphics.getWidth();
		SCREEN_HEIGHT = Gdx.graphics.getHeight();
		

		font = new BitmapFont(false);
		font.setColor(Color.BLUE);
		font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		manager = new AssetManager();
		
		setScreen(new loadScreen(this));
		if(SCREEN_WIDTH < 720) {
			//less than 720p
			word_position = new Vector2(SCREEN_WIDTH/2f, SCREEN_HEIGHT - .225f * SCREEN_HEIGHT);
			point_position = new Vector2(.51f * SCREEN_WIDTH, .427f * SCREEN_HEIGHT);
			score_position = new Vector2(.20f * SCREEN_WIDTH, .96f * SCREEN_HEIGHT);
			pic_two_position = new Vector2();
			pic_one_position = new Vector2();
			timer_position = new Vector2((.95f * SCREEN_WIDTH), .96f * SCREEN_HEIGHT);
			
		}else if(SCREEN_WIDTH < 1080) {
			//less than 1080p
			word_position = new Vector2(SCREEN_WIDTH/2f, SCREEN_HEIGHT - .225f * SCREEN_HEIGHT);
			point_position = new Vector2(.51f * SCREEN_WIDTH, .427f * SCREEN_HEIGHT);
			score_position = new Vector2(.18f * SCREEN_WIDTH, .96f * SCREEN_HEIGHT);
			pic_two_position = new Vector2();
			pic_one_position = new Vector2();
			timer_position = new Vector2((.95f * SCREEN_WIDTH), .96f * SCREEN_HEIGHT);
			
		}else if(SCREEN_WIDTH >= 1080) {
			//1080p screen
			word_position = new Vector2(SCREEN_WIDTH/2f, SCREEN_HEIGHT - .225f * SCREEN_HEIGHT);
			point_position = new Vector2(.51f * SCREEN_WIDTH, .427f * SCREEN_HEIGHT);
			score_position = new Vector2(.18f * SCREEN_WIDTH, .96f * SCREEN_HEIGHT);
			pic_two_position = new Vector2();
			pic_one_position = new Vector2();
			timer_position = new Vector2((.945f * SCREEN_WIDTH), .955f * SCREEN_HEIGHT);
			
		}
		
		gameScreenCount = 0;
		TotalScore = 0;
		
		dictionary  = new Dictionary();
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
