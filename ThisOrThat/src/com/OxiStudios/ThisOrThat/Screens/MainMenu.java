package com.OxiStudios.ThisOrThat.Screens;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.MainMenuButtonListeners.PlayListener;
import com.OxiStudios.ThisOrThat.MainMenuButtonListeners.StatsListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu implements Screen{
	
	Sprite background_sprite;
	
	SpriteBatch batch;
	
	InputMultiplexer inputHanlder;
	PlayListener playListener;
	StatsListener statsListener;

	private ThisOrThatGame game;
	
	public MainMenu(ThisOrThatGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		
		batch.begin();
		background_sprite.draw(batch);
		batch.end();
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
		
		if(background_sprite == null) {
			background_sprite = game.mainMenu.createSprite("background");
			background_sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		
		if(playListener == null) {
			playListener = new PlayListener(game);
		}
		
		if(statsListener == null) {
			statsListener = new StatsListener(game);
		}
		
		if(inputHanlder == null) {
			inputHanlder = new InputMultiplexer();
			inputHanlder.addProcessor(playListener);
			inputHanlder.addProcessor(statsListener);
			Gdx.input.setInputProcessor(inputHanlder);
		}
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
