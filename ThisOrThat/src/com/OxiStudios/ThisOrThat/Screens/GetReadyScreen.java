package com.OxiStudios.ThisOrThat.Screens;

import com.OxiStudios.ThisOrThat.BackButton;
import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.Game.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

public class GetReadyScreen implements Screen {

	Sprite background;
	boolean switchScreen;
	private ThisOrThatGame game;
	
	private BackButton back;

	private SpriteBatch spriteBatch;
	
	float currentTime;
	float startTime;

	public GetReadyScreen(ThisOrThatGame game) {
		this.game = game;
		Gdx.input.setCatchBackKey(true);
		back = new BackButton(game);
		back.isMainMenu(false);
		Gdx.input.setInputProcessor(back);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

		spriteBatch.begin();
		background.draw(spriteBatch);
		spriteBatch.end();
		
		if(currentTime >= 120) {
			game.random.QueueNext();
			game.setScreen(new GameScreen(game));
		}
		
		currentTime += 1;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		currentTime = 0;
		if (background == null) {
			background = new Sprite(game.getReady.createSprite("getready"));
			background.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
		}

		if (spriteBatch == null) {
			spriteBatch = new SpriteBatch();
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
