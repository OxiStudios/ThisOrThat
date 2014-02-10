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
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class MainMenu implements Screen{
	
	TextureAtlas menuButtons;
	
	ImageButton play, scoreboard, stats;
	ImageButtonStyle playStyle, scoreboardStyle, statsStyle;
	
	Texture background_texture;
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
		
		if(menuButtons == null) {
			menuButtons = new TextureAtlas("stand in");
		}
		
		if(playStyle == null) {
			playStyle = new ImageButtonStyle();
		}
		
		if(scoreboardStyle == null) {
			scoreboardStyle = new ImageButtonStyle();
		}
		
		if(statsStyle == null) {
			statsStyle = new ImageButtonStyle();
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
		
		if(background_texture == null) {
			background_texture = new Texture("stand in");
		}
		
		if(background_sprite == null) {
			background_sprite = new Sprite(background_texture);
			background_sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		
		if(stage == null) {
			stage = new Stage();
		}
		
		if(buttonTable == null) {
			buttonTable = new Table();
			buttonTable.setFillParent(true);
			buttonTable.add(play).center().padTop(Gdx.graphics.getHeight()/4);
			buttonTable.row();
			buttonTable.add(scoreboard).center().padTop(Gdx.graphics.getHeight()/6);
			buttonTable.row();
			buttonTable.add(stats).center().padTop(Gdx.graphics.getHeight()/6);
			
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
