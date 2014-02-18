package com.OxiStudios.ThisOrThat.MainMenuButtonListeners;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.Game.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class PlayListener implements InputProcessor{
	
	private ThisOrThatGame game;

	public PlayListener(ThisOrThatGame game) {
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
		if(screenX > (.2759f * game.SCREEN_WIDTH) && screenX < ((.2759f * game.SCREEN_WIDTH) + (.4490 * game.SCREEN_WIDTH))) {
			Gdx.app.log("Test", "touch at correct x bounds");
			if(screenY > (.4860f * game.SCREEN_HEIGHT) && screenY < ((.4860f * game.SCREEN_HEIGHT) + (.0807 * game.SCREEN_HEIGHT))) {
				Gdx.app.log("Test", "touch at correct y bounds");
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
