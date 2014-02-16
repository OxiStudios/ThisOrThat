package com.OxiStudios.ThisOrThat.Game;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;

public class RandomPhoto {
	
	
	
	public RandomPhoto() {
		
	}
	
	public int randomPic() {
		return MathUtils.random(49);
	}
}
