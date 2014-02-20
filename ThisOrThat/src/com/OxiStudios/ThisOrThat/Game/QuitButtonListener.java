package com.OxiStudios.ThisOrThat.Game;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.Screens.MainMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.TimeUtils;

public class QuitButtonListener implements InputProcessor{
	
	private ThisOrThatGame game;
	private GameScene gameScene;

	public QuitButtonListener(ThisOrThatGame game, GameScene gameScene) {
		this.game  = game;
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
				Gdx.app.log("x", "clicked in correct x area");
				if(screenY > (.5520f * game.SCREEN_HEIGHT) && screenY < (.6041f * game.SCREEN_HEIGHT)) {
					game.setScreen(new MainMenu(game));
					game.TotalScore = 0;
					gameScene.popUp = false;
					game.endGameTime = TimeUtils.nanoTime();
					game.savefile.playTime += (game.endGameTime - game.startGameTime);
					if(game.endGameTime - game.startGameTime > game.savefile.longestGame) {
						game.savefile.longestGame = (game.endGameTime - game.startGameTime);
					}
					Gdx.app.log("PlayTime: ", "" + game.savefile.playTime); 
					Gdx.app.log("Screen", "Quit button clicked");
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
