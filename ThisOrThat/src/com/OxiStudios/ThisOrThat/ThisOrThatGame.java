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
import com.badlogic.gdx.utils.Array;

public class ThisOrThatGame extends Game {
	
	public int TotalScore;
	public Dictionary dictionary;
	public BitmapFont font;
	
	public TextureAtlas mainMenu;
	public TextureAtlas backgrounds;
	public TextureAtlas cat01;
	public TextureAtlas popUp;
	public TextureAtlas getReady;
	public TextureAtlas stats;
	
	public TextureAtlas folder1,folder2, folder3, folder4, folder5, folder6, folder7, folder8, folder9, folder10, folder11, folder12, folder13, folder14;
	public Array<TextureAtlas> pictures;
	
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
		savefile = new SaveFile();
		
		SCREEN_WIDTH  = Gdx.graphics.getWidth();
		SCREEN_HEIGHT = Gdx.graphics.getHeight();
		

		font = new BitmapFont(false);
		font.setColor(Color.BLUE);
		font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		manager  = new AssetManager();
		manager2 = new AssetManager();
		manager3 = new AssetManager();
		manager4 = new AssetManager();
		
		setScreen(new loadScreen(this));
		
		word_position = new Vector2(SCREEN_WIDTH/2f, SCREEN_HEIGHT - .225f * SCREEN_HEIGHT);
		point_position = new Vector2(.51f * SCREEN_WIDTH, .427f * SCREEN_HEIGHT);
		score_position = new Vector2(.21f * SCREEN_WIDTH, .955f * SCREEN_HEIGHT);
		pic_two_position = new Vector2();
		pic_one_position = new Vector2();
		timer_position = new Vector2((.930f * SCREEN_WIDTH), .957f * SCREEN_HEIGHT);
		
		gameScreenCount = 0;
		TotalScore = 0;
		pictures = new Array<TextureAtlas>();
		dictionary  = new Dictionary();
		popUp       = new TextureAtlas();
		backgrounds = new TextureAtlas();
		cat01       = new TextureAtlas();
		getReady    = new TextureAtlas();
		mainMenu    = new TextureAtlas();
		stats       = new TextureAtlas();
		
		folder1 = new TextureAtlas();
		folder2 = new TextureAtlas();
		folder3 = new TextureAtlas();
		folder4 = new TextureAtlas();
		folder5 = new TextureAtlas();
		folder6 = new TextureAtlas();
		folder7 = new TextureAtlas();
		folder8 = new TextureAtlas();
		folder9 = new TextureAtlas();
		folder10 = new TextureAtlas();
		folder11 = new TextureAtlas();
		folder12 = new TextureAtlas();
		folder13 = new TextureAtlas();
		folder14 = new TextureAtlas();

			
		
	}

	@Override
	public void dispose() {
		manager.unload("data/menu/menu.pack");
		manager.unload("data/backgrounds/backgrounds.pack");
		manager.unload("data/fonts/mainFont.fnt");
		manager.unload("data/getReady/getReady.pack");
		manager.unload("data/statsbackground/background.pack");
		manager.unload("data/popUp/popUp.pack");
		manager.unload("data/photo/folder1.pack");
		manager.unload("data/photo/folder2.pack");
		manager.unload("data/photo/folder3.pack");
		manager.unload("data/photo/folder4.pack");
		manager.unload("data/photo/folder5.pack");
		manager.unload("data/photo/folder6.pack");
		manager.unload("data/photo/folder7.pack");
		manager.unload("data/photo/folder8.pack");
		manager.unload("data/photo/folder9.pack");
		manager.unload("data/photo/folder10.pack");
		manager.unload("data/photo/folder11.pack");
		manager.unload("data/photo/folder12.pack");
		manager.unload("data/photo/folder13.pack");
		manager.unload("data/photo/folder14.pack");
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
