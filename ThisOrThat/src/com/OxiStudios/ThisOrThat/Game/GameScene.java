package com.OxiStudios.ThisOrThat.Game;

import com.OxiStudios.ThisOrThat.Dictionary;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;

public class GameScene {
	
	float SCREEN_WIDTH  = Gdx.graphics.getWidth();
	float SCREEN_HEIGHT = Gdx.graphics.getHeight();
	
	public Timer timer;
	
	Stage stage;
	
	ImageButton picture_One, picture_Two;
	Table mainTable, pictureTableOne, pictureTableTwo, pointTable, wordTable, titleTable;
	private SpriteBatch spriteBatch;
	
	public double gameScore;
	public double totalScore;
	
	RandomPhoto randomPhoto;
	
	BitmapFont font;
	float widthForTime;
	
	String randomWord;
	
	int pic01_catNum;
	int pic02_catNum;
	int pic01_num;
	int pic02_num;
	
	Dictionary dictionary = new Dictionary();
	
	public GameScene() {
		stage = new Stage();
		spriteBatch = new SpriteBatch();
		randomPhoto = new RandomPhoto();
		
		gameScore = 750.0;
		
		timer = new Timer(this);
		timer.timerThread.start();
		
		font = new BitmapFont(Gdx.files.internal("data/fonts/ourFont.fnt"), false);
		font.setColor(Color.BLUE);
		widthForTime = font.getBounds("Timer: " + timer.gameTimer).width;
		
		Gdx.app.log("Screen", "Width: " + SCREEN_WIDTH);
		Gdx.app.log("Screen", "Height: " + SCREEN_HEIGHT);
		
		makeButtons();
		makeTables();
		
		Gdx.input.setInputProcessor(stage);
		
		pic01_catNum = randomPhoto.randomPic("cat");
		pic02_catNum = randomPhoto.randomPic("cat");
		pic01_num    = randomPhoto.randomPic("pic");
		pic02_num    = randomPhoto.randomPic("pic");
		
	}
	
	
	public void render() {
		

		stage.draw();
		
		spriteBatch.begin();
		font.draw(spriteBatch, randomWord, SCREEN_WIDTH/2 - font.getBounds(randomWord).width, SCREEN_HEIGHT/2);
		font.draw(spriteBatch, "Time: " + timer.getTimer(), SCREEN_WIDTH - widthForTime, .99f * SCREEN_HEIGHT);
		font.draw(spriteBatch, "Points: " + this.gameScore, .01f * SCREEN_WIDTH, .99f * SCREEN_HEIGHT);
		font.draw(spriteBatch, "Total Score: " + totalScore, .45f * SCREEN_WIDTH, .55f * SCREEN_HEIGHT);
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
		TextureAtlas pic_one_atlas = new TextureAtlas(Gdx.files.internal("data/photo/cat" + Integer.toString(pic01_catNum) + ".pack"));
		TextureAtlas pic_two_atlas = new TextureAtlas(Gdx.files.internal("data/photo/cat" + Integer.toString(pic02_catNum) + ".pack"));
		ImageButtonStyle style_1 = new ImageButtonStyle();
		ImageButtonStyle style_2 = new ImageButtonStyle();
		
		Skin skin = new Skin();
		skin.add("image_1", new Sprite(pic_one_atlas.createSprite("pic" + Integer.toString(pic01_num))));
		skin.add("image_2", new Sprite(pic_two_atlas.createSprite("pic" + Integer.toString(pic02_num))));
		
		style_1.imageUp = skin.newDrawable("image_1");
		style_2.imageUp = skin.newDrawable("image_2");
		picture_One = new ImageButton(style_1);
		picture_Two = new ImageButton(style_2);
		
		picture_One.setName("Image_1");
		picture_Two.setName("Image_2");
		
		picture_One.addListener(new ButtonListener(this, picture_One, timer, true));
		picture_Two.addListener(new ButtonListener(this, picture_Two, timer, false));
		
	}
	
	public void makeWord() {
		int rand = MathUtils.random(9);
		ObjectMap<String, Array<String>> dict;
		Array<String> randomWordArray;
		if(rand < 5){
			dict = dictionary.getDictionary(pic01_catNum);
		}else{
			dict = dictionary.getDictionary(pic02_catNum);
		}
		
		int randomWordNum = MathUtils.random(1);
		if(randomWordNum < 9){
			randomWordArray = dict.get("pic0" + Integer.toString(randomWordNum));	
		}else{
			randomWordArray = dict.get("pic" + Integer.toString(randomWordNum));	
		}
		
		this.randomWord = randomWordArray.get(MathUtils.random(2));
		
	}

}
