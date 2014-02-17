package com.OxiStudios.ThisOrThat.Game;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

public class PopUpButtonListener extends InputListener{
	
	

	private ThisOrThatGame game;
	private boolean menu;

	public PopUpButtonListener(ThisOrThatGame game, boolean menu) {
		this.game = game;
		this.menu = menu;
	}
	
	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
         
         return true;
	}

	public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
		
	}
	
}
