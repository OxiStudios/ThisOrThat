package com.OxiStudios.ThisOrThat.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

public class ButtonListener extends InputListener{
	
	private ImageButton imageButton;
	private Timer timer;
	private boolean isCorrect;
	private GameScene game;
	private boolean hasBeenClicked;

	public ButtonListener(GameScene game, ImageButton imageButton, Timer timer, boolean isCorrect) {
		this.game        = game;
		this.imageButton = imageButton;
		this.timer       = timer;
		this.isCorrect   = isCorrect;
		hasBeenClicked   = false;
	}
	
	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
         Gdx.app.log("ImageButton", "Button:" + imageButton.getName());
         if(timer.gameTimer > 0 && isCorrect && !hasBeenClicked) {
        	 game.totalScore += game.gameScore;
         }
         return true;
	}

	public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
         Gdx.app.log("Example", "touch done at (" + x + ", " + y + ")");
         hasBeenClicked = true;
	}

}
