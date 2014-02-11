package com.OxiStudios.ThisOrThat;

import java.util.HashMap;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;

public class Dictionary {

	ObjectMap<String, Array<String>> cat01, cat02;
	Array<String> cat01_pic00, cat01_pic01, cat01_pic02, cat01_pic03, cat01_pic04,
			cat01_pic05, cat01_pic06, cat01_pic07, cat01_pic08, cat01_pic09,
			cat01_pic10, cat01_pic11, cat01_pic12, cat01_pic13, cat01_pic14,
			cat01_pic15, cat01_pic16, cat01_pic17, cat01_pic18, cat01_pic19,
			cat01_pic20, cat01_pic21, cat01_pic22, cat01_pic23, cat01_pic24,
			cat01_pic25, cat01_pic26, cat01_pic27, cat01_pic28, cat01_pic29,
			cat01_pic30, cat01_pic31, cat01_pic32, cat01_pic33, cat01_pic34,
			cat01_pic35, cat01_pic36, cat01_pic37, cat01_pic38, cat01_pic39,
			cat01_pic40, cat01_pic41, cat01_pic42, cat01_pic43, cat01_pic44,
			cat01_pic45, cat01_pic46, cat01_pic47, cat01_pic48, cat01_pic49,
			cat01_pic50, cat01_pic51, cat01_pic52, cat01_pic53, cat01_pic54,
			cat01_pic55, cat01_pic56, cat01_pic57, cat01_pic58, cat01_pic59,
			cat01_pic60, cat01_pic61, cat01_pic62, cat01_pic63, cat01_pic64,
			cat01_pic65, cat01_pic66, cat01_pic67, cat01_pic68, cat01_pic69,
			cat01_pic70, cat01_pic71, cat01_pic72, cat01_pic73, cat01_pic74,
			cat01_pic75, cat01_pic76, cat01_pic77, cat01_pic78, cat01_pic79,
			cat01_pic80, cat01_pic81, cat01_pic82, cat01_pic83, cat01_pic84,
			cat01_pic85, cat01_pic86, cat01_pic87, cat01_pic88, cat01_pic89,
			cat01_pic90, cat01_pic91, cat01_pic92, cat01_pic93, cat01_pic94,
			cat01_pic95, cat01_pic96, cat01_pic97, cat01_pic98, cat01_pic99,
			cat01_pic100;

	public Dictionary() {

		cat01();
		cat02();
	}

	public ObjectMap<String, Array<String>> getDictionary(int cat) {
		switch (cat) {
		case 01:
			return cat01;
		case 02:
			return cat02;
		default:
			return cat01;

		}
	}

