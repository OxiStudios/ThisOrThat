package com.OxiStudios.ThisOrThat.Screens;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.MainMenuButtonListeners.BackButtonListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class StatsScreen implements Screen{
	
	private ThisOrThatGame game;
	SpriteBatch spriteBatch;
	Sprite background;

	public StatsScreen(ThisOrThatGame game) {
		this.game = game;
		Gdx.input.setInputProcessor(new BackButtonListener(game));
		
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
		game.font.draw(spriteBatch, "" + game.savefile.fastestReponse, .6000f * game.SCREEN_WIDTH, .2343f * game.SCREEN_HEIGHT);
		
		game.font.draw(spriteBatch, "Closest Time", .1200f * game.SCREEN_WIDTH, .3151f * game.SCREEN_HEIGHT);
		game.font.draw(spriteBatch, "" + game.savefile.closestTime, .6000f * game.SCREEN_WIDTH, .3151f * game.SCREEN_HEIGHT);
		
		game.font.draw(spriteBatch, "Correct In A Row", .1200f * game.SCREEN_WIDTH, .3968f * game.SCREEN_HEIGHT);
		game.font.draw(spriteBatch, "" + game.savefile.inARow, .6000f * game.SCREEN_WIDTH, .3968f * game.SCREEN_HEIGHT);
		
		game.font.draw(spriteBatch, "Longest Game", .1200f * game.SCREEN_WIDTH, .4817f * game.SCREEN_HEIGHT);
		game.font.draw(spriteBatch, "" + game.savefile.longestGame/1000000000, .6000f * game.SCREEN_WIDTH, .4817f * game.SCREEN_HEIGHT);
		
		if(game.savefile.playTime/1000000000/60 >= 60) {
			game.font.draw(spriteBatch, "Play Time", .1200f * game.SCREEN_WIDTH, .5625f * game.SCREEN_HEIGHT);			
			game.font.draw(spriteBatch,  "" + MathUtils.ceil(((game.savefile.playTime/1000000000.0f)/60.0f)/60.0f) + " mins", .6000f * game.SCREEN_WIDTH, .5625f * game.SCREEN_HEIGHT);			
		}else{
			game.font.draw(spriteBatch, "Play Time", .1200f * game.SCREEN_WIDTH, .5625f * game.SCREEN_HEIGHT);
			game.font.draw(spriteBatch, "" + MathUtils.ceil((game.savefile.playTime/1000000000.0f)/60.0f) + " mins", .6000f * game.SCREEN_WIDTH, .5625f * game.SCREEN_HEIGHT);
		}
		game.font.draw(spriteBatch, "Games Played", .1200f * game.SCREEN_WIDTH, .6432f * game.SCREEN_HEIGHT);
		game.font.draw(spriteBatch, "" + (int)game.savefile.gamesPlayed, .6000f * game.SCREEN_WIDTH, .6432f * game.SCREEN_HEIGHT);
		
		if(game.savefile.highScore >= 1000000) {
			game.font.draw(spriteBatch, "High Score                         ", .1200f * game.SCREEN_WIDTH, .7239f * game.SCREEN_HEIGHT);			
			game.font.draw(spriteBatch, "" + game.savefile.highScore/1000000 + "M pts", .6000f * game.SCREEN_WIDTH, .7239f * game.SCREEN_HEIGHT);			
		}else{
			game.font.draw(spriteBatch, "High Score", .1200f * game.SCREEN_WIDTH, .7239f * game.SCREEN_HEIGHT);			
			game.font.draw(spriteBatch, "" + game.savefile.highScore + " pts", .6000f * game.SCREEN_WIDTH, .7239f * game.SCREEN_HEIGHT);			

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
		if(spriteBatch == null) {
			spriteBatch = new SpriteBatch();
		}
		
		if(background == null) {
			background = new Sprite(game.stats.createSprite("background"));
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
