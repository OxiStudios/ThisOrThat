package com.OxiStudios.ThisOrThat.Game;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;

public class RandomPhoto {
	
	
	
	public RandomPhoto() {
		
	}
	
	public void randomPic() {
		float randomSection = MathUtils.random(10);
		float randomPhoto   = MathUtils.random(100);
		
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
