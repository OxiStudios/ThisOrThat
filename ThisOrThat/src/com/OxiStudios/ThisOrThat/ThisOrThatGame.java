package com.OxiStudios.ThisOrThat;

import com.OxiStudios.ThisOrThat.Screens.loadScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class ThisOrThatGame extends Game {
	
	@Override
	public void create() {
		
		setScreen(new loadScreen(this));
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
