package com.OxiStudios.ThisOrThat.Game;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;

public class GameScene {
	
	public Sprite background, correct, incorrect, popUpWindow, countDown;
	
	public Timer timer;
	
	Stage stage;
	Skin skin;
	
	ImageButton picture_One, picture_Two, popUpRetryButton, popUpMenuButton;
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
	int count;
	
	boolean oneIsRight;
	boolean gotItRight;
	boolean gotItWrong;
	boolean newScreen;
	boolean popUp;
	boolean countDownBoolean;
	boolean startTimer;
	private ThisOrThatGame game;
	
	public GameScene(ThisOrThatGame game) {
		
		this.game = game;
		
		if(game.SCREEN_WIDTH >= 1080) {
			game.font.setScale(2.5f);
		}else{
			game.font.setScale(.9f);
		}
		
		stage = new Stage();
		skin  = new Skin();
		
		if(game.gameScreenCount == 0) {
			countDownBoolean = true;
		}else{
			countDownBoolean = false;
		}
		background       = new Sprite(game.backgrounds.createSprite("background_game"));
		correct          = new Sprite(game.backgrounds.createSprite("background_game_greenarrows"));
		incorrect        = new Sprite(game.backgrounds.createSprite("background_game_redarrows"));
		popUpWindow      = new Sprite(game.popUp.createSprite("main"));
		countDown        = new Sprite(game.getReady.createSprite("getready"));
		
		countDown.setPosition(0, 0);
		countDown.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
		popUpWindow.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
		background.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
		correct.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
		incorrect.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
		
		spriteBatch = new SpriteBatch();
		randomPhoto = new RandomPhoto();
		
		gameScore = 750.0;
		
		timer = new Timer(game, this);
		
		widthForTime = game.font.getBounds(Double.toString(timer.gameTimer)).width;
		
		Gdx.app.log("Screen", "Width: " + game.SCREEN_WIDTH);
		Gdx.app.log("Screen", "Height: " + game.SCREEN_HEIGHT);
		
		Gdx.input.setInputProcessor(stage);
		
		pic01_catNum = 1;
		pic02_catNum = 1;
		
		pic01_num    = randomPhoto.randomPic();
		pic02_num    = randomPhoto.randomPic();
		
		count        = 3;
		
		while(pic01_num == pic02_num) {
			pic02_num    = randomPhoto.randomPic();
		}

		makeButtons();
		makeTables();
		
		gotItRight = false;
		gotItWrong = false;
		newScreen  = false;
		popUp      = false;
		startTimer = true;
	}
	
	
	public void render() {
		
		spriteBatch.begin();
		background.draw(spriteBatch);
		
		if(newScreen){
			
			try {
				Thread.sleep(500);
				//reset the game 
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			game.gameScreenCount++;
			game.setScreen(new GameScreen(game));
		}
		
		
		if(gotItRight) {
			correct.draw(spriteBatch);
			newScreen = true;
		}
		
		if(gotItWrong) {
			incorrect.draw(spriteBatch);
			popUp = true;
		}
		
		game.font.draw(spriteBatch, randomWord, game.word_position.x - game.font.getBounds(randomWord).width/2, game.word_position.y);
		game.font.draw(spriteBatch, Double.toString(timer.getTimer()), game.timer_position.x - widthForTime, game.timer_position.y);
		game.font.draw(spriteBatch, Double.toString(this.gameScore), game.point_position.x, game.point_position.y);
		game.font.draw(spriteBatch, Double.toString(game.TotalScore), game.score_position.x, game.score_position.y);
		
		spriteBatch.end();

		stage.draw();
		stage.act();
		
		spriteBatch.begin();
		
		if(popUp) {
			try {
				this.timer.timerThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			popUpWindow.draw(spriteBatch);
		}
		
		if(countDownBoolean) {
			Gdx.app.log("countDown", "count down is drawning");
			countDown.draw(spriteBatch);
			try {
				Thread.sleep(1000);
				count--;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count < 2) {
				countDownBoolean = false;
			}
		}else if(startTimer) {
			timer.timerThread.start();
			startTimer = false;
		}
		
		spriteBatch.end();
		
		
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
			Gdx.app.log("One", "One is right");
			randomWordArray = dict.get("pic" + Integer.toString(pic01_num));
		}else{
			//second is correct so we need to get the a random word that matches pic two
			Gdx.app.log("Two", "Two is right");
			randomWordArray = dict.get("pic" + Integer.toString(pic02_num));
		}
		//get the random word from the array of words
		//this.randomWord = randomWordArray.get(MathUtils.random(2));
		this.randomWord = randomWordArray.get(0);
		
		picture_One.addListener(new ButtonListener(game, this, picture_One, timer, oneIsRight));
		picture_Two.addListener(new ButtonListener(game, this, picture_Two, timer, !oneIsRight));
	}
	
	public void dispose() {
		stage.dispose();
		skin.dispose();
		spriteBatch.dispose();
	}

}
