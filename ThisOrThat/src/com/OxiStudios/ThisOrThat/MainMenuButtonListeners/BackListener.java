package com.OxiStudios.ThisOrThat.MainMenuButtonListeners;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.OxiStudios.ThisOrThat.Screens.MainMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class BackListener extends InputListener{
		
	private ThisOrThatGame game;
	
	public BackListener(ThisOrThatGame game) {
		this.game = game;
	}
	
	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
		Gdx.app.log("Back", "back button clicked");
		game.setScreen(new MainMenu(game));
		return true;
	}
	
	public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
		
	}

}
