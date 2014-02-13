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
			game.cat01 = game.manager.get("data/photo/cat01.pack");
			
			game.backgrounds = game.manager.get("data/backgrounds/backgrounds.pack");
			game.font = game.manager.get("data/fonts/ourFont.fnt");
			game.setScreen(new MainMenu(game));
		}
		if(isReady) {
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
		
		game.manager.load("data/photo/cat01.pack", TextureAtlas.class);
		game.manager.load("data/backgrounds/backgrounds.pack", TextureAtlas.class);
		game.manager.load("data/fonts/ourFont.fnt", BitmapFont.class);
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
