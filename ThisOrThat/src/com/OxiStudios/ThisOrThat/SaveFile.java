package com.OxiStudios.ThisOrThat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class SaveFile {
	
	//highest score
	public float highScore;
	
	//amount of time played in the game in seconds
	public float playTime;
	
	//highest amount that the player got in a row
	public float inARow;
	
	//closest time to 2 seconds it took them to respond
	public float fastestReponse;
	
	//closest time to losing
	public float closestTime;
	
	//longest game they have played
	public float longestGame;
	
	//total amount of games played
	public float gamesPlayed;
	
	FileHandle file;
	
	String readFile;
	
	Array<Character> chars;
	
	public SaveFile() {
		load();
	}
	
	private void load() {
		if(!Gdx.files.external("ThisOrThat/save.save").exists()) {
			this.file = Gdx.files.external("ThisOrThat/save.save");
			save();
		}else{
			file = Gdx.files.external("ThisOrThat/save.save");
			readFile = file.readString();
			for(int i = 0; i < 10; ++i) {
				chars.add(readFile.subSequence(i, i).charAt(0));
			}
		}
	}
	
	public void save() {
		//save the game files
		file.writeString(Float.toString(gamesPlayed) + "\n", false);
		file.writeString(Float.toString(longestGame) + "\n", true);
		file.writeString(Float.toString(closestTime) + "\n", true);
		file.writeString(Float.toString(fastestReponse) + "\n", true);
	}

}
