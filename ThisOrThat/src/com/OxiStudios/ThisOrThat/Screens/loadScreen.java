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
		if(game.manager.update() && game.manager2.update() && game.manager3.update() && game.manager4.update()) {
			//loading is done
			//assign objects
			game.mainMenu    = game.manager.get("data/menu/menu.pack");
			game.popUp       = game.manager2.get("data/popUp/popUp.pack");
			game.backgrounds = game.manager.get("data/backgrounds/backgrounds.pack");
			game.getReady    = game.manager2.get("data/getReady/getReady.pack");
			game.font        = game.manager.get("data/fonts/mainFont.fnt");
			game.stats       = game.manager2.get("data/statsbackground/background.pack");
			
			game.folder1  = game.manager3.get("data/photo/folder1.pack");
			game.folder2  = game.manager3.get("data/photo/folder2.pack");
			game.folder3  = game.manager3.get("data/photo/folder3.pack");
			game.folder4  = game.manager3.get("data/photo/folder4.pack");
			game.folder5  = game.manager3.get("data/photo/folder5.pack");
			game.folder6  = game.manager3.get("data/photo/folder6.pack");
			game.folder7  = game.manager3.get("data/photo/folder7.pack");
			game.folder8  = game.manager4.get("data/photo/folder8.pack");
			game.folder9  = game.manager4.get("data/photo/folder9.pack");
			game.folder10 = game.manager4.get("data/photo/folder10.pack");
			game.folder11 = game.manager4.get("data/photo/folder11.pack");
			game.folder12 = game.manager4.get("data/photo/folder12.pack");
			game.folder13 = game.manager4.get("data/photo/folder13.pack");
			game.folder14 = game.manager4.get("data/photo/folder14.pack");
			
			game.pictures.add(game.folder1);
			game.pictures.add(game.folder2);
			game.pictures.add(game.folder3);
			game.pictures.add(game.folder4);
			game.pictures.add(game.folder5);
			game.pictures.add(game.folder6);
			game.pictures.add(game.folder7);
			game.pictures.add(game.folder8);
			game.pictures.add(game.folder9);
			game.pictures.add(game.folder10);
			game.pictures.add(game.folder11);
			game.pictures.add(game.folder12);
			game.pictures.add(game.folder13);
			game.pictures.add(game.folder14);
			
			game.setScreen(new MainMenu(game));
			this.dispose();
			
		}else{
			currentPicture =  MathUtils.ceil(game.manager3.getProgress() * 10);
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
		game.manager2.load("data/getReady/getReady.pack", TextureAtlas.class);
		game.manager2.load("data/statsbackground/background.pack", TextureAtlas.class);
		game.manager2.load("data/popUp/popUp.pack", TextureAtlas.class);
		game.manager3.load("data/photo/folder1.pack", TextureAtlas.class);
		game.manager3.load("data/photo/folder2.pack", TextureAtlas.class);
		game.manager3.load("data/photo/folder3.pack", TextureAtlas.class);
		game.manager3.load("data/photo/folder4.pack", TextureAtlas.class);
		game.manager3.load("data/photo/folder5.pack", TextureAtlas.class);
		game.manager3.load("data/photo/folder6.pack", TextureAtlas.class);
		game.manager3.load("data/photo/folder7.pack", TextureAtlas.class);
		game.manager4.load("data/photo/folder8.pack", TextureAtlas.class);
		game.manager4.load("data/photo/folder9.pack", TextureAtlas.class);
		game.manager4.load("data/photo/folder10.pack", TextureAtlas.class);
		game.manager4.load("data/photo/folder11.pack", TextureAtlas.class);
		game.manager4.load("data/photo/folder12.pack", TextureAtlas.class);
		game.manager4.load("data/photo/folder13.pack", TextureAtlas.class);
		game.manager4.load("data/photo/folder14.pack", TextureAtlas.class);

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
		game.manager.unload("data/loadingscreen/loading.pack");
		game.manager.unload("data/loadingscreen/loading_background.atlas");
		loadingImage.dispose();
		batch.dispose();
	}
}
