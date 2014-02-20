package com.OxiStudios.ThisOrThat.Screens;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class loadScreen implements Screen{
	
	SpriteBatch batch;
	TextureAtlas loadingImage;
	TextureAtlas backgroundAtlas;
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
			game.mainMenu    = game.manager.get("data/menu/menu.pack");
			game.popUp       = game.manager.get("data/popUp/popUp.pack");
			game.backgrounds = game.manager.get("data/backgrounds/backgrounds.pack");
			game.getReady    = game.manager.get("data/getReady/getReady.pack");
			game.font        = game.manager.get("data/fonts/mainFont.fnt");
			game.stats       = game.manager.get("data/statsbackground/background.pack");
			
			for(int i = 0; i < 14; i++) {
				game.pictures.add(new TextureAtlas("data/photo/folder" + Integer.toString((i + 1)) + ".pack"));
			}

			this.dispose();
			game.setScreen(new MainMenu(game));
			
		}else{
			currentPicture =  MathUtils.ceil(game.manager.getProgress() * 10);
			if(currentPicture > 1 && currentPicture < 11) {
				loadingSprite.set(loadingImage.createSprite("loading_bar" + (currentPicture - 1)));				
			}
			loadingSprite.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
		}
		
		currentTime = TimeUtils.nanoTime();
		
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
		game.manager.load("data/loadingscreen/loading.pack", TextureAtlas.class);
		game.manager.load("data/loadingscreen/loading_background.atlas", TextureAtlas.class);
		game.manager.finishLoading();
		
		if(batch == null) {
			batch = new SpriteBatch();
		}
		
		if(loadingImage == null) {
			loadingImage = game.manager.get("data/loadingscreen/loading.pack");
			
		}
		
		if(backgroundAtlas == null) {
			backgroundAtlas = game.manager.get("data/loadingscreen/loading_background.atlas");
		}
		
		if(loadingSprite == null) {
			loadingSprite = loadingImage.createSprite("loading_bar" + 1.0);
			loadingSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		
		if(background == null) {
			background = new Sprite(backgroundAtlas.createSprite("background_loading2"));
			background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		
		game.manager.load("data/menu/menu.pack", TextureAtlas.class);
		game.manager.load("data/backgrounds/backgrounds.pack", TextureAtlas.class);
		game.manager.load("data/fonts/mainFont.fnt", BitmapFont.class);
		game.manager.load("data/getReady/getReady.pack", TextureAtlas.class);
		game.manager.load("data/statsbackground/background.pack", TextureAtlas.class);
		game.manager.load("data/popUp/popUp.pack", TextureAtlas.class);
		game.manager.load("data/photo/folder1.pack", TextureAtlas.class);
		game.manager.load("data/photo/folder2.pack", TextureAtlas.class);
		game.manager.load("data/photo/folder3.pack", TextureAtlas.class);
		game.manager.load("data/photo/folder4.pack", TextureAtlas.class);
		game.manager.load("data/photo/folder5.pack", TextureAtlas.class);
		game.manager.load("data/photo/folder6.pack", TextureAtlas.class);
		game.manager.load("data/photo/folder7.pack", TextureAtlas.class);
		game.manager.load("data/photo/folder8.pack", TextureAtlas.class);
		game.manager.load("data/photo/folder9.pack", TextureAtlas.class);
		game.manager.load("data/photo/folder10.pack", TextureAtlas.class);
		game.manager.load("data/photo/folder11.pack", TextureAtlas.class);
		game.manager.load("data/photo/folder12.pack", TextureAtlas.class);
		game.manager.load("data/photo/folder13.pack", TextureAtlas.class);
		game.manager.load("data/photo/folder14.pack", TextureAtlas.class);

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
