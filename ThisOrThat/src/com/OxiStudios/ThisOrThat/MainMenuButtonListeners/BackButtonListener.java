package com.OxiStudios.ThisOrThat.MainMenuButtonListeners;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.Screens.MainMenu;
import com.badlogic.gdx.InputProcessor;

public class BackButtonListener implements InputProcessor{
	
	private ThisOrThatGame game;

	public BackButtonListener(ThisOrThatGame game) {
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
		// TODO Auto-generated method stub
		if(screenX > (.2731 * game.SCREEN_WIDTH) && screenX < (.7222 * game.SCREEN_WIDTH)) {
			if(screenY > (.8723f * game.SCREEN_HEIGHT) && screenY < (.9531f * game.SCREEN_HEIGHT)) {
				game.setScreen(new MainMenu(game));
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
