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
	
	float SCREEN_WIDTH  = Gdx.graphics.getWidth();
	float SCREEN_HEIGHT = Gdx.graphics.getHeight();
	
	public TextureAtlas backgrounds;
	public Sprite background;
	
	public Timer timer;
	
	Stage stage;
	
	ImageButton picture_One, picture_Two;
	Table mainTable, pictureTableOne, pictureTableTwo, pointTable, wordTable, titleTable;
	private SpriteBatch spriteBatch;
	
	public double gameScore;
	
	RandomPhoto randomPhoto;
	
	BitmapFont font;
	float widthForTime;
	
	String randomWord;
	String picOne_Name;
	String picTwo_Name;
	
	int pic01_catNum;
	int pic02_catNum;
	int pic01_num;
	int pic02_num;
	
	Dictionary dictionary = new Dictionary();
	
	boolean oneIsRight;
	
	private ThisOrThatGame game;
	
	public GameScene(ThisOrThatGame game) {
		
		this.game = game;
		
		
		stage = new Stage();
		backgrounds = new TextureAtlas(Gdx.files.internal("data/backgrounds/backgrounds.pack"));
		background  = backgrounds.createSprite("bg0" + MathUtils.random(5) + 1);
		background.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		
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
		
		Gdx.input.setInputProcessor(stage);
		
		pic01_catNum = randomPhoto.randomPic("cat");
		pic02_catNum = randomPhoto.randomPic("cat");
		pic01_num    = randomPhoto.randomPic("pic");
		pic02_num    = randomPhoto.randomPic("pic");
		
		this.makeButtons();
		this.makeWord();
		this.makeTables();
	}
	
	
	public void render() {
		

		stage.draw();
		
		spriteBatch.begin();
		background.draw(spriteBatch);
		font.draw(spriteBatch, randomWord, SCREEN_WIDTH/2 - font.getBounds(randomWord).width, SCREEN_HEIGHT/2);
		font.draw(spriteBatch, "Time: " + timer.getTimer(), SCREEN_WIDTH - widthForTime, .99f * SCREEN_HEIGHT);
		font.draw(spriteBatch, "Points: " + this.gameScore, .01f * SCREEN_WIDTH, .99f * SCREEN_HEIGHT);
		font.draw(spriteBatch, "Total Score: " + game.TotalScore, .45f * SCREEN_WIDTH, .55f * SCREEN_HEIGHT);
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
		
		// grab two random categories
		TextureAtlas pic_one_atlas = new TextureAtlas(Gdx.files.internal("data/photo/cat" + Integer.toString(pic01_catNum) + ".pack"));
		TextureAtlas pic_two_atlas = new TextureAtlas(Gdx.files.internal("data/photo/cat" + Integer.toString(pic02_catNum) + ".pack"));
		
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
		Skin skin = new Skin();
		skin.add("image_1", pic_one_atlas.createSprite(picOne_Name));
		skin.add("image_2", pic_two_atlas.createSprite(picTwo_Name));
		
		//link the skins with the styles
		style_1.imageUp = skin.newDrawable("image_1");
		style_2.imageUp = skin.newDrawable("image_2");
		
		//make the buttons and link them with the styles
		picture_One = new ImageButton(style_1);
		picture_Two = new ImageButton(style_2);
		
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
			dict = dictionary.getDictionary(pic01_catNum);
			//this will then make the first pic correct
			oneIsRight = true;
		}else{
			//if rand is 5-9 get the dictionary that the second pic is in
			dict = dictionary.getDictionary(pic02_catNum);
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
				
				randomWordArray = dict.get("pic0" + Integer.toString(pic02_num));
			}else{
				
				randomWordArray = dict.get("pic" + Integer.toString(pic02_num));
			}
		}
		//get the random word from the array of words
		this.randomWord = randomWordArray.get(MathUtils.random(2));
		
	}

}
