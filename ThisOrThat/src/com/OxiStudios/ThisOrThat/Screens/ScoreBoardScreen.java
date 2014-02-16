package com.OxiStudios.ThisOrThat.Screens;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.MainMenuButtonListeners.BackListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ScoreBoardScreen implements Screen{
	
	TextureAtlas ScoreBoardScreenButtons;
	TextureAtlas background_texture;
	
	ImageButton scoreboard, back;
	ImageButtonStyle scoreboardStyle, backStyle;
	Skin skin;
	
	Sprite scoreboardSprite;
	Sprite backSprite;
	Sprite mainMenuSprite;
	Sprite background_sprite;
	
	SpriteBatch batch;
	
	Table buttonTable;
	
	Stage stage;
	
	private ThisOrThatGame game;
	
	public ScoreBoardScreen(ThisOrThatGame game) {
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
		
		if(ScoreBoardScreenButtons == null) {
			ScoreBoardScreenButtons = new TextureAtlas("");
		}
		
		if(backSprite == null) {
			backSprite = ScoreBoardScreenButtons.createSprite("back");
			backSprite.setSize(.486f * Gdx.graphics.getWidth(), 0.104166f * Gdx.graphics.getHeight());
		}
		if(skin == null) {
			skin = new Skin();
			skin.add("back", backSprite);
		}
		
		if(backStyle == null) {
			backStyle = new ImageButtonStyle();
			backStyle.imageUp = skin.getDrawable("back");
		}
		
		if(back == null) {
			back = new ImageButton(backStyle);
			back.addListener(new BackListener(game));
		}
		
		if(background_texture == null) {
			background_texture = new TextureAtlas("");
		}
		
		if(background_sprite == null) {
			background_sprite = background_texture.createSprite("background_loading");
			background_sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		
		if(stage == null) {
			stage = new Stage();
			Gdx.input.setInputProcessor(stage);
		}
		
		if(buttonTable == null) {
			buttonTable = new Table();
			buttonTable.setFillParent(true);
			buttonTable.add(back).center().padTop(Gdx.graphics.getHeight()/1.7f);
			
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
