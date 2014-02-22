package com.OxiStudios.ThisOrThat.Game;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.Screens.MainMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class RetryButtonListener implements InputProcessor{
	
	

	private ThisOrThatGame game;
	private GameScene gameScene;
	public RetryButtonListener(ThisOrThatGame game, GameScene gameScene) {
		this.game = game;
		this.gameScene = gameScene;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(gameScene.popUp) {
			if(screenX > (.3138f * game.SCREEN_WIDTH) && screenX < ((.3138f * game.SCREEN_WIDTH) + (.3722f * game.SCREEN_WIDTH))) {
				if(screenY > (.4791f * game.SCREEN_HEIGHT) && screenY < (.5312f * game.SCREEN_HEIGHT)){
					Gdx.app.log("Screen", "Retry button clicked");
					game.TotalScore = 0;
					//stats have been updated, save the file
					game.savefile.save();
					game.random.QueueNext();
					game.setScreen(new GameScreen(game));
				}
				
			}
			
		}
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
