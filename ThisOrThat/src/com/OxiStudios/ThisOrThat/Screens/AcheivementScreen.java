package com.OxiStudios.ThisOrThat.Screens;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.badlogic.gdx.Screen;

public class AcheivementScreen implements Screen {

	private ThisOrThatGame game;
	public AcheivementScreen(ThisOrThatGame game) {
		this.game = game;
		// TODO Auto-generated constructor stub
	}
	public boolean level_1_goal() {
		if(game.savefile.xp_made >= 10000) {
			game.savefile.level_1_reached = true;
		} else {
			game.savefile.level_1_reached = false;
		}
		return game.savefile.level_1_reached;
	}
	public boolean level_2_goal() {
		if(game.savefile.xp_made >= 20000) {
			game.savefile.level_2_reached = true;
		} else {
			game.savefile.level_2_reached = false;
		}
		return game.savefile.level_2_reached;
	}
	public boolean level_3_goal() {
		if(game.savefile.xp_made >= 40000) {
			game.savefile.level_3_reached = true;
		} else {
			game.savefile.level_3_reached = false;
		}
		return game.savefile.level_3_reached;
	}
	public boolean level_4_goal() {
		if(game.savefile.xp_made >= 70000) {
			game.savefile.level_4_reached = true;
		} else {
			game.savefile.level_4_reached = false;
		}
		return game.savefile.level_4_reached;
	}
	public boolean level_5_goal() {
		if(game.savefile.xp_made >= 110000) {
			game.savefile.level_5_reached = true;
		} else {
			game.savefile.level_5_reached = false;
		}
		return game.savefile.level_5_reached;
	}
	public boolean level_6_goal() {
		if(game.savefile.xp_made >= 160000) {
			game.savefile.level_6_reached = true;
		} else {
			game.savefile.level_6_reached = false;
		}
		return game.savefile.level_6_reached;
	}
	public boolean level_7_goal() {
		if(game.savefile.xp_made >= 220000) {
			game.savefile.level_7_reached = true;
		} else {
			game.savefile.level_7_reached = false;
		}
		return game.savefile.level_7_reached;
	}
	public boolean level_8_goal() {
		if(game.savefile.xp_made >= 290000) {
			game.savefile.level_8_reached = true;
		} else {
			game.savefile.level_8_reached = false;
		}
		return game.savefile.level_8_reached;
	}
	public boolean level_9_goal() {
		if(game.savefile.xp_made >= 370000) {
			game.savefile.level_9_reached = true;
		} else {
			game.savefile.level_9_reached = false;
		}
		return game.savefile.level_9_reached;
	}
	public boolean level_10_goal() {
		if(game.savefile.xp_made >= 460000) {
			game.savefile.level_10_reached = true;
		} else {
			game.savefile.level_10_reached = false;
		}
		return game.savefile.level_10_reached;
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
