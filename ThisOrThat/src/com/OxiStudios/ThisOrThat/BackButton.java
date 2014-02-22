package com.OxiStudios.ThisOrThat;

import com.OxiStudios.ThisOrThat.Screens.MainMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class BackButton implements InputProcessor{
	
	private ThisOrThatGame game;
	private boolean isMainMenu;

	public BackButton(ThisOrThatGame game) {
		this.game = game;
	}
	
	public void isMainMenu(boolean mainMenu){
		this.isMainMenu = mainMenu;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		if(keycode == Keys.BACK) {
			if(!isMainMenu) {
				game.setScreen(new MainMenu(game));
			}else {
				Gdx.app.exit();
			}
		}
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
