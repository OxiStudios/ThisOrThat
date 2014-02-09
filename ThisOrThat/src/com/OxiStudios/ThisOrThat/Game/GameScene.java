package com.OxiStudios.ThisOrThat.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;

public class GameScene {
	
	float SCREEN_WIDTH  = Gdx.graphics.getWidth();
	float SCREEN_HEIGHT = Gdx.graphics.getHeight();
	
	public boolean isRight;
	
	public Timer timer;
	
	Stage stage;
	
	ImageButton picture_One, picture_Two;
	Table mainTable, pictureTableOne, pictureTableTwo, pointTable, wordTable, titleTable;
	private SpriteBatch spriteBatch;
	
	public double gameScore;
	public double totalScore;
	
	RandomPhoto randomPhoto;
	
	BitmapFont font;
	
	public GameScene() {
		stage = new Stage();
		spriteBatch = new SpriteBatch();
		randomPhoto = new RandomPhoto();
		
		gameScore = 750.0;
		
		timer = new Timer(this);
		timer.timerThread.start();
		
		font = new BitmapFont(Gdx.files.internal("data/fonts/ourFont.fnt"), false);
		font.setColor(Color.BLUE);
		
		Gdx.app.log("Screen", "Width: " + SCREEN_WIDTH);
		Gdx.app.log("Screen", "Height: " + SCREEN_HEIGHT);
		
		makeButtons();
		makeTables();
		
		Gdx.input.setInputProcessor(stage);
	}
	
	
	public void render() {
		

		stage.draw();
		
		spriteBatch.begin();
		font.draw(spriteBatch, "Time: " + timer.getTimer(), SCREEN_WIDTH/2,SCREEN_HEIGHT/2);
		font.draw(spriteBatch, "Score: " + this.gameScore, SCREEN_WIDTH/2, SCREEN_HEIGHT/4);
		font.draw(spriteBatch, "Total Score: " + totalScore, SCREEN_WIDTH/2, SCREEN_HEIGHT/5);
		spriteBatch.end();
		

		stage.act();
		Table.drawDebug(stage);
		
	}
	
	public void makeTables() {
		mainTable = new Table();
		mainTable.setFillParent(true);
		
		titleTable      = new Table();
		wordTable       = new Table();
		pictureTableOne = new Table();
		pointTable      = new Table();
		pictureTableTwo = new Table();
		
		pictureTableOne.add(picture_One);
		pictureTableTwo.add(picture_Two);
		
		mainTable.add(titleTable);
		mainTable.row();
		mainTable.add(wordTable).center();
		mainTable.row();
		mainTable.add(pictureTableOne);
		mainTable.row();
		mainTable.add(pointTable);
		mainTable.row();
		mainTable.add(pictureTableTwo);
		
		
		stage.addActor(mainTable);
	}
	
	public void makeButtons() {
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("data/photo/testpack1.pack"));
		ImageButtonStyle style_1 = new ImageButtonStyle();
		ImageButtonStyle style_2 = new ImageButtonStyle();
		
		Skin skin = new Skin();
		skin.add("image_1", new Sprite(atlas.createSprite("SCALED1435535")));
		skin.add("image_2", new Sprite(atlas.createSprite("SCALEDbread")));
		
		style_1.imageUp = skin.newDrawable("image_1");
		style_2.imageUp = skin.newDrawable("image_2");
		picture_One = new ImageButton(style_1);
		picture_Two = new ImageButton(style_2);
		
		picture_One.setName("Image_1");
		picture_Two.setName("Image_2");
		
		picture_One.addListener(new ButtonListener(this, picture_One, timer, true));
		picture_Two.addListener(new ButtonListener(this, picture_Two, timer, false));
		
	}

}
