package com.OxiStudios.ThisOrThat.Game;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;

public class RandomPhoto {
	
	int pic01_num;
	int pic02_num;

	Sprite ready_1;
	Sprite ready_2;

	boolean oneIsRight_ready;
	private ThisOrThatGame game;
	
	String location = "data/photo/pic";
	
	String randomWord;

	public RandomPhoto(ThisOrThatGame game) {
		
		this.game = game;

		QueueNext();

	}

	// gets called for queue pictures
	private void randomPic() {
		
		pic01_num = MathUtils.random(499) + 1;
		pic02_num = MathUtils.random(499) + 1;

		while (pic01_num == pic02_num) {
			pic02_num = MathUtils.random(499) + 1;
		}

	}

	public Sprite getPic1() {
		return ready_1;
	}

	public Sprite getPic2() {
		return ready_2;
	}

	public void QueueNext() {
		
		randomPic();
		
		//set queued sprites to the ready sprites 
		ready_1 = new Sprite(new Texture(Gdx.files.internal(location + pic01_num + ".jpg")));
		ready_2 = new Sprite(new Texture(Gdx.files.internal(location + pic02_num + ".jpg")));
		
		int rand = MathUtils.random(9);
		ObjectMap<String, String> dict = game.dictionary.getDictionary(1);

		// get the dictionary for either the first pic or the second pic
		if (rand < 5) {
			// if rand is 0-4 get the dictionary that the first pic is in
			// this will then make the first pic correct
			oneIsRight_ready = true;
		} else {
			// if rand is 5-9 get the dictionary that the second pic is in
			// this will then make the second pic correct
			oneIsRight_ready = false;
		}

		if (oneIsRight_ready) {
			randomWord = dict.get("pic" + Integer.toString(pic01_num));
		} else {
			// second is correct so we need to get the a random word that
			// matches pic two
			randomWord = dict.get("pic" + Integer.toString(pic02_num));
		}

	}

	public String getWord() {
		return randomWord;
	}

	public boolean getCorrect() {
		return oneIsRight_ready;
	}
}
