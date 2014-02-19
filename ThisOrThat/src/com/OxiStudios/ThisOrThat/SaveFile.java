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
	
	String[] strings;
	
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
			strings = readFile.split(",");
			
			gamesPlayed    = Float.parseFloat(strings[0]);
			longestGame    = Float.parseFloat(strings[1]);
			closestTime    = Float.parseFloat(strings[2]);
			fastestReponse = Float.parseFloat(strings[3]);
			inARow         = Float.parseFloat(strings[4]);
			playTime       = Float.parseFloat(strings[5]);
			highScore      = Float.parseFloat(strings[6]);
			
		}
	}
	
	public void save() {
		//save the game files
		file.writeString(Float.toString(gamesPlayed) + ",", false);
		file.writeString(Float.toString(longestGame) + ",", true);
		file.writeString(Float.toString(closestTime) + ",", true);
		file.writeString(Float.toString(fastestReponse) + ",", true);
		file.writeString(Float.toString(inARow) + ",", true);
		file.writeString(Float.toString(playTime) + ",", true);
		file.writeString(Float.toString(highScore) + ",", true);
		
		Gdx.app.log("save", "file has been saved");
		
	}

}
