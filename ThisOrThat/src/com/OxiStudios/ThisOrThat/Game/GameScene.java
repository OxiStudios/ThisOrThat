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
		
		stage = new Stage();
		skin  = new Skin();
		
		background  = new Sprite(game.backgrounds.createSprite("bg06"));
		background.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
		
		spriteBatch = new SpriteBatch();
		randomPhoto = new RandomPhoto();
		
		gameScore = 750.0;
		
		timer = new Timer(game, this);
		
		widthForTime = game.font.getBounds(Double.toString(timer.gameTimer)).width;
		
		Gdx.app.log("Screen", "Width: " + game.SCREEN_WIDTH);
		Gdx.app.log("Screen", "Height: " + game.SCREEN_HEIGHT);
		
		Gdx.input.setInputProcessor(stage);
		
		pic01_catNum = randomPhoto.randomPic();
		pic02_catNum = randomPhoto.randomPic();
		pic01_num    = randomPhoto.randomPic();
		pic02_num    = randomPhoto.randomPic();
	

		makeButtons();
		makeWord();
		makeTables();
		

		timer.timerThread.start();
	}
	
	
	public void render() {

		
		
		spriteBatch.begin();
		background.draw(spriteBatch);
		game.font.draw(spriteBatch, randomWord, game.SCREEN_WIDTH/2 - game.font.getBounds(randomWord).width/2, game.SCREEN_HEIGHT - .20f * game.SCREEN_HEIGHT);
		game.font.draw(spriteBatch, Double.toString(timer.getTimer()), game.SCREEN_WIDTH - widthForTime + 4, .975f * game.SCREEN_HEIGHT);
		game.font.draw(spriteBatch, Double.toString(this.gameScore), .01f * game.SCREEN_WIDTH, .99f * game.SCREEN_HEIGHT);
		game.font.draw(spriteBatch, Double.toString(game.TotalScore), .45f * game.SCREEN_WIDTH, .55f * game.SCREEN_HEIGHT);
		spriteBatch.end();
		
		stage.draw();
		stage.act();
		
		timer.render();
	}
	
	public void makeTables() {
		mainTable = new Table();
		mainTable.setFillParent(true);
		
		pictureTableOne = new Table();
		pictureTableTwo = new Table();
		
		pictureTableOne.add(picture_One);
		pictureTableTwo.add(picture_Two);
	
		mainTable.add(pictureTableOne).top().center().padTop(.18f * game.SCREEN_HEIGHT);
		mainTable.row();
		mainTable.add(pictureTableTwo).top().center().padTop(.0848f * game.SCREEN_HEIGHT);
		
		
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
		
		Sprite picOne_sprite = new Sprite(game.cat01.createSprite("pic" + Integer.toString(pic01_num)));
		Sprite picTwo_sprite = new Sprite(game.cat01.createSprite("pic" + Integer.toString(pic02_num)));
		picOne_sprite.setSize(.59f * game.SCREEN_WIDTH, .25f * game.SCREEN_HEIGHT);
		picTwo_sprite.setSize(.59f * game.SCREEN_WIDTH, .25f * game.SCREEN_HEIGHT);
		
		skin.add("image_1", picOne_sprite);
		skin.add("image_2", picTwo_sprite);
		
		//link the skins with the styles
		style_1.imageUp = skin.newDrawable("image_1");
		style_2.imageUp = skin.newDrawable("image_2");
		
		//make the buttons and link them with the styles
		picture_One = new ImageButton(style_1);
		picture_One.setSize(.59f * game.SCREEN_WIDTH, .25f * game.SCREEN_HEIGHT);
		
		picture_Two = new ImageButton(style_2);
		picture_Two.setSize(.59f * game.SCREEN_WIDTH, .25f * game.SCREEN_HEIGHT);
		
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
			//if the pic does not have a 0 in it: pic10 - pic99
			randomWordArray = dict.get("pic" + Integer.toString(pic01_num));
		}else{
			//second is correct so we need to get the a random word that matches pic two		
			randomWordArray = dict.get("cat01_" + "pic" + Integer.toString(pic02_num));
		}
		//get the random word from the array of words
		//this.randomWord = randomWordArray.get(MathUtils.random(2));
		this.randomWord = randomWordArray.get(0);
	}
	
	public void dispose() {
		stage.dispose();
		skin.dispose();
		spriteBatch.dispose();
	}

}
