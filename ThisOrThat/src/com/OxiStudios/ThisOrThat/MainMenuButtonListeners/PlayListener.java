package com.OxiStudios.ThisOrThat.MainMenuButtonListeners;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.Game.GameScreen;
import com.OxiStudios.ThisOrThat.Screens.GetReadyScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.TimeUtils;

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
		Gdx.app.log("point", "X: " + screenX + " Y: " + screenY);
		Gdx.app.log("position", "" + .3255f * game.SCREEN_HEIGHT);
		if(screenX > (.2759f * game.SCREEN_WIDTH) && screenX < ((.2759f * game.SCREEN_WIDTH) + (.4490 * game.SCREEN_WIDTH))) {
			if(screenY > (.5921f * game.SCREEN_HEIGHT) && screenY < (.6734f * game.SCREEN_HEIGHT)) {
				game.setScreen(new GetReadyScreen(game, true));
				game.startGameTime = TimeUtils.nanoTime();
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
