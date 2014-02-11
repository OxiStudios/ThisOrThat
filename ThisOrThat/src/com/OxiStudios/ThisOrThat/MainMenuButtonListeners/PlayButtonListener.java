package com.OxiStudios.ThisOrThat.MainMenuButtonListeners;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.Game.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class PlayButtonListener extends InputListener{
	
	private ThisOrThatGame game;

	public PlayButtonListener(ThisOrThatGame game) {
		this.game = game;
	}
	
	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
		game.setScreen(new GameScreen(game));
		Gdx.app.log("Play", "Play button clicked");
        return true;
	}

	public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
		
	}
}
