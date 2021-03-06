package com.OxiStudios.ThisOrThat.Screens;

import com.OxiStudios.ThisOrThat.BackButton;
import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.MainMenuButtonListeners.BackButtonListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class StatsScreen implements Screen{
	
	private ThisOrThatGame game;
	SpriteBatch spriteBatch;
	Sprite background;
	String[] strings, playTimeString;
	
	BackButton back;
	InputMultiplexer inputHandler;

	public StatsScreen(ThisOrThatGame game) {
		this.game = game;
		
		Gdx.input.setCatchBackKey(true);
		inputHandler = new InputMultiplexer();
		inputHandler.addProcessor(new BackButtonListener(game));
		back = new BackButton(game);
		back.isMainMenu(false);
		inputHandler.addProcessor(back);
		
		Gdx.input.setInputProcessor(inputHandler);
		if(game.SCREEN_WIDTH >= 1080) {
			game.font.setScale(2.5f);
		}else if(game.SCREEN_WIDTH >= 720){
			game.font.setScale(2.5f * .6666f);
		}else if(game.SCREEN_WIDTH >= 360) {
			game.font.setScale(.3333f * 2.5f);
		}
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		spriteBatch.begin();
		background.draw(spriteBatch);
		
		game.font.draw(spriteBatch, "Fastest Reponse", .1200f * game.SCREEN_WIDTH, .2343f * game.SCREEN_HEIGHT);
		game.font.draw(spriteBatch, "" + "Coming Soon", .6000f * game.SCREEN_WIDTH, .2343f * game.SCREEN_HEIGHT);
		
		game.font.draw(spriteBatch, "Closest Time", .1200f * game.SCREEN_WIDTH, .3151f * game.SCREEN_HEIGHT);
		game.font.draw(spriteBatch, "" + "Coming Soon", .6000f * game.SCREEN_WIDTH, .3151f * game.SCREEN_HEIGHT);
		
		if(game.savefile.inARow != 0) {
			game.font.draw(spriteBatch, "" + (int)game.savefile.inARow, .6000f * game.SCREEN_WIDTH, .3968f * game.SCREEN_HEIGHT);			
		}else{
			game.font.draw(spriteBatch, "" + 0, .6000f * game.SCREEN_WIDTH, .3968f * game.SCREEN_HEIGHT);
		}
		game.font.draw(spriteBatch, "Correct In A Row", .1200f * game.SCREEN_WIDTH, .3968f * game.SCREEN_HEIGHT);
		
		if(game.savefile.longestGame != 0) {
			game.font.draw(spriteBatch, "" + strings[0] + "." + strings[1].substring(0, 2) + " sec", .6000f * game.SCREEN_WIDTH, .4817f * game.SCREEN_HEIGHT);			
		}else{
			game.font.draw(spriteBatch, "" + 0 + " sec", .6000f * game.SCREEN_WIDTH, .4817f * game.SCREEN_HEIGHT);
		}
		game.font.draw(spriteBatch, "Longest Game", .1200f * game.SCREEN_WIDTH, .4817f * game.SCREEN_HEIGHT);
		
		if(game.savefile.playTime != 0) {
			if(game.savefile.playTime/1000000000/60 >= 60) {
				game.font.draw(spriteBatch, "Play Time", .1200f * game.SCREEN_WIDTH, .5625f * game.SCREEN_HEIGHT);			
				game.font.draw(spriteBatch,  "" + MathUtils.ceil(((game.savefile.playTime/1000000000.0f)/60.0f)/60.0f) + " mins", .6000f * game.SCREEN_WIDTH, .5625f * game.SCREEN_HEIGHT);			
			}else{
				game.font.draw(spriteBatch, "Play Time", .1200f * game.SCREEN_WIDTH, .5625f * game.SCREEN_HEIGHT);
				game.font.draw(spriteBatch, "" + playTimeString[0] + "." + playTimeString[1].subSequence(0, 2) + " mins", .6000f * game.SCREEN_WIDTH, .5625f * game.SCREEN_HEIGHT);
			}			
		}else{
			game.font.draw(spriteBatch, "Play Time", .1200f * game.SCREEN_WIDTH, .5625f * game.SCREEN_HEIGHT);			
			game.font.draw(spriteBatch,  "" + 0 + " mins", .6000f * game.SCREEN_WIDTH, .5625f * game.SCREEN_HEIGHT);			
		}
		
		if(game.savefile.gamesPlayed != 0) {
			game.font.draw(spriteBatch, "Games Played", .1200f * game.SCREEN_WIDTH, .6432f * game.SCREEN_HEIGHT);
			game.font.draw(spriteBatch, "" + (int)game.savefile.gamesPlayed, .6000f * game.SCREEN_WIDTH, .6432f * game.SCREEN_HEIGHT);			
		}else{
			game.font.draw(spriteBatch, "Games Played", .1200f * game.SCREEN_WIDTH, .6432f * game.SCREEN_HEIGHT);
			game.font.draw(spriteBatch, "" + (int)game.savefile.gamesPlayed, .6000f * game.SCREEN_WIDTH, .6432f * game.SCREEN_HEIGHT);
		}
		
		if(game.savefile.highScore != 0) {
			if(game.savefile.highScore >= 1000000) {
				game.font.draw(spriteBatch, "High Score                         ", .1200f * game.SCREEN_WIDTH, .7239f * game.SCREEN_HEIGHT);			
				game.font.draw(spriteBatch, "" + game.savefile.highScore/1000000 + "M pts", .6000f * game.SCREEN_WIDTH, .7239f * game.SCREEN_HEIGHT);			
			}else{
				game.font.draw(spriteBatch, "High Score", .1200f * game.SCREEN_WIDTH, .7239f * game.SCREEN_HEIGHT);			
				game.font.draw(spriteBatch, "" + game.savefile.highScore + " pts", .6000f * game.SCREEN_WIDTH, .7239f * game.SCREEN_HEIGHT);				
			}			
		}else{
			game.font.draw(spriteBatch, "High Score", .1200f * game.SCREEN_WIDTH, .7239f * game.SCREEN_HEIGHT);			
			game.font.draw(spriteBatch, "" + 0 + " pts", .6000f * game.SCREEN_WIDTH, .7239f * game.SCREEN_HEIGHT);				
		}
		
		spriteBatch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		String string = Float.toString(game.savefile.longestGame/1000000000f);
		strings = string.split("\\.");
		
		String playString = Float.toString((game.savefile.playTime/1000000000.0f)/60.0f);
		playTimeString = playString.split("\\.");
		
		
		if(spriteBatch == null) {
			spriteBatch = new SpriteBatch();
		}
		
		if(background == null) {
			background = new Sprite(new Texture(Gdx.files.internal("data/statsbackground/stats_background.png")));
			background.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
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
		spriteBatch.dispose();
	}

}
