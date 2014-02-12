package com.OxiStudios.ThisOrThat.Screens;

import com.OxiStudios.ThisOrThat.TextureHandler;
import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.Game.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;

public class loadScreen implements Screen{
	
	SpriteBatch batch;
	TextureAtlas loadingImage;
	Sprite loadingSprite;
	private ThisOrThatGame game;
	
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
		
		if(isReady) {
			game.setScreen(new MainMenu(game));
			this.dispose();
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		if(batch == null) {
			batch = new SpriteBatch();
		}
		
		if(loadingImage == null) {
			
			loadingImage = new TextureAtlas("data/loadingscreen/background_loop.pack");
		}
		
		if(loadingSprite == null) {
			loadingSprite = loadingImage.createSprite("background_loop1");
			loadingSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		
		new Thread(new Runnable() {
			long startTime = TimeUtils.millis();
			long currentTime = TimeUtils.millis();
			long elapseTime = 0;
			int animationPlace = 1;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(elapseTime <= 4000) {
					elapseTime = currentTime - startTime;
					if(animationPlace > 5) {
						animationPlace = 1;
					}
					
					loadingSprite.set(loadingImage.createSprite("background_loop" + Integer.toString(animationPlace)));
					loadingSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
					animationPlace++;
					try{
						Thread.sleep(1000/30);
					}catch(InterruptedException e) {
						
					}
					
					currentTime = TimeUtils.millis();
					Gdx.app.log("ElapseTime", "" + elapseTime);
					if(elapseTime >= 3999) {
						isReady = true;
					}
				}
			}
		}).start();
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