	private void cat01() {
		cat01 = new ObjectMap<String, Array<String>>();
		
		cat01_pic00 = new Array<String>();
		cat01_pic00.add("Raw Asparagus");

		cat01_pic01 = new Array<String>();
		cat01_pic01.add("Cooked Asparagus");

		cat01_pic02 = new Array<String>();
		cat01_pic02.add("");

		cat01_pic03 = new Array<String>();
		cat01_pic03.add("Blueberries");

		cat01_pic04 = new Array<String>();
		cat01_pic04.add("");

		cat01_pic05 = new Array<String>();
		cat01_pic05.add("Loaf of Bread");

		cat01_pic06 = new Array<String>();
		cat01_pic06.add("");

		cat01_pic07 = new Array<String>();
		cat01_pic07.add("Tomatoes");

		cat01_pic08 = new Array<String>();
		cat01_pic08.add("");

		cat01_pic09 = new Array<String>();
		cat01_pic09.add("");

		cat01_pic10 = new Array<String>();
		cat01_pic10.add("French Fries");

		cat01_pic11 = new Array<String>();
		cat01_pic11.add("Cup of Coffee");

		cat01_pic12 = new Array<String>();
		cat01_pic12.add("");

		cat01_pic13 = new Array<String>();
		cat01_pic13.add("");

		cat01_pic14 = new Array<String>();
		cat01_pic14.add("");

		cat01_pic15 = new Array<String>();
		cat01_pic15.add("Guacamole");

		cat01_pic16 = new Array<String>();
		cat01_pic16.add("");

		cat01_pic17 = new Array<String>();
		cat01_pic17.add("");

		cat01_pic18 = new Array<String>();
		cat01_pic18.add("");

		cat01_pic19 = new Array<String>();
		cat01_pic19.add("Kidney Beans");

		cat01_pic20 = new Array<String>();
		cat01_pic20.add("Kiwi");

		cat01_pic21 = new Array<String>();
		cat01_pic21.add("Nachos");

		cat01_pic22 = new Array<String>();
		cat01_pic22.add("Noodles");

		cat01_pic23 = new Array<String>();
		cat01_pic23.add("Flowers");

		cat01_pic24 = new Array<String>();
		cat01_pic24.add("Salad");

		cat01_pic25 = new Array<String>();
		cat01_pic25.add("Noodle Bowl");

		cat01_pic26 = new Array<String>();
		cat01_pic26.add("");

		cat01_pic27 = new Array<String>();
		cat01_pic27.add("Corn");

		cat01_pic28 = new Array<String>();
		cat01_pic28.add("Cooked Onions");

		cat01_pic29 = new Array<String>();
		cat01_pic29.add("Salmon");

		cat01_pic30 = new Array<String>();
		cat01_pic30.add("Swiss Cheese");

		cat01_pic31 = new Array<String>();
		cat01_pic31.add("Gummy Bears");

		cat01_pic32 = new Array<String>();
		cat01_pic32.add("");

		cat01_pic33 = new Array<String>();
		cat01_pic33.add("");

		cat01_pic34 = new Array<String>();
		cat01_pic34.add("Apples");

		cat01_pic35 = new Array<String>();
		cat01_pic35.add("");

		cat01_pic36 = new Array<String>();
		cat01_pic36.add("Hot Dog");

		cat01_pic37 = new Array<String>();
		cat01_pic37.add("Pear");

		cat01_pic38 = new Array<String>();
		cat01_pic38.add("Strawberries");

		cat01_pic39 = new Array<String>();
		cat01_pic39.add("Maple Syrup");

		cat01_pic40 = new Array<String>();
		cat01_pic40.add("");

		cat01_pic41 = new Array<String>();
		cat01_pic41.add("");

		cat01_pic42 = new Array<String>();
		cat01_pic42.add("Grapefruit");

		cat01_pic43 = new Array<String>();
		cat01_pic43.add("");

		cat01_pic44 = new Array<String>();
		cat01_pic44.add("Carrot Shreds");

		cat01_pic45 = new Array<String>();
		cat01_pic45.add("Sugar Cubes");

		cat01_pic46 = new Array<String>();
		cat01_pic46.add("");

		cat01_pic47 = new Array<String>();
		cat01_pic47.add("");

		cat01_pic48 = new Array<String>();
		cat01_pic48.add("");

		cat01_pic49 = new Array<String>();
		cat01_pic49.add("Waffles");

		cat01_pic50 = new Array<String>();
		cat01_pic50.add("");
/*
		cat01_pic51 = new Array<String>();
		cat01_pic51.add("");

		cat01_pic52 = new Array<String>();
		cat01_pic52.add("");

		cat01_pic53 = new Array<String>();
		cat01_pic53.add("");

		cat01_pic54 = new Array<String>();
		cat01_pic54.add("");

		cat01_pic55 = new Array<String>();
		cat01_pic55.add("");

		cat01_pic56 = new Array<String>();
		cat01_pic56.add("");

		cat01_pic57 = new Array<String>();
		cat01_pic57.add("");

		cat01_pic58 = new Array<String>();
		cat01_pic58.add("");

		cat01_pic59 = new Array<String>();
		cat01_pic59.add("");

		cat01_pic60 = new Array<String>();
		cat01_pic60.add("");

		cat01_pic61 = new Array<String>();
		cat01_pic61.add("");

		cat01_pic62 = new Array<String>();
		cat01_pic62.add("");

		cat01_pic63 = new Array<String>();
		cat01_pic63.add("");

		cat01_pic64 = new Array<String>();
		cat01_pic64.add("");
	
		cat01_pic65 = new Array<String>();
		cat01_pic65.add("");

		cat01_pic66 = new Array<String>();
		cat01_pic66.add("");

		cat01_pic67 = new Array<String>();
		cat01_pic67.add("");

		cat01_pic68 = new Array<String>();
		cat01_pic68.add("");

		cat01_pic69 = new Array<String>();
		cat01_pic69.add("");

		cat01_pic70 = new Array<String>();
		cat01_pic70.add("");

		cat01_pic71 = new Array<String>();
		cat01_pic71.add("");

		cat01_pic72 = new Array<String>();
		cat01_pic72.add("");

		cat01_pic73 = new Array<String>();
		cat01_pic73.add("");

		cat01_pic74 = new Array<String>();
		cat01_pic74.add("");
	
		cat01_pic75 = new Array<String>();
		cat01_pic75.add("");

		cat01_pic76 = new Array<String>();
		cat01_pic76.add("");
	
		cat01_pic77 = new Array<String>();
		cat01_pic77.add("");

		cat01_pic78 = new Array<String>();
		cat01_pic78.add("");

		cat01_pic79 = new Array<String>();
		cat01_pic79.add("");

		cat01_pic80 = new Array<String>();
		cat01_pic80.add("");

		cat01_pic81 = new Array<String>();
		cat01_pic81.add("");

		cat01_pic82 = new Array<String>();
		cat01_pic82.add("");

		cat01_pic83 = new Array<String>();
		cat01_pic83.add("");

		cat01_pic84 = new Array<String>();
		cat01_pic84.add("");

		cat01_pic85 = new Array<String>();
		cat01_pic85.add("");

		cat01_pic86 = new Array<String>();
		cat01_pic86.add("");

		cat01_pic87 = new Array<String>();
		cat01_pic87.add("");

		cat01_pic88 = new Array<String>();
		cat01_pic88.add("");

		cat01_pic89 = new Array<String>();
		cat01_pic89.add("");

		cat01_pic90 = new Array<String>();
		cat01_pic90.add("");

		cat01_pic91 = new Array<String>();
		cat01_pic91.add("");
	
		cat01_pic92 = new Array<String>();
		cat01_pic92.add("");

		cat01_pic93 = new Array<String>();
		cat01_pic93.add("");

		cat01_pic94 = new Array<String>();
		cat01_pic94.add("");

		cat01_pic95 = new Array<String>();
		cat01_pic95.add("");

		cat01_pic96 = new Array<String>();
		cat01_pic96.add("");

		cat01_pic97 = new Array<String>();
		cat01_pic97.add("");

		cat01_pic98 = new Array<String>();
		cat01_pic98.add("");
	
		cat01_pic99 = new Array<String>();
		cat01_pic99.add("");

		cat01_pic100 = new Array<String>();
		cat01_pic100.add("");
*/
		
		cat01.put("Raw Asparagus", cat01_pic00);
		cat01.put("Cooked Asparagus", cat01_pic01);
		cat01.put("pic02", cat01_pic02);
		cat01.put("Blueberries", cat01_pic03);
		cat01.put("pic01", cat01_pic04);
		cat01.put("Loaf of Bread", cat01_pic05);
		cat01.put("pic01", cat01_pic06);
		cat01.put("Tomatoes", cat01_pic07);
		cat01.put("pic01", cat01_pic08);
		cat01.put("pic01", cat01_pic09);
		cat01.put("French Fries", cat01_pic10);
		cat01.put("Cup of Coffee", cat01_pic11);
		cat01.put("pic01", cat01_pic12);
		cat01.put("pic01", cat01_pic13);
		cat01.put("pic01", cat01_pic14);
		cat01.put("Guacamole", cat01_pic15);
		cat01.put("pic01", cat01_pic16);
		cat01.put("pic01", cat01_pic17);
		cat01.put("pic01", cat01_pic18);
		cat01.put("Kidney Beans", cat01_pic19);
		cat01.put("Kiwi", cat01_pic20);
		cat01.put("Nachos", cat01_pic21);
		cat01.put("Noodles", cat01_pic22);
		cat01.put("Flowers", cat01_pic23);
		cat01.put("Salad", cat01_pic24);
		cat01.put("Noodle Bowl", cat01_pic25);
		cat01.put("pic01", cat01_pic26);
		cat01.put("Corn", cat01_pic27);
		cat01.put("Cooked Onions", cat01_pic28);
		cat01.put("Salmon", cat01_pic29);
		cat01.put("Swiss Cheese", cat01_pic30);
		cat01.put("Gummy Bears", cat01_pic31);
		cat01.put("pic01", cat01_pic32);
		cat01.put("pic01", cat01_pic33);
		cat01.put("Apples", cat01_pic34);
		cat01.put("pic01", cat01_pic35);
		cat01.put("Hotdog", cat01_pic36);
		cat01.put("Pear", cat01_pic37);
		cat01.put("Strawberries", cat01_pic38);
		cat01.put("Maple Syrup", cat01_pic39);
		cat01.put("pic01", cat01_pic40);
		cat01.put("pic01", cat01_pic41);
		cat01.put("Grapefruit", cat01_pic42);
		cat01.put("pic01", cat01_pic43);
		cat01.put("Carrot Shreds", cat01_pic44);
		cat01.put("Sugar Cubes", cat01_pic45);
		cat01.put("pic01", cat01_pic46);
		cat01.put("pic01", cat01_pic47);
		cat01.put("pic01", cat01_pic48);
		cat01.put("Waffles", cat01_pic49);
		cat01.put("pic01", cat01_pic50);
/*		cat01.put("pic01", cat01_pic51);
		cat01.put("pic02", cat01_pic52);
		cat01.put("pic01", cat01_pic53);
		cat01.put("pic01", cat01_pic54);
		cat01.put("pic01", cat01_pic55);
		cat01.put("pic01", cat01_pic56);
		cat01.put("pic01", cat01_pic57);
		cat01.put("pic01", cat01_pic58);
		cat01.put("pic01", cat01_pic59);
		cat01.put("pic01", cat01_pic60);
		cat01.put("pic01", cat01_pic61);
		cat01.put("pic01", cat01_pic62);
		cat01.put("pic01", cat01_pic63);
		cat01.put("pic01", cat01_pic64);
		cat01.put("pic01", cat01_pic65);
		cat01.put("pic01", cat01_pic66);
		cat01.put("pic01", cat01_pic67);
		cat01.put("pic01", cat01_pic68);
		cat01.put("pic01", cat01_pic69);
		cat01.put("pic01", cat01_pic70);
		cat01.put("pic01", cat01_pic71);
		cat01.put("pic01", cat01_pic72);
		cat01.put("pic01", cat01_pic73);
		cat01.put("pic01", cat01_pic74);
		cat01.put("pic01", cat01_pic75);
		cat01.put("pic01", cat01_pic76);
		cat01.put("pic01", cat01_pic77);
		cat01.put("pic01", cat01_pic78);
		cat01.put("pic01", cat01_pic79);
		cat01.put("pic01", cat01_pic80);
		cat01.put("pic01", cat01_pic81);
		cat01.put("pic01", cat01_pic82);
		cat01.put("pic01", cat01_pic83);
		cat01.put("pic01", cat01_pic84);
		cat01.put("pic01", cat01_pic85);
		cat01.put("pic01", cat01_pic86);
		cat01.put("pic01", cat01_pic87);
		cat01.put("pic01", cat01_pic88);
		cat01.put("pic01", cat01_pic89);
		cat01.put("pic01", cat01_pic90);
		cat01.put("pic01", cat01_pic91);
		cat01.put("pic01", cat01_pic92);
		cat01.put("pic01", cat01_pic93);
		cat01.put("pic01", cat01_pic94);
		cat01.put("pic01", cat01_pic95);
		cat01.put("pic01", cat01_pic96);
		cat01.put("pic01", cat01_pic97);
		cat01.put("pic01", cat01_pic98);
		cat01.put("pic01", cat01_pic99);
		cat01.put("pic01", cat01_pic100);
*/
	}

	private void cat02() {
		cat02 = new ObjectMap<String, Array<String>>();

	}

}
