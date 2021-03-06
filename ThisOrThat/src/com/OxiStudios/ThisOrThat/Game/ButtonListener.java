package com.OxiStudios.ThisOrThat.Game;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

public class ButtonListener extends InputListener{
	
	private ImageButton imageButton;
	private Timer timer;
	private boolean isCorrect;
	private GameScene gameScene;
	private boolean hasBeenClicked;
	private ThisOrThatGame game;

	public ButtonListener(ThisOrThatGame game, GameScene gameScene, ImageButton imageButton, Timer timer, boolean isCorrect) {
		this.game        = game;
		this.gameScene   = gameScene;
		this.imageButton = imageButton;
		this.timer       = timer;
		this.isCorrect   = isCorrect;
		hasBeenClicked   = false;
	}
	
	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
         Gdx.app.log("ImageButton", "Button:" + imageButton.getName());
         if(timer.gameTimer > 0 && isCorrect && !hasBeenClicked && !gameScene.notTouchable) {
        	 
        	 //the player got it right!
        	 game.random.QueueNext();
        	 gameScene.gotItRight = true;
        	 game.TotalScore += gameScene.gameScore;
        	 
         }else if(timer.gameTimer > 0 && !isCorrect && !hasBeenClicked) {
        	 
        	 //the player got it wrong :(
        	 gameScene.gotItWrong = true;
        	 //set Popup window.
         }
         return true;
	}

	public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
         Gdx.app.log("Example", "touch done at (" + x + ", " + y + ")");
         hasBeenClicked = true;
	}

}
