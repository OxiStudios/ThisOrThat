package com.OxiStudios.ThisOrThat.Game;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.Screens.MainMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class PopUpButtonListener implements InputProcessor{
	
	

	private ThisOrThatGame game;
	public PopUpButtonListener(ThisOrThatGame game) {
		this.game = game;
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
		if(screenX > (.3138f * game.SCREEN_WIDTH) && screenX < ((.3138f * game.SCREEN_WIDTH) + (.3722f * game.SCREEN_WIDTH))) {
			
			if(screenY > (.3958f * game.SCREEN_HEIGHT) && screenY < ((.0531f * game.SCREEN_HEIGHT) + (.3958f * game.SCREEN_HEIGHT))) {
				game.setScreen(new MainMenu(game));
				Gdx.app.log("Screen", "Quit button clicked");
			}else if(screenY > (.4796f * game.SCREEN_HEIGHT) && screenY < ((.0531f * game.SCREEN_HEIGHT) + (.4671f * game.SCREEN_HEIGHT))){
				Gdx.app.log("Screen", "Retry button clicked");
				game.TotalScore = 0;
				game.setScreen(new GameScreen(game));
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
