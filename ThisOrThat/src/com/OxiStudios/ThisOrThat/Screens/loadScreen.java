package com.OxiStudios.ThisOrThat.Screens;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.TimeUtils;

public class loadScreen implements Screen{
	
	SpriteBatch batch;
	TextureAtlas loadingImage;
	Sprite loadingSprite;
	Sprite background;
	private ThisOrThatGame game;
	
	float currentTime, startTime;
	
	boolean isReady = false;
	float currentPicture = 0;
	
	public loadScreen(ThisOrThatGame game) {
		
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		batch.begin();
		background.draw(batch);
		loadingSprite.draw(batch);
		batch.end();
		if(game.manager.update()) {
			//loading is done
			//assign objects
			game.cat01       = game.manager.get("data/photo/cat01.pack");
			game.popUp       = game.manager.get("data/popUp/popUp.pack");
			game.backgrounds = game.manager.get("data/backgrounds/backgrounds.pack");
			game.getReady   = game.manager.get("data/getReady/getReady.pack");
			game.font        = game.manager.get("data/fonts/mainFont.fnt");

			this.dispose();
			game.setScreen(game.mainMenu);
			
		}else{
			Gdx.app.log("load", "" + currentPicture);
			currentPicture =  game.manager.getProgress();
			loadingSprite.set(loadingImage.createSprite("background_loading2", 7));
			loadingSprite.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
		}
		
		currentTime = TimeUtils.nanoTime();

		Gdx.app.log("startTime", "" + startTime + " Current Time: " + currentTime);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		

		startTime = TimeUtils.nanoTime();
		currentTime = 0;
		Gdx.app.log("startTime", "" + startTime + " Current Time: " + currentTime);
		game.manager.load("data/loadingscreen/loading_bar.pack", TextureAtlas.class);
		game.manager.finishLoading();
		
		if(batch == null) {
			batch = new SpriteBatch();
		}
		
		if(loadingImage == null) {
			loadingImage = game.manager.get("data/loadingscreen/loading_bar.pack");
		}
		
		if(loadingSprite == null) {
			loadingSprite = loadingImage.createSprite("background_loading2", 1);
			loadingSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		
		if(background == null) {
			background = new Sprite(loadingImage.createSprite("background_loading2", 0));
			background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		
		game.manager.load("data/photo/cat01.pack", TextureAtlas.class);
		game.manager.load("data/backgrounds/backgrounds.pack", TextureAtlas.class);
		game.manager.load("data/fonts/mainFont.fnt", BitmapFont.class);
		game.manager.load("data/getReady/getReady.pack", TextureAtlas.class);
		game.manager.load("data/popUp/popUp.pack", TextureAtlas.class);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		loadingImage.dispose();
		batch.dispose();
	}
}
