package com.OxiStudios.ThisOrThat.Game;

import com.OxiStudios.ThisOrThat.Dictionary;
import com.OxiStudios.ThisOrThat.ThisOrThatGame;
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
	
	float SCREEN_WIDTH;
	float SCREEN_HEIGHT;
	
	public Sprite background;
	
	public Timer timer;
	
	Stage stage;
	Skin skin;
	
	ImageButton picture_One, picture_Two;
	Table mainTable, pictureTableOne, pictureTableTwo;
	private SpriteBatch spriteBatch;
	
	public double gameScore;
	
	RandomPhoto randomPhoto;
	
	float widthForTime;
	
	String randomWord;
	String picOne_Name;
	String picTwo_Name;
	
	int pic01_catNum;
	int pic02_catNum;
	int pic01_num;
	int pic02_num;
	
	boolean oneIsRight;
	private ThisOrThatGame game;
	
	public GameScene(ThisOrThatGame game) {
		
		this.game = game;
		SCREEN_HEIGHT = Gdx.graphics.getHeight();
		SCREEN_WIDTH  = Gdx.graphics.getWidth();
		
		stage = new Stage();
		skin  = new Skin();
		
		background  = new Sprite(game.backgrounds.createSprite("bg0" + Integer.toString(MathUtils.random(4) + 1)));
		background.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		
		spriteBatch = new SpriteBatch();
		randomPhoto = new RandomPhoto();
		
		gameScore = 750.0;
		
		timer = new Timer(this);
		
		widthForTime = game.font.getBounds(Double.toString(timer.gameTimer)).width;
		
		Gdx.app.log("Screen", "Width: " + SCREEN_WIDTH);
		Gdx.app.log("Screen", "Height: " + SCREEN_HEIGHT);
		
		Gdx.input.setInputProcessor(stage);
		
		pic01_catNum = randomPhoto.randomPic("cat");
		pic02_catNum = randomPhoto.randomPic("cat");
		pic01_num    = randomPhoto.randomPic("pic");
		pic02_num    = randomPhoto.randomPic("pic");
	

		makeButtons();
		makeWord();
		makeTables();
		

		timer.timerThread.start();
	}
	
	
	public void render() {

		
		
		spriteBatch.begin();
		background.draw(spriteBatch);
		game.font.draw(spriteBatch, randomWord, SCREEN_WIDTH/2 - game.font.getBounds(randomWord).width/2, SCREEN_HEIGHT - .20f * SCREEN_HEIGHT);
		game.font.draw(spriteBatch, Double.toString(timer.getTimer()), SCREEN_WIDTH - widthForTime + 4, .975f * SCREEN_HEIGHT);
		game.font.draw(spriteBatch, Double.toString(this.gameScore), .01f * SCREEN_WIDTH, .99f * SCREEN_HEIGHT);
		game.font.draw(spriteBatch, Double.toString(game.TotalScore), .45f * SCREEN_WIDTH, .55f * SCREEN_HEIGHT);
		spriteBatch.end();
		
		stage.draw();
		stage.act();
		Table.drawDebug(stage);
		
	}
	
	public void makeTables() {
		mainTable = new Table();
		mainTable.setFillParent(true);
		
		pictureTableOne = new Table();
		pictureTableTwo = new Table();
		
		pictureTableOne.add(picture_One);
		pictureTableTwo.add(picture_Two);
	
		mainTable.add(pictureTableOne).top().center().padTop(.18f * SCREEN_HEIGHT);
		mainTable.row();
		mainTable.add(pictureTableTwo).top().center().padTop(.0848f * SCREEN_HEIGHT);
		
		
		stage.addActor(mainTable);
	}
	
	public void makeButtons() {
		
		//make the styles for the buttons
		ImageButtonStyle style_1 = new ImageButtonStyle();
		ImageButtonStyle style_2 = new ImageButtonStyle();
		
		if(pic01_num < 10){
			picOne_Name = "pic0" + Integer.toString(pic01_num);
		}else{
			picOne_Name = "pic" + Integer.toString(pic01_num);
		}
		
		if(pic02_num < 10) {			
			picTwo_Name = "pic0" + Integer.toString(pic02_num);
		}else{
			picTwo_Name = "pic" + Integer.toString(pic02_num);
		}
		
		//make the skin for the buttons
		
		Sprite picOne_sprite = new Sprite(game.textureHandler.cat01.createSprite("pic25"));
		Sprite picTwo_sprite = new Sprite(game.textureHandler.cat01.createSprite("pic34"));
		picOne_sprite.setSize(.59f * SCREEN_WIDTH, .25f * SCREEN_HEIGHT);
		picTwo_sprite.setSize(.59f * SCREEN_WIDTH, .25f * SCREEN_HEIGHT);
		
		skin.add("image_1", picOne_sprite);
		skin.add("image_2", picTwo_sprite);
		
		//link the skins with the styles
		style_1.imageUp = skin.newDrawable("image_1");
		style_2.imageUp = skin.newDrawable("image_2");
		
		//make the buttons and link them with the styles
		picture_One = new ImageButton(style_1);
		picture_One.setSize(.59f * SCREEN_WIDTH, .25f * SCREEN_HEIGHT);
		
		picture_Two = new ImageButton(style_2);
		picture_Two.setSize(.59f * SCREEN_WIDTH, .25f * SCREEN_HEIGHT);
		
		//testing purposes
		picture_One.setName("image_1");
		picture_Two.setName("image_2");
		
		picture_One.addListener(new ButtonListener(game, this, picture_One, timer, oneIsRight));
		picture_Two.addListener(new ButtonListener(game, this, picture_Two, timer, !oneIsRight));
	}
	
	public void makeWord() {
		int rand = MathUtils.random(9);
		ObjectMap<String, Array<String>> dict;
		Array<String> randomWordArray;
		
		//get the dictionary for either the first pic or the second pic
		if(rand < 5){
			//if rand is 0-4 get the dictionary that the first pic is in
			dict = game.dictionary.getDictionary(pic01_catNum);
			//this will then make the first pic correct
			oneIsRight = true;
		}else{
			//if rand is 5-9 get the dictionary that the second pic is in
			dict = game.dictionary.getDictionary(pic02_catNum);
			//this will then make the second pic correct
			oneIsRight = false;
		}
		
		if(oneIsRight){
			
			//first is correct so we need to get the a random word that matches pic two
			if(pic01_num < 10){
				
				//if the pic has a 0 in it like pic00- pic09
				randomWordArray = dict.get("pic0" + Integer.toString(pic01_num));	
			}else{
				
				//if the pic does not have a 0 in it: pic10 - pic99
				randomWordArray = dict.get("pic" + Integer.toString(pic01_num));
			}
			
		}else{
			
			//second is correct so we need to get the a random word that matches pic two
			if(pic02_num < 10) {
				
				randomWordArray = dict.get("cat01_" + "pic0" + Integer.toString(pic02_num));
			}else{
				
				randomWordArray = dict.get("cat01_" + "pic" + Integer.toString(pic02_num));
			}
		}
		//get the random word from the array of words
		//this.randomWord = randomWordArray.get(MathUtils.random(2));
		this.randomWord = "test word";
	}
	
	public void dispose() {
		stage.dispose();
		skin.dispose();
		spriteBatch.dispose();
	}

}
