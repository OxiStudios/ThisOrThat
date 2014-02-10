package com.OxiStudios.ThisOrThat;

import java.util.HashMap;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;

public class Dictionary {
	
	ObjectMap<String, Array<String>> cat01, cat02;
	Array<String> cat01_pic01, cat01_pic02, cat01_pic03;
	
	public Dictionary() {
		cat01 = new ObjectMap<String, Array<String>>();
		cat02 = new ObjectMap<String, Array<String>>();
		
		cat01_pic02 = new Array<String>();
		cat01_pic02.add("bread");
		
		cat01_pic01 = new Array<String>();
		cat01_pic01.add("Gummy Bears");
		
		cat01.put("pic01", cat01_pic01);
		cat01.put("pic02", cat01_pic02);
		
	}
	
	public ObjectMap<String, Array<String>> getDictionary(int cat) {
		switch(cat) {
			case 01:
				return cat01;
			case 02:
				return cat02;
			default:
				return cat01;
		
		}
	}
	

}
