package com.OxiStudios.ThisOrThat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class SaveFile {

	// highest score, done
	public float highScore;

	// amount of time played in the game in seconds, done
	public float playTime;

	// highest amount that the player got in a row, done
	public float inARow;

	// closest time to 2 seconds it took them to respond
	public float fastestReponse;

	// closest time to losing
	public float closestTime;

	// longest game they have played, done
	public float longestGame;

	// total amount of games played, done
	public float gamesPlayed;
	// levels
	public float levelUp;
	// Level XP total
	public int xp_made = 0;
	public int level_1 = 10000;
	public int level_2 = 20000;
	public int level_3 = 40000;
	public int level_4 = 70000;
	public int level_5 = 110000;
	public int level_6 = 160000;
	public int level_7 = 220000;
	public int level_8 = 290000;
	public int level_9 = 370000;
	public int level_10 = 460000;

	public boolean level_1_reached;
	public boolean level_2_reached;
	public boolean level_3_reached;
	public boolean level_4_reached;
	public boolean level_5_reached;
	public boolean level_6_reached;
	public boolean level_7_reached;
	public boolean level_8_reached;
	public boolean level_9_reached;
	public boolean level_10_reached;

	FileHandle file;

	String readFile;

	String[] strings;

	public SaveFile() {
		load();
	}

	private void load() {

		if (!Gdx.files.local("save.save").exists()) {
			file = Gdx.files.local("save.save");
		} else {
			file = Gdx.files.local("save.save");
			readFile = file.readString();
			strings = readFile.split(",");

			gamesPlayed = Float.parseFloat(strings[0]);
			longestGame = Float.parseFloat(strings[1]);
			closestTime = Float.parseFloat(strings[2]);
			fastestReponse = Float.parseFloat(strings[3]);
			inARow = Float.parseFloat(strings[4]);
			playTime = Float.parseFloat(strings[5]);
			highScore = Float.parseFloat(strings[6]);
			levelUp = Float.parseFloat(strings[7]);
		}

	}

	public void save() {
		// save the game files
		file.writeString(Float.toString(gamesPlayed) + ",", false);
		file.writeString(Float.toString(longestGame) + ",", true);
		file.writeString(Float.toString(closestTime) + ",", true);
		file.writeString(Float.toString(fastestReponse) + ",", true);
		file.writeString(Float.toString(inARow) + ",", true);
		file.writeString(Float.toString(playTime) + ",", true);
		file.writeString(Float.toString(highScore) + ",", true);
		file.writeString(Float.toString(levelUp) + ",", true);

		Gdx.app.log("save", "file has been saved");

	}

	public int getLevel(int xp_made) {
		if (xp_made < level_1) {
			return 0;
		} else if (xp_made < level_2) {
			return 1;
		} else if (xp_made < level_3) {
			return 2;
		} else if (xp_made < level_4) {
			return 3;
		} else if (xp_made < level_5) {
			return 4;
		} else if (xp_made < level_6) {
			return 5;
		} else if (xp_made < level_7) {
			return 6;
		} else if (xp_made < level_8) {
			return 7;
		} else if (xp_made < level_9) {
			return 8;
		} else if (xp_made < level_10) {
			return 9;
		} else {
			return 10;
		}
	}

}
