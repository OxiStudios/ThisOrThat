package com.OxiStudios.ThisOrThat.Screens;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.MainMenuButtonListeners.PlayButtonListener;
import com.OxiStudios.ThisOrThat.MainMenuButtonListeners.ScoreBoardListener;
import com.OxiStudios.ThisOrThat.MainMenuButtonListeners.StatsListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class MainMenu implements Screen{
	
	ImageButton play, scoreboard, stats;
	ImageButtonStyle playStyle, scoreboardStyle, statsStyle;
	Skin skin;
	Sprite playSprite, statsSprite, scoreboardSprite;
	
	Sprite background_sprite;
	
	SpriteBatch batch;
	
	Table buttonTable;
	
	Stage stage;

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
		
		Table.drawDebug(stage);
		stage.draw();
		stage.act();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		stage.setViewport(width, height, true);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		if(batch == null) {
			batch = new SpriteBatch();
		}
		
		if(playSprite == null) {
			playSprite = game.mainMenu.createSprite("play");
			playSprite.setSize(.486f * Gdx.graphics.getWidth(), 0.104166f * Gdx.graphics.getHeight());
		}
		
		if(statsSprite == null) {
			statsSprite = game.mainMenu.createSprite("stats");
			statsSprite.setSize(.486f * Gdx.graphics.getWidth(), 0.104166f * Gdx.graphics.getHeight());
		}
		
		if(scoreboardSprite == null) {
			scoreboardSprite = game.mainMenu.createSprite("leaderboard");
			scoreboardSprite.setSize(.486f * Gdx.graphics.getWidth(), 0.104166f * Gdx.graphics.getHeight());
		}
		
		if(skin == null) {
			skin = new Skin();
			skin.add("play", playSprite);
			skin.add("stats", statsSprite);
			skin.add("leaderboard", scoreboardSprite);
		}
		
		if(playStyle == null) {
			playStyle = new ImageButtonStyle();
			playStyle.imageUp = skin.getDrawable("play");
		}
		
		if(scoreboardStyle == null) {
			scoreboardStyle = new ImageButtonStyle();
			scoreboardStyle.imageUp = skin.getDrawable("leaderboard");
		}
		
		if(statsStyle == null) {
			statsStyle = new ImageButtonStyle();
			statsStyle.imageUp = skin.getDrawable("stats");
		}
		
		if(play == null) {
			play = new ImageButton(playStyle);
			play.addListener(new PlayButtonListener(game));
		}
		
		if(scoreboard == null) {
			scoreboard = new ImageButton(scoreboardStyle);
			scoreboard.addListener(new ScoreBoardListener(game));
		}
		
		if(stats == null) {
			stats = new ImageButton(statsStyle);
			stats.addListener(new StatsListener(game));
		}
		
		if(background_sprite == null) {
			background_sprite = game.mainMenu.createSprite("background");
			background_sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		
		if(stage == null) {
			stage = new Stage();
			Gdx.input.setInputProcessor(stage);
		}
		
		if(buttonTable == null) {
			buttonTable = new Table();
			buttonTable.setFillParent(true);
			buttonTable.add(play).center().padTop(Gdx.graphics.getHeight()/1.7f);
			buttonTable.row();
			buttonTable.add(scoreboard).center().padTop(Gdx.graphics.getHeight()/100);
			buttonTable.row();
			buttonTable.add(stats).center().padTop(Gdx.graphics.getHeight()/100);
			
			stage.addActor(buttonTable);
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
