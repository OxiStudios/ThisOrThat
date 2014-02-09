package com.OxiStudios.ThisOrThat.Screens;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.Game.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
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
			game.setScreen(new GameScreen());
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
			
			loadingImage = new TextureAtlas("data/othergamephotos/loadingScreen.pack");
		}
		
		if(loadingSprite == null) {
			loadingSprite = loadingImage.createSprite("icon_master");
			loadingSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		
		new Thread(new Runnable() {
			long startTime = TimeUtils.millis();
			long currentTime = TimeUtils.millis();
			long elapseTime = 0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(elapseTime <= 4000) {
					elapseTime = currentTime - startTime;
					
					try{
						Thread.sleep(1000);
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
		
	}
}
