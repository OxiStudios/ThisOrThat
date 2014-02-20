package com.OxiStudios.ThisOrThat.Game;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;

public class GameScene {
	
	public Sprite background, correct, incorrect, popUpWindow, countDown, menu_sprite, retry_sprite;
	private InputMultiplexer inputHanlder;
	
	String[] thousands, millions;
	
	public Timer timer;
	
	Stage stage;
	Skin skin;
	
	ImageButton picture_One, picture_Two;
	Table mainTable, pictureTableOne, pictureTableTwo;
	private SpriteBatch spriteBatch;
	
	private RetryButtonListener retryButtonListener;
	private QuitButtonListener quitButtonListener;
	
	public double gameScore;
	
	Sound correctSound, wrongSound;
	
	RandomPhoto randomPhoto;
	
	float widthForTime;
	float getGamesPlayed;
	
	String randomWord;
	String picOne_Name;
	String picTwo_Name;
	
	int pic01_catNum;
	int pic02_catNum;
	int pic01_num;
	int pic02_num;
	int count;
	
	int	folderbuf1;
	int	folderbuf2;
	
	boolean oneIsRight;
	boolean gotItRight;
	boolean gotItWrong;
	boolean newScreen;
	boolean popUp;
	boolean startTimer;
	private ThisOrThatGame game;
	
	
	public GameScene(ThisOrThatGame game) {
		
		this.game = game;
		
		if(game.SCREEN_WIDTH >= 1080) {
			game.font.setScale(2.5f);
		}else if(game.SCREEN_WIDTH >= 720){
			game.font.setScale(2.5f * .6666f);
		}else if(game.SCREEN_WIDTH >= 360) {
			game.font.setScale(.3333f * 2.5f);
		}
		
		stage = new Stage();
		skin  = new Skin();
		
		background       = new Sprite(game.backgrounds.createSprite("background_game"));
		correct          = new Sprite(game.backgrounds.createSprite("background_game_greenarrows"));
		incorrect        = new Sprite(game.backgrounds.createSprite("background_game_redarrows"));
		popUpWindow      = new Sprite(game.popUp.createSprite("main"));
		
		popUpWindow.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
		background.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
		correct.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
		incorrect.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
		
		correctSound = Gdx.audio.newSound(Gdx.files.internal("data/sounds/correct.wav"));
		wrongSound   = Gdx.audio.newSound(Gdx.files.internal("data/sounds/loser.mp3"));
		
		spriteBatch = new SpriteBatch();
		randomPhoto = new RandomPhoto();
		
		gameScore = 750.0;
		
		timer = new Timer(game, this);
		
		widthForTime = game.font.getBounds(Double.toString(timer.gameTimer)).width;
		
		retryButtonListener  = new RetryButtonListener(game, this);
		quitButtonListener   = new QuitButtonListener(game, this);
		inputHanlder   = new InputMultiplexer();
		

		inputHanlder.addProcessor(quitButtonListener);
		inputHanlder.addProcessor(retryButtonListener);
		inputHanlder.addProcessor(stage);
		Gdx.input.setInputProcessor(inputHanlder);
		
		//stops from adding a lot of numbers to games played in the save file
		getGamesPlayed = 0;
		
		pic01_catNum = MathUtils.random(21) + 1;
		pic02_catNum = MathUtils.random(21) + 1;
		
		while(pic01_catNum == pic02_catNum) {
			pic02_catNum = MathUtils.random(21) + 1;
		}
		
		folderbuf1 = (20 * (pic01_catNum - 1)) + 50;			
		folderbuf2 = (20 * (pic02_catNum - 1)) + 50;
		
		pic01_num    = ((MathUtils.random(19)) + folderbuf1);
		pic02_num    = ((MathUtils.random(19)) + folderbuf2);			

		makeButtons();
		makeTables();
		
		gotItRight      = false;
		gotItWrong      = false;
		newScreen       = false;
		popUp           = false;
		startTimer      = true;
	}
	
	
	public void render() {
		
		if(startTimer) {
			timer.timerThread.start();
			startTimer = false;
		}
		
		spriteBatch.begin();
		background.draw(spriteBatch);
		
		if(newScreen){
			correctSound.play(1f);
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
			newScreen       = true;
		}
		
		if(gotItWrong) {
			incorrect.draw(spriteBatch);
			popUp = true;
			//check if they got a new highest right in a row
			if(game.gameScreenCount >= game.savefile.inARow) {
				game.savefile.inARow = game.gameScreenCount;
			}
			
			//check if they got a new highscore
			if(game.TotalScore >= game.savefile.highScore) {
				game.savefile.highScore = game.TotalScore;
			}
			
			//add one to total number of games played
			getGamesPlayed++;
			if(getGamesPlayed == 1){
				wrongSound.play(1f);
				game.savefile.gamesPlayed++;
			}
			
			//stats have been updated, save the file
			game.savefile.save();
			
		}
		
		game.font.draw(spriteBatch, randomWord, game.word_position.x - game.font.getBounds(randomWord).width/2, game.word_position.y);
		game.font.draw(spriteBatch, Double.toString(timer.getTimer()), game.timer_position.x - widthForTime, game.timer_position.y);
		game.font.draw(spriteBatch, Double.toString(this.gameScore), game.point_position.x, game.point_position.y);
		if(game.TotalScore >= 1000.0) {
			String string = Double.toString(game.TotalScore/1000.0);
			thousands = string.split("\\.");
			game.font.draw(spriteBatch, thousands[0] + "." + thousands[1].substring(0, 1) + "K", game.score_position.x, game.score_position.y);
		}else if(game.TotalScore >= 1000000.0) {
			String string = Double.toString(game.TotalScore/1000000.0);
			millions = string.split("\\.");
			game.font.draw(spriteBatch, millions[0] + "." + millions[1].substring(0, 2) + "M", game.score_position.x, game.score_position.y);
		}else{
			game.font.draw(spriteBatch, Double.toString(game.TotalScore), game.score_position.x, game.score_position.y);
		}
		
		spriteBatch.end();

		stage.draw();
		stage.act();
		
		spriteBatch.begin();
		
		if(popUp) {
			gotItWrong = false;
			
			try {
				this.timer.timerThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			popUpWindow.draw(spriteBatch);
			menu_sprite.draw(spriteBatch);
			retry_sprite.draw(spriteBatch);
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
		
		//make the skin for the buttons
		Gdx.app.log("picOne", "" + pic01_catNum + " Pic num: " + pic01_num);
		Gdx.app.log("picTwo", "" + pic02_catNum + " Pic num: " + pic02_num);
		Sprite picOne_sprite = new Sprite(game.pictures.get(pic01_catNum - 1).createSprite("pic" + Integer.toString(pic01_num)));
		Sprite picTwo_sprite = new Sprite(game.pictures.get(pic02_catNum - 1).createSprite("pic" + Integer.toString(pic02_num)));
		menu_sprite   = new Sprite(game.popUp.createSprite("quit"));
		retry_sprite  = new Sprite(game.popUp.createSprite("retry"));
		menu_sprite.setPosition(.3138f * game.SCREEN_WIDTH, .3958f * game.SCREEN_HEIGHT);
		retry_sprite.setPosition(.3138f * game.SCREEN_WIDTH, .4671f * game.SCREEN_HEIGHT);
		
		menu_sprite.setSize(.3722f * game.SCREEN_WIDTH, .0531f * game.SCREEN_HEIGHT);
		retry_sprite.setSize(menu_sprite.getWidth(), menu_sprite.getHeight());
		picOne_sprite.setSize(.59f * game.SCREEN_WIDTH, .25f * game.SCREEN_HEIGHT);
		picTwo_sprite.setSize(.59f * game.SCREEN_WIDTH, .25f * game.SCREEN_HEIGHT);
		
		
		skin.add("image_1", picOne_sprite);
		skin.add("image_2", picTwo_sprite);
		
		//make the buttons and link them with the styles
		picture_One = new ImageButton(skin.newDrawable("image_1"));
		picture_One.setSize(.59f * game.SCREEN_WIDTH, .25f * game.SCREEN_HEIGHT);
		
		picture_Two = new ImageButton(skin.newDrawable("image_2"));
		picture_Two.setSize(.59f * game.SCREEN_WIDTH, .25f * game.SCREEN_HEIGHT);
		
		//testing purposes
		picture_One.setName("image_1");
		picture_Two.setName("image_2");
		
		int rand = MathUtils.random(9);
		ObjectMap<String, String> dict = game.dictionary.getDictionary(1);
		
		//get the dictionary for either the first pic or the second pic
		if(rand < 5){
			//if rand is 0-4 get the dictionary that the first pic is in
			//this will then make the first pic correct
			oneIsRight = true;
		}else{
			//if rand is 5-9 get the dictionary that the second pic is in
			//this will then make the second pic correct
			oneIsRight = false;
		}
		
		if(oneIsRight){
			this.randomWord = dict.get("pic" + Integer.toString(pic01_num));
			Gdx.app.log("word", dict.get("pic" + Integer.toString(pic01_num)));
		}else{
			//second is correct so we need to get the a random word that matches pic two
			Gdx.app.log("word", dict.get("pic" + Integer.toString(pic02_num)));
			this.randomWord = dict.get("pic" + Integer.toString(pic02_num));
		}
		
		picture_One.addListener(new ButtonListener(game, this, picture_One, timer, oneIsRight));
		picture_Two.addListener(new ButtonListener(game, this, picture_Two, timer, !oneIsRight));
	}
	
	public void dispose() {
		stage.dispose();
		skin.dispose();
		spriteBatch.dispose();
		correctSound.dispose();
		wrongSound.dispose();
	}

}
