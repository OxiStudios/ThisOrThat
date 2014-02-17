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
	private ThisOrThatGame game;
	int animationPlace;
	
	float currentTime, startTime;
	
	boolean isReady = false;
	
	public loadScreen(ThisOrThatGame game) {
		
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		batch.begin();
		loadingSprite.draw(batch);
		batch.end();
		if(game.manager.update()) {
			//loading is done
			//assign objects
			game.cat01       = game.manager.get("data/photo/cat01.pack");
			game.popUp       = game.manager.get("data/popUp/popUp.pack");
			game.backgrounds = game.manager.get("data/backgrounds/game_backgrounds.pack");
			game.countDown   = game.manager.get("data/countDown/countDown.pack");
			game.font        = game.manager.get("data/fonts/ourFont.fnt");

			this.dispose();
			game.setScreen(game.mainMenu);
			
		}
		
		if(animationPlace > 5) {
			animationPlace = 1;
		}
		
		if(currentTime - startTime >= 30000) {
			Gdx.app.log("LoadingScreen", "next picture called");
			animationPlace++;
			startTime = currentTime;
			loadingSprite.set(loadingImage.createSprite("background_loop" + Integer.toString(animationPlace)));
			loadingSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
		

		animationPlace = 1;
		startTime = TimeUtils.nanoTime();
		currentTime = 0;
		Gdx.app.log("startTime", "" + startTime + " Current Time: " + currentTime);
		game.manager.load("data/loadingscreen/background_loop.pack", TextureAtlas.class);
		game.manager.finishLoading();
		
		if(batch == null) {
			batch = new SpriteBatch();
		}
		
		if(loadingImage == null) {
			loadingImage = game.manager.get("data/loadingscreen/background_loop.pack");
		}
		
		if(loadingSprite == null) {
			loadingSprite = loadingImage.createSprite("background_loop1");
			loadingSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		
		game.manager.load("data/photo/cat01.pack", TextureAtlas.class);
		game.manager.load("data/backgrounds/game_backgrounds.pack", TextureAtlas.class);
		game.manager.load("data/fonts/ourFont.fnt", BitmapFont.class);
		game.manager.load("data/popUp/popUp.pack", TextureAtlas.class);
		game.manager.load("data/countDown/countDown.pack", TextureAtlas.class);
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
