package com.OxiStudios.ThisOrThat.Game;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;

public class RandomPhoto {
	
	
	
	public RandomPhoto() {
		
	}
	
	public int randomPic(String which_one) {
		int randomCat = 1;
		int randomPhoto   = MathUtils.random(49);
		
		if(which_one == "cat") {
			return randomCat;
		}else{
			return randomPhoto;
		}
		
	}
	
	public ArrayList<Boolean> getCorrect() {
		float random = MathUtils.random(10);
		ArrayList<Boolean> booleans = new ArrayList<Boolean>();
		if(random < 6) {
			booleans.add(true);
			booleans.add(false);
		}else {
			booleans.add(false);
			booleans.add(true);
		}
		
		return booleans;
	}

}
