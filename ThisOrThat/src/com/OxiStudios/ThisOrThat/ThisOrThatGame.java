package com.OxiStudios.ThisOrThat;

import com.OxiStudios.ThisOrThat.Game.GameScreen;
import com.OxiStudios.ThisOrThat.Screens.loadScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class ThisOrThatGame extends Game {
	
	public int TotalScore;
	
	@Override
	public void create() {
		TotalScore = 0;
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
